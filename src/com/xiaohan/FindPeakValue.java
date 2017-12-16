package com.xiaohan;

public class FindPeakValue {


    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        Main.print(findPeakValue(nums));

    }





    public static int findPeakValue(int[] nums){

        for(int i = 0; i < nums.length; i ++) {
            if (i == nums.length - 1) {
                return i;
            }
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return 0;
    }
}
