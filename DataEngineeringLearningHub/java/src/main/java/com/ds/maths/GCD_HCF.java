package com.ds.maths;

public class GCD_HCF {

    public static void main(String[] args) {

        int a=10,b=15;

        System.out.println(gcd(a,b));

    }
    //eulidaean algo

    private static int gcd(int a,int b){
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }
}
