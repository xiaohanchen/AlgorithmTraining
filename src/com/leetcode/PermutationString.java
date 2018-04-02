package com.leetcode;

import java.util.ArrayList;

public class PermutationString {


    public static void main(String[] args) {

        String str = "abcd";


        Main.print(permutation(str));
    }


    static ArrayList<String> permutation(String str){
        ArrayList<String> rest = new ArrayList<>();
        if (str.length() == 0) { // base case
            rest.add("");
            return rest;
        }

        char removedChar = str.charAt(0);
        String restStr = str.substring(1);
        ArrayList<String> permutations = permutation(restStr);

        for(String perm: permutations ){
            for (int j = 0; j <= perm.length(); j++) {
                rest.add(insertCharAt(perm, removedChar, j));
            }
        }
        return rest;
    }

    public static String insertCharAt(String str, char c, int i) {
        String start = str.substring(0, i);
        String end = str.substring(i);
        return start + c + end;
    }

}
