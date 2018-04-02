package com.leetcode;

public class ReverseString {


    public static void main(String[] args) {

        String str = "abcdefg";

        char[] chars = str.toCharArray();
        char[] reversedChars = new char[chars.length];

        for(int i=0; i < chars.length; i++){
            reversedChars[i] = chars[chars.length - 1 - i];
        }

        String reversedStr = new String(reversedChars);
        Main.print(reversedStr);

    }
}
