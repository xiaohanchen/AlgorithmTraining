package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueSubString {


    //467. Unique Substrings in Wraparound String!!!!!!!!!!  very intersting
    //size of p might be over 10000.
    public static void main(String[] args) {

//        findSubstringInWraproundString("cac");
        findSubstringInWraproundString("zaba");

    }


    public static int findSubstringInWraproundString(String p) {

        if(p.length() == 0){
            return 0;
        }
        String wrapString = "abcdefghijklmnopqrstuvwxyz";
        char[] wrapStringArray = wrapString.toCharArray();
        char[] pArray = p.toCharArray();

        int currCharIndex = wrapString.indexOf(pArray[0]);
        Set<String> matchedSet = new HashSet();
        List<Integer> headIndexOfMatchedStrings = new ArrayList();
        int pArrayIndex = 0;
        int matchedCount = 0;
        int ongoingMatchedSet = 0;
        while(pArrayIndex < pArray.length){
            if(currCharIndex == wrapStringArray.length){
                currCharIndex = 0;
            }

            if(wrapStringArray[currCharIndex] == pArray[pArrayIndex]){
                ongoingMatchedSet += 1;
                headIndexOfMatchedStrings.add(pArrayIndex);

                String longestMatch = p.substring(headIndexOfMatchedStrings.get(0), pArrayIndex+1);

                //zaba
                if(!matchedSet.contains(longestMatch)){  //TODO should check for each letter, what is the longest match num
                    //if there are 3 ongoing matched set e.g. abc,bc,c
                    //then when we reach d, we could extend each of set, new substrings are abcd, bcd,cd,d
                    matchedCount += ongoingMatchedSet;
                    matchedSet.add(longestMatch);
                }
                pArrayIndex++;
                currCharIndex ++;
            }else{ //match break
                ongoingMatchedSet = 0;
                headIndexOfMatchedStrings.clear();
                currCharIndex = wrapString.indexOf(pArray[pArrayIndex]);
            }

        }

        return matchedCount;

    }




    public int findSubstringInWraproundStringII(String p) {
        // count[i] is the maximum unique substring end with ith letter.
        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
        int[] count = new int[26];
        int maxLengthCur = 0;

        for (int i = 0; i < p.length(); i++) {
            int len = 1;
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25)))
                maxLengthCur++;
            else
                maxLengthCur = 1;

            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);    //Notice the MAX
        }

        // Sum to get result
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }


}
