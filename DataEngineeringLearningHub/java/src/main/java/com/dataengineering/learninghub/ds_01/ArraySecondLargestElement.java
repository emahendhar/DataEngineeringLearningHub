package com.dataengineering.learninghub.ds_01;


/*
Given an array of positive integers arr[] of size n, the task is to find second largest distinct element in the array.

Note: If the second largest element does not exist, return -1.

Examples:

Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.

Input: arr[] = [10, 5, 10]
Output: 5
Explanation: The largest element of the array is 10 and the second largest element is 5.

Input: arr[] = [10, 10, 10]
Output: -1
Explanation: The largest element of the array is 10 there is no second largest element.
 */

import java.util.Arrays;

public class ArraySecondLargestElement {


    public static void main(String[] args) {

        int[] arr = { 12, 35, 1, 10, 34, 1 };

        System.out.println(Arrays.toString(arr));
        System.out.println(secondLargestNative(arr));
        System.out.println(secondLargestTwoPass(arr));
        System.out.println(secondLargestOnepass(arr));

    }

    static int secondLargestNative(int[] arr){

        // Sort the array
        Arrays.sort(arr);
        int n=arr.length;
        //return first element which is not equal to the largest element
        for(int i=n-2;i>0;i--){
            if(arr[i]!=arr[n-1]){
                return arr[i];
            }

        }
            return -1;
    }



    static int secondLargestTwoPass(int[] arr){

        int n= arr.length;

        int largest=-1,secondLargest=-1;

        for(int i=0 ; i<n ;i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }


        for(int j=0;j<n;j++){
            if(arr[j] != largest && arr[j]>secondLargest){
                secondLargest=arr[j];
            }
        }



        return secondLargest;
    }


    //one pass


    static int secondLargestOnepass(int[] arr){

        int n= arr.length;

        int largest=-1,secondLargest=-1;

        for(int i=0;i<n;i++){

            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }else if( arr[i]!=largest && arr[i]> largest){
                secondLargest=arr[i];
            }
        }

        return secondLargest;
    }


}
