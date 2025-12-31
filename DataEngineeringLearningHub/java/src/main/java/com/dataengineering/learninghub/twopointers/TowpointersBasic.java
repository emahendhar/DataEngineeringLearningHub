package com.dataengineering.learninghub.twopointers;

import java.util.Arrays;

public class TowpointersBasic {



    /*
    two pointers at opposite diretions
    int left =0;
    int right=array.length-1



    while(left<right){

    if(cond){ left++; }
    else if(cond) { right --; }
    else left++; right--;

    }
     */



    //Two sum array


    public static int[] twoSum(int[] nums,int target){

        int left=0;
        int right= nums.length-1;

        while(left<right){
            int sum= nums[left]+nums[right];

            if(sum==target){
                return new int[]{left,right};
            }else if(sum<target){
                left++;
            }else{
                right--;
            }

        }



        return new int[]{-1,-1};
    }



    public static boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;

        while(left<right){

            //skip non alphanumeric from left

            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            //compare case sensitive
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }



        return true;
    }



    // reverse char array

    public static void reversString(char[] s){
     int left=0;
     int right=s.length-1;

     while (left<right){

         char temp= s[left];
         s[left] = s[right];
         s[right]= temp;

         left++;
         right--;
     }

    }







    // remove duplilcate from sorted array






    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] results = twoSum(nums,9);
        System.out.println(Arrays.toString(results));

        // isPalindram or nt string


        System.out.println(isPalindrome(" A Man, a Plan, a canal: panama"));
        System.out.println(isPalindrome("race a car"));

//reverse string
        char[] s = {'h','e','l','l','o'};
        reversString(s);
        System.out.println(Arrays.toString(s));


        // remove duplicates form sorted array
        int[] sortarr={1,1,2,2,3,3,3,4};


        int length= removeduplicates(sortarr);
        System.out.println(length);
        for(int i=0;i<length;i++){
            System.out.print(sortarr[i]+i<length-1?",":"");
        }

    }

    public static int removeduplicates(int[] sortarr) {

        int left=0;
        if(sortarr.length==0) return  0;

        for(int right=1;right<sortarr.length;right++){
            if(sortarr[right]!=sortarr[left]){
                left++;
                sortarr[left]=sortarr[right];
            }

        }
        return left+1;
    }
}
