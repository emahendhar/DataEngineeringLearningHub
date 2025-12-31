package com.ds.strings;

import java.util.Arrays;

public class FreqStringcount {

    public static void main(String[] args) {
        String stg="geeksforgeeks";
        int[] count= new int[26];
        System.out.println(Arrays.toString(count));

        for(int i=0;i<stg.length();i++){
            count[stg.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++){
            if(count[i]>0)
                System.out.println((char)(i+'a')+" "    + count[i]);
        }
    }


}
