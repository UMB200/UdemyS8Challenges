package com.UmidJavaUdemy;
import java.util.ArrayList;
import java.util.Scanner;
public class ExamplesShown {
    private static Scanner scanner = new Scanner(System.in);
    public static int[] getIntArray(int n){
        System.out.println("Enter "+ n + " integers \r");
        int[] enteredValue = new int[n];
        for(int i =0; i < enteredValue.length; i++){
            enteredValue[i] = scanner.nextInt();
        }
        return enteredValue;
    }
    public static double getAvg(int[] array){
        int interimSum =0;
        for(int i=0; i< array.length; i++){
            interimSum += array[i];

        }
        return (double)interimSum/(double) array.length;
    }
    public void showMetod(){
        int[] myArray = new int[25];
//	    for (int i =0; i < myArray.length; i++){
//	        myArray[i] = i *5;
//        }
//	    printArray(myArray);
        int[] intArray = getIntArray(5);
        for(int i =0; i < intArray.length; i++){
            System.out.println("Element " + i + " was " + intArray[i]);
        }
        System.out.println("Average is " + getAvg(intArray));
    }

    ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
    public void boxingExampleInt() {
        for (int i = 0; i <= 10; i++) {
            integerArrayList.add(i);
            System.out.println(i + " -> " + integerArrayList.get(i));
        }

    }
    public void boxingExampleDouble(){
        ArrayList<Double> doubleArrayList = new ArrayList<Double>();
        for(double dbl = 0.0; dbl <=10; dbl+=0.5){
            doubleArrayList.add(dbl);

        }
        for(int i =0; i <doubleArrayList.size(); i++){
            double val = doubleArrayList.get(i);
            System.out.println(i + "->" + val);
        }
    }


}
