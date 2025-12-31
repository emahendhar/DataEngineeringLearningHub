package com.ds.maths;

public class CountDigits {

    public static void main(String[] args){

        int digit = 56780;

        int digitCount=count(digit);
        System.out.println(digitCount);

    }

    private static int count(int digit) {

        int res=0;
        while(digit>0){
            digit=digit/10;
            res++;
        }
        return res;
    }


}
