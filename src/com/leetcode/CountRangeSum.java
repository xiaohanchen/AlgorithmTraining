package com.leetcode;

public class CountRangeSum {


    public static void main(String[] args) {
        //use merge sort!
        int[] nums = {1,2,3,4,5,6,7};
        int[] sums = new int[nums.length];

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sums[i] = sum;
        }

        int result = countRangeSum(nums, 0, nums.length -1);

    }

    public static int countRangeSum(int[] nums, int lower, int upper) {




        return 0;
    }

}
