package com.leetcode;

public class StringToInt {

    public static void main(String[] args) {

        Main.print(myAtoi("-kjhsd"));
    }


    public static int myAtoi(String str) {

        int sum = 0;
        str = str.trim();

        if (str.length() == 0) {
            return sum;
        }

        char[] strArray = str.toCharArray();
        boolean isPostive = strArray[0] == '+' ? true : false;   //注意正负符号

        for (int i = 1; i < str.length(); i++) {
            sum = sum * 10 + Character.getNumericValue(new Character(strArray[i]));
        }

        return isPostive ? sum : -sum;

    }


    public static int myStringtoi(String str) {


        return 0;
    }

}
