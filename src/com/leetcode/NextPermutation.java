package com.leetcode;

public class NextPermutation {
//leetcode31: Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//1,2,3 → 1,3,2 -> 2,1,3
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1

//156732 -> 256731 -> 216735


// Idea: 1. in order to make the nums a little bit larger, traverse from right to left (LSP to MSP),
// find the first nums[i-1] < nums[i]  (e.g. 765243, which is 2) , This would make the MSP of the increased amount smallest
// 2. to minimise the rest part of increased amount, always put the smallest number into MSP
//MSP: most significant position


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return;
        }
        int swapedIndex = n -1;
        while(swapedIndex>0){
            if(nums[swapedIndex-1]<nums[swapedIndex])
                break;
            swapedIndex--;
        }
        if (swapedIndex ==0){
            reverseArray(0, nums.length-1, nums);
            return;
        }

        //after swappedIndex, all the nums are "descending"
        int swapedValueLarge = nums[swapedIndex];
        int swapedValueSmall = nums[swapedIndex-1];

        for(int i = nums.length - 1 ; i >= swapedIndex; i --){
            if( nums[i] > swapedValueSmall){
                swapValues(i, swapedIndex-1, nums);
                reverseArray(swapedIndex+1, nums.length-1, nums);
                return;
            }
        }

    }

    static void swapValues(int indexOne, int indexTwo, int[] array1) {
        int temp = array1[indexOne];
        array1[indexOne] = array1[indexTwo];
        array1[indexTwo] = temp;
    }


    static void reverseArray(int start, int end, int[] nums){
        for(int i = start; i <= (start+end)/2; i++)   //N.B.!!!!!!!!!!!
        {
            swapValues(i, start + end-i, nums);
        }
    }


}
