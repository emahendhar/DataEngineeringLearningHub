package com.dataengineering.learninghub.ds_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayReverse {

    public static void main(String[] args) {
        int arr[] =  {1,4,3,6,7,8};
      //tempArrayReverse(arr);
        twoPointerReverse(arr);
        System.out.println(Arrays.toString(arr));

        // buildin

        List<Integer> arr1 =
                new ArrayList<>(Arrays.asList(1, 4, 3, 2, 6, 5));
        Collections.reverse(arr1);
        System.out.println(arr1);

    }


    //reverseArray temp

    static void tempArrayReverse(int[] arr){

        int n=arr.length;
        int[] temp = new int[n];

        for(int i=0;i<n;i++){
            temp[i]=arr[n-i-1];
        }

        for(int j=0;j<n;j++){
            arr[j]=temp[j];
        }
    }


    //using two pointers

    static void twoPointerReverse(int[] arr){

        int left=0;  // start index
        int right=arr.length-1;  // end index


        // iterate left is less than right

        while(left<right){
            //swap the elements
            int temp = arr[left];
            arr[left]= arr[right];
            arr[right] = temp;

            // increment left and decrement right pointer
            left++;

            right--;
        }


    }

}


