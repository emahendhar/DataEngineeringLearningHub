package com.ds.maths;

public class Factorial {

    public static void main(String[] args) {
        int facnum=5;

        int res = factorial(facnum);
        System.out.println(res);
        System.out.println(fact(facnum));
    }

    private static int fact(int facnum) {
        if(facnum==0)
            return 1;
        return facnum*fact(facnum-1);

    }

    private static int factorial(int facnum) {

        int res=1;
        for(int i=2;i<=facnum;i++){
            res=res*i;
        }
        return res;
    }
}
