package com.ds.maths;

public class TrailingZerosInFactorial {

    public static void main(String[] args) {
        int num=100;

/*        int res= fact(num);
        System.out.println(res);

        int count=0;
        while(res>0 && res%10==0){
            count++;
            res=res/10;
        }
        System.out.println(count);*/


        //efficient 1*2*3*4*5*6*7*8*9*10.....*25*....125.....  5 FACTORSS BECOMES 0'S

        int res = countTrailingzeros(num);
        System.out.println(res);



    }

    private static int countTrailingzeros(int num) {

        int res=0;
        for(int i=5;i<=num;i=i*5){
            res=res+num/i;

        }
        return res;
    }

    private static int fact(int num) {

        if(num==0)
            return 1;
        return num*fact(num-1);

    }
}
