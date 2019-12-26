package com.UmidJavaUdemy;
import java.util.Scanner;
/* -Write a method called readIntegers() with a parameter called count that represents how many integers the user needs to enter.
-The method needs to read from the console until all the numbers are entered, and then return an array containing the numbers entered.
-Write a method findMin() with the array as a parameter. The method needs to return the minimum value in the array.
-In the main() method read the count from the console and call the method readIntegers() with the count parameter.
-Then call the findMin() method passing the array returned from the call to the readIntegers() method.
-Finally, print the minimum element in the array.
Tips:
	-Assume that the user will only enter numbers, never letters
	-For simplicity, create a Scanner as a static field to help with data input
	-Create a new console project with the name MinElementChallenge */
public class MinElementChallenge {
    private static Scanner scanner = new Scanner(System.in);
    //create an array based on number entered by user
    private static int[] getArray(int count){
        System.out.println("Enter "  + count + " integers\r");
        int[] enteredInts = new int[count];
        for(int i = 0; i < enteredInts.length; i++){
            count++;
            enteredInts[i] = scanner.nextInt();
        }
        return enteredInts;
    }
    //find the minimal element of array
    private static int findMin(int[] array){
        int minValue = array[0];
        for(int i=  0; i <array.length; i++){
            if(array[i] < minValue){
                minValue = array[i];
            }
        }
        System.out.println("Min value for given array is " + minValue);
        return minValue;
    }
    //Call this method only from Main class
    public static void returnNumberOfCounts(){
        System.out.println("Enter number for array");
        int arrayLength =  scanner.nextInt(); // read user input and then pass as array length to getArray and then findMin from that
        findMin(getArray(arrayLength));
    }
}
