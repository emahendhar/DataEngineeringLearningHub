package com.ds.strings;

public class StringPalindram {
    public static void main(String[] args) {
        String str= "ABCBA";
        System.out.println(isPalNaive(str));
        System.out.println(iseffientPal(str));



    }

    private static boolean iseffientPal(String str) {

        int l=0,r=str.length()-1;

        while(l<r){
            if(str.charAt(l)!=str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    private static boolean isPalNaive(String str) {
        StringBuilder rev= new StringBuilder(str);
       rev.reverse();
        return str.equals(rev.toString());

    }
}
