package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

//Given a digit string, return all possible letter combinations that the number could represent.

//    Input:Digit string "23"
//    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    public static void main(String[] args) {
//        letterCombinations("123");
        letterCombinations("23");
    }


    public static List<String> letterCombinations(String digits) {

        String[] charMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};   //otherwise use hashmap
        ArrayList<String> letterCombinations = new ArrayList();
        char[] chars = digits.toCharArray();

        for(int i = 0; i < chars.length; i ++){

            int digit = Character.getNumericValue(chars[i]); //USEFUL!!
            String mappedChars = charMap[digit];

            if(letterCombinations.size() == 0){
                for(char singleChar : mappedChars.toCharArray()){
                    letterCombinations.add(Character.toString(singleChar));
                }
            }else{
                ArrayList<String> tempLetterCombinations = new ArrayList();
                for(int j = 0; j < letterCombinations.size(); j++){
                    for(char singleChar : mappedChars.toCharArray()){
                        tempLetterCombinations.add(letterCombinations.get(j) + singleChar);
                    }
                }
                letterCombinations.clear();
                letterCombinations.addAll(tempLetterCombinations);
            }
        }
        return letterCombinations;
    }



    public List<String> letterCombinationsFIFO(String digits) {
        //FIFO queue, especially useful when you want to process every elements in the list
        //and you want to add some more into the original array!!!!
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

}
