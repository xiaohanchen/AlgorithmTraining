package com.leetcode;

import java.util.Stack;

public class LongestFilePath {



    //TODO most important thing here is to use: split(), .lastIndexOf

    public static void main(String[] args) {

    }


    static public int lengthLongestPath(String input){
        String newLine = "\\n";
        String newTabl = "\\t";

        String maxPath = "";
        String tempPath = "";

        Stack fileStack = new Stack();
        int stackCount = fileStack.size();
        int filePathLevel = 0; // \n\t\t is level 3

        while(input.length() != 0){
            int i = 0;
            String tempString = "";
            while(input.charAt(i) != '\\'){
                tempString += input.charAt(i) ;
                i++;
            }
            //store tempString into stack depends on the stack level
            //check if it is filename or dirName
            fileStack.push(tempString);

            //fileflevel 2, stackCount4, so pop out 3, then push
//            if()

            //found \n, so skip all \n and \t
            //assign filePathLevel
//            input.




        }

        return 0;
    }
}
