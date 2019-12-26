package com.UmidJavaUdemy;
import java.util.Arrays;
/* Write a method called reverse() with an int array as a parameter.
-The method should not return any value. In other words, the method is allowed to modify the array parameter.
-In main() test the reverse() method and print the array both reversed and non-reversed.
-To reverse the array, you have to swap the elements, so that the first element is swapped with the last element and so on.
-For example, if the array is {1, 2, 3, 4, 5}, then the reversed array is {5, 4, 3, 2, 1}.
 */
public class ReverseArrayChallenge {

    public void reverse(int[] testArray){
        System.out.println("Given array "+ Arrays.toString(testArray));
        //swap untill mid array since 2nd half is already swapped
        for(int i =0; i < testArray.length/2; i++){
            int temp = testArray[i];
            testArray[i] = testArray[testArray.length-i-1];
            testArray[testArray.length-i-1] = temp;
        }
        System.out.println("Reversed array " + Arrays.toString(testArray));
    }
}
