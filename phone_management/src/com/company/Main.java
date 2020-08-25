package com.company;
import java.util.Date;
import java.util.Scanner;

public class Main {
    //Methods
    public static void getHeading(){
        System.out.println( "**********************************************************************************************************************");
        System.out.println("WELCOME TO PHONE BILL COMPARISON SYSTEM\n");
        System.out.println("Developed by Bishal Bista,");
        System.out.println("OODP101 Object Oriented Design and Programming");
        Date current  = new Date();
        System.out.println("" + current);
        System.out.println("**********************************************************************************************************************" );
    }
    public static int getMainMenu(){
        Scanner myObj = new Scanner(System.in);
        int optNum;
        System.out.println("\nMAIN MENU\n");
        System.out.println("Please select from the Menu:");
        System.out.println("1. Enter Usage Details");
        System.out.println("2. Display Cost Under Provider 1");
        System.out.println("3. Display Cost Under Provider 2");
        System.out.println("4. Display Cost Under Provider 3");
        System.out.println("5. Clear Usage Details");
        System.out.println("6. Exit System");
        System.out.println("\nEnter Your Selection:");
        optNum = myObj.nextInt();
        return  optNum;
    }
    public static int getDataUsageMenu(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nENTER USAGE DETAILS MENU:\n");
        System.out.println("Please select an option from the menu:");
        System.out.println("1. Phone Call");
        System.out.println("2. SMS");
        System.out.println("3. Data Usage");
        System.out.println("4. Return to main menu");

        System.out.println("\nEnter Your Selection:");
        int userdetails = myObj.nextInt();
        return userdetails;
    }
    public static double getProviderDetails(double callCost, double timeOVerPhone, double smsCost, double mbCost, int callNum, int smsNum, int callLength, int DataUsageNum, int ProviderNum){
        double TotalCost;
        //price according to the Provider rate
        double PriceOfCall = callNum*callCost;
        double PriceOfSms = smsNum*smsCost;
        double PriceOfCallLength = callLength*timeOVerPhone;
        double PriceOfDataUsage = DataUsageNum*mbCost;
        TotalCost = (PriceOfCall+PriceOfCallLength+PriceOfSms+PriceOfDataUsage);
        //print details
        System.out.println(" Cost under Provider" + ProviderNum);
        System.out.println ( "**********************************************************************************************************************");
        System.out.println("Number of Calls = " + callNum + "\t\t\t\t\t$" + PriceOfCall);
        System.out.println(" Total call time(secs) = " + callLength + "\t\t\t$" + PriceOfCallLength);
        System.out.println(" Number of SMS = " + smsNum + "\t\t\t\t\t$" + PriceOfSms);
        System.out.println(" Data Usage = " + DataUsageNum + "\t\t\t\t\t$" + PriceOfDataUsage);
        System.out.println ( "**********************************************************************************************************************");
        System.out.println("TOTAL COST\t\t\t\t\t\t\t" + "$" + TotalCost );
        return TotalCost;
    }
    public static void CompareProviders(double a,double b,double c){
        if(a>b && a> c){
            System.out.println("Provider1 is expensive.");
        }
        else if(b>a && b >c){
            System.out.println("Provider2 is expensive.");
        }
        else if(c>a && c>b){
            System.out.println("Provider3 is  expensive .");
        }
        if(a<b && a<c){
            System.out.println("Provider1 is cheapest .");
        }
        if(b<a && b <c){
            System.out.println("Provider2 is cheapest .");
        }
        if(c<a && c<b){
            System.out.println("Provider3 is  cheapest.");
        }
    }

    //Main Function
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int main_options,data_options,DataUsageNum = 0;
        //variables
        int callLength = 0;
        int callNum=0;
        int smsNum=0;
        int newDataNum = 0;
        int newCallLength = 0;
        double TotalCost1 = 0;
        double TotalCost2 = 0;
        double TotalCost3 = 0;
        double[] TotalCost = new double[3];  //Array containing all providers total cost
        //Print heading
        getHeading();

            do{
                MainMenu:{
                main_options = getMainMenu();
            switch (main_options){
                case 1: {
                    do{
                        DataUsuage: {
                    data_options = getDataUsageMenu();
                    switch (data_options){
                        case 1:{
                            System.out.println("Enter Call Length in Second:");
                            newCallLength = myObj.nextInt();
                            callLength += newCallLength; //updating calllength as per user entries.
                            System.out.println ( "Total number of calls so far: " + ++callNum);     //to increase call number as per user entry.
                        }
                        break;
                        case 2: {
                            System.out.println ( "Total number of sms so far: " + ++smsNum);  //to increase sms number as per user entry.
                        }
                        break;
                        case 3:{
                            System.out.println("Enter amount of data in MB:");

                            newDataNum = myObj.nextInt();
                            if(newDataNum>=0){
                                DataUsageNum += newDataNum;  //updating DataUsageNum each time user enter new value
                                System.out.println ( "Data amount so far: " + DataUsageNum);
                            }else{

                                System.out.println("value most be a positive number");
                            }
                        }
                        break;
                        case 4:{

                        }
                        break MainMenu;
                        default: {
                            System.out.println("value most be between 1 and 4.");
                        }
                    }}}while(data_options<4);

                }
                break;
                case 2:{
                    //data rate for provider 1 are:
                    int providerNum = 1;
                    double callCost = 0.20;
                    double timeOVerPhone = 0.03;
                    double smsCost = 0.10;
                    double mbCost = 0.02;
                    TotalCost1 = getProviderDetails(callCost,
                            timeOVerPhone,
                            smsCost,
                            mbCost,
                            callNum,
                            smsNum,
                            callLength,
                            DataUsageNum,
                            providerNum);

                }
                break;
                case 3: {
                    //data rate for provider 2 are:
                    int providerNum = 2;
                    double callCost = 0.15;
                    double timeOVerPhone = 0.04;
                    double smsCost = 0.12;
                    double mbCost = 0.04;
                    TotalCost2 = getProviderDetails(callCost,
                            timeOVerPhone,
                            smsCost,
                            mbCost,
                            callNum,
                            smsNum,
                            callLength,
                            DataUsageNum,
                            providerNum);

                }
                break;
                case 4: {
                    //data rate for provider 3 are:
                    int providerNum = 3;
                    double callCost = 0.5;
                    double timeOVerPhone = 0.40;
                    double smsCost = 0.23;
                    double mbCost = 0.64;
                    TotalCost3 = getProviderDetails(callCost,
                            timeOVerPhone,
                            smsCost,
                            mbCost,
                            callNum,
                            smsNum,
                            callLength,
                            DataUsageNum,
                            providerNum);

                }
                break;
                case 5: {
                    //setting all variables values to 0
                    callNum = 0;
                    callLength = 0;
                    smsNum =0;
                    DataUsageNum = 0;
                    TotalCost1 = 0;
                    TotalCost2 = 0;
                    TotalCost3 = 0;

                    //output
                    System.out.println ( "**********************************************************************************************************************");
                    System.out.println("ALL USAGE DETAILS HAVE BEEN RESET TO 0.");
                    System.out.println ( "**********************************************************************************************************************");
                }
                break;
                case 6: {
                    //storing all provider total cost records in array
                    TotalCost[0] = TotalCost1;
                    TotalCost[1] = TotalCost2;
                    TotalCost[2] = TotalCost3;

                    //output
                    System.out.println ( "**********************************************************************************************************************");
                    System.out.println ( "Total Cost for provider 1 = $" + TotalCost[0]);
                    System.out.println  (" Total Cost for provider 2 = $" + TotalCost[1]);
                    System.out.println  (" Total Cost for provider 3 = $" + TotalCost[2]);
                    System.out.println ( "**********************************************************************************************************************");
                    CompareProviders(TotalCost[0],TotalCost[1],TotalCost[2]);
                    return;

                }
                default:{
                    System.out.println("Value must be between 1 and 6. Please try again.");

                }}}}while(main_options<7);

    }}