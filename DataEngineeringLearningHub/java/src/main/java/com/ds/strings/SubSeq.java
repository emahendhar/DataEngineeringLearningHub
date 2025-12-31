package com.ds.strings;

public class SubSeq {
    public static void main(String[] args) {
        String s1 = "ABCDEF";
        String s2= "ADE";

        System.out.println(isSubSeq(s1,s2));
        System.out.println(isSubSeqRecursive(s1,s2,s1.length(),s2.length()));
    }

    private static boolean isSubSeqRecursive(String s1, String s2, int n, int m) {

        if(m==0)
            return true;
        if(n==0)
            return false;
        if(s1.charAt(n-1)==s2.charAt(m-1))
            return isSubSeqRecursive(s1,s2,n-1,m-1);
        else
            return isSubSeqRecursive(s1,s2,n-1,m);
    }

    private static boolean isSubSeq(String s1, String s2) {

        int j=0;
        for(int i=0;i<s1.length() && j<s2.length();i++){
            if(s1.charAt(i)==s2.charAt(j))
                j++;
        }
        return (j==s2.length());


    }
}
