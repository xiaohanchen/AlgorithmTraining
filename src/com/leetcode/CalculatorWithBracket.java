package com.leetcode;

public class CalculatorWithBracket {


    public static void main(String[] args) {

//        calculate("1-(2+ 3)");
//        calculate("(1-(3-4))");
        calculate("12 +1");
    }




    public static int calculate(String s) {

        //find the innermost bracket

        //binary tree?

        char[] chars = s.toCharArray();
        int currentIdx = 0;
        char sign = ' ';
        int sum = 0;
        while(currentIdx < chars.length){
            char currentChar = chars[currentIdx];
            if(currentChar == ' '){
                currentIdx++;
                continue;
            }

            if(currentChar == '('){
                ReturnObj returnObj = valuateBracket(currentIdx+1, chars);
                int valueInBracket = returnObj.sum;
                int rightBracketIndex = returnObj.index;
                if(sign == '-'){
                    sum -= valueInBracket;
                }else{
                    sum += valueInBracket;
                }
                currentIdx = rightBracketIndex + 1;
                continue;
            }

            if(currentChar == '+' || currentChar == '-'){
                sign = currentChar;
                currentIdx ++;
                continue;
            }


            //here char is digit
            String digitStr="";
            digitStr += String.valueOf(currentChar);
            while(currentIdx+1 < chars.length && Character.isDigit(chars[currentIdx+1]) ){
                currentIdx ++;
                digitStr += String.valueOf(chars[currentIdx]);
            }
            int digit = Integer.valueOf(digitStr);

            if(sign == '-'){
                sum -= digit;
            }else{
                sum += digit;
            }
            currentIdx ++;
        }


        return sum;
    }


    static ReturnObj valuateBracket(int index, char[] chars){


        int currentIdx = index;
        char sign = ' ';
        int sum = 0;
        while(currentIdx < chars.length){
            char currentChar = chars[currentIdx];

            if(currentChar == ')'){
                return new ReturnObj(currentIdx, sum);
            }
            if(currentChar == ' '){
                currentIdx++;
                continue;
            }

            if(currentChar == '('){
                ReturnObj returnObj = valuateBracket(currentIdx+1, chars);
                int valueInBracket = returnObj.sum;
                int rightBracketIndex = returnObj.index;
                if(sign == '-'){
                    sum -= valueInBracket;
                }else{
                    sum += valueInBracket;
                }
                currentIdx = rightBracketIndex + 1;
                continue;
            }

            if(currentChar == '+' || currentChar == '-'){
                sign = currentChar;
                currentIdx ++;
                continue;
            }

            //here char is digit
            String digitStr="";
            digitStr += String.valueOf(currentChar);
            while(currentIdx+1 < chars.length && Character.isDigit(chars[currentIdx+1]) ){
                currentIdx ++;
                digitStr += String.valueOf(chars[currentIdx]);
            }
            int digit = Integer.valueOf(digitStr);
            if(sign == '-'){
                sum -= digit;
            }else{
                sum += digit;
            }
            currentIdx ++;
        }


        return null;
    }


}

class ReturnObj{
    int index;
    int sum;
    ReturnObj(int index, int sum){
        this.index = index;
        this.sum = sum;

    }
}
