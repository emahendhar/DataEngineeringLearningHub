package com.ds.maths;

public class PalindramDigit {

    public static void main(String[] args) {
        int num=8778;

        System.out.println(isPalindram(num));




    }

    private static boolean isPalindram(int num) {

        int res=0;
        int temp=num;
        while(temp>0){
            int ld=temp%10;
            res=res*10+ld;
            temp=temp/10;
        }

        System.out.println(res);
        return (res==num);
    }

}
