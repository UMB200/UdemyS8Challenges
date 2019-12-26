package com.UmidJavaUdemy;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// Create a program using arrays that sorts a list of integers in descending order.
// Descending order is highest value to lowest.
// In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
// ultimately have an array with 106,81,26, 15, 5 in it.
// Set up the program so that the numbers to sort are read in from the keyboard.
// Implement the following methods - getIntegers, printArray, and sortIntegers
// getIntegers returns an array of entered integers from keyboard
// printArray prints out the contents of the array
// and sortIntegers should sort the array and return a new array containing the sorted numbers
// you will have to figure out how to copy the array elements from the passed array into a new
// array and sort them and return the new sorted array.
public class ArrayChallenge99 {
    public static int[] getArray(int n){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + n +" integers\r");
        int[] enteredInts = new int[n];
        while (true){
            boolean isInt = scanner.hasNextInt();
            if(isInt){
                for(int i = 0; i < enteredInts.length;i++){
                    enteredInts[i] = scanner.nextInt();
                }
                return enteredInts;
            }
        }
    }
    public static int[] sortArray(int[] array){
        return Arrays.stream(array).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
    public static void printArray(){
        int[] myArray = getArray(5);
        for(int i =0; i < myArray.length; i++){
            System.out.println("Element " + i + " was " + myArray[i]);
        }
        //System.out.println("Descending sorted array is " + Arrays.toString(sortArray(myArray)));
        System.out.println("Descending sorted array is " + Arrays.toString(sortArrayUdemy(myArray)));
    }
    public static int[] sortArrayUdemy(int[] array){
        int[] sortedArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            sortedArray[i] = array[i];
        }
        boolean flag = true;
        int temp;
        while (flag){
            flag = false;
            for(int i = 0; i < sortedArray.length-1; i++){
                if(sortedArray[i] < sortedArray[i+1]){
                    temp = sortedArray[i];
                    System.out.println("Temp value of array is " + temp);
                    sortedArray[i] = sortedArray[i+1];
                    //System.out.println("Sorted array is "+ Arrays.toString(sortedArray));
                    sortedArray[i+1] = temp;
                    System.out.println("Sorted array after change is "+ Arrays.toString(sortedArray));
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
