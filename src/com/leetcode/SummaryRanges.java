package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {


    public static void main(String[] args) {
        int[] input1 = {0,1,2,4,5,7};
        summaryRanges(input1);
    }


    public static List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }else if(nums.length == 1){
            res.add( String.valueOf(nums[0]));
            return res;
        }

        int lastNum = Integer.MIN_VALUE;   //TODO how to initialise the int?????
        boolean moreThanOne = false;
        String tempRes = "";
        for(int i = 0; i < nums.length; i++){
            int curNum = nums[i];
            if(i == 0){
                lastNum = curNum;
                tempRes = String.valueOf(curNum);

                continue;
            }
            if(curNum == lastNum+1) {
                moreThanOne = true;
            }else{
                //old range breaks
                addToRes(res, lastNum, moreThanOne, tempRes);
                tempRes = String.valueOf(curNum);
                moreThanOne = false;
            }
            lastNum = curNum;

            if(i == nums.length -1 ){
                addToRes(res, lastNum, moreThanOne, tempRes);
            }
        }

        return res;
    }

    private static void addToRes(List<String> res, int lastNum, boolean moreThanOne, String tempRes) {
        if(moreThanOne){
            tempRes =  tempRes + "->" + lastNum;
        }
        res.add(tempRes);
    }
}
