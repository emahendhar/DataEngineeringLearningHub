package com.ds.strings;

public class LeftMostrepeat {
    static int CHAR=256;
    public static void main(String[] args) {
        String str="cabbad";

        System.out.println(leftMostnaive(str));
        System.out.println(leftMostBetter(str));
    }

    private static int leftMostBetter(String str) {

        int count[] = new int[CHAR];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }

        for(int i=0;i<str.length();i++){
            if(count[str.charAt(i)]>1)
                return i;
        }
        return -1;
    }

    private static int leftMostnaive(String str) {
        int n=str.length();

        for(int i=0;i<n;i++){

            for(int j=i+1;j<n;j++){
                if(str.charAt(i)==str.charAt(j))
                    return i;
            }

        }

        return -1;


    }
}
