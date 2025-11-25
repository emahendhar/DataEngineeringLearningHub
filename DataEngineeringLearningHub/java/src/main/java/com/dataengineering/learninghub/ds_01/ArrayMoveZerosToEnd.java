package com.dataengineering.learninghub.ds_01;

import java.util.Arrays;

public class ArrayMoveZerosToEnd {

    public static void main(String[] args) {
        int[] arr = {1,3,0,4,0,5,0,8,0,9};

        System.out.println(Arrays.toString(arr));
        //tempArrayZeros(arr);
        //pushzeroTwoloop(arr);
        pushZerosOneLoop(arr);
        System.out.println(Arrays.toString(arr));

    }

    //using temp array


    public static void tempArrayZeros(int[] arr){

        int n= arr.length;
        int[] temp = new int[n];

        int j=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                temp[j]=arr[i];
                j++;
            }
        }

        while(j<n){
            temp[j]=0;
            j++;
        }


        for(int k=0;k<n;k++){
            arr[k]=temp[k];
        }

    }



    public static void pushzeroTwoloop(int[] arr){

        int n=arr.length;
        int count=0;


        for(int i=0;i<n;i++){

            if(arr[i]!=0){
                arr[count++]=arr[i];
            }

        }
        while(count<n){
            arr[count++]=0;
        }

    }



    // one loop


    public static void pushZerosOneLoop(int[] arr){

        int n=arr.length;
        int count =0;

        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[count];
                arr[count]=temp;
                count++;
            }
        }


    }
}
