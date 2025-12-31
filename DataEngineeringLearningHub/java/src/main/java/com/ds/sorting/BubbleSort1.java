package com.ds.sorting;

import java.util.Arrays;

public class BubbleSort1 {

    public static void main(String[] args){
        int[] arr= {7,12,9,11,4};
        int[] my_array = {64, 34, 25, 12, 22, 11, 90, 5};
        bubbleSort(arr);
        bubbleSort(my_array);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(my_array));


    }

    private static void bubbleSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                }
            }
        }


    }
}
