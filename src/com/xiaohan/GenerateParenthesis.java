package com.xiaohan;
//
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//

/*
[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]
*/


//this problem represents a group a similar issues: list out all possibility:
//BACKTRACK is a good way to list out all possibility and choose the correct one

//Hint: we can only use right bracket if there is a left bracket exist
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesis {


    public static void main(String[] args) {
//        generateParenthesisBacktracking(100);
        generateParenthesisDP(10);
    }

    //DP
    // Actually, the result f(n) will be put an extra () pair to f(n-1).
    // Let the "(" always at the first position, to produce a valid result,
    // we can only put ")" in a way that there will be i pairs () inside the extra ()
    // and n - 1 - i pairs () outside the extra pair.

    //So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "(f(n-1)")"  不太懂
    public static List<String> generateParenthesisDP(int n) {

        List<List<String>> lists = new ArrayList<>();   //which contain the historical data
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();

            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }

            lists.add(list);
        }

        return lists.get(lists.size() - 1);
    }




    /*===============================================================================================*/
    /*===============================================================================================*/

    //complexity is at least O(2^n), since for every "(", we divide into two nodes
    public static List<String> generateParenthesisBacktracking(int n) {
        List<String> resultList = new ArrayList<>();
        addBracket(resultList, "(", 1, 0, n);
        return resultList;
    }


    public static void addBracket(List<String> result, String currentString, int leftBracketNum, int rightBracketNum, int n) {
        if(leftBracketNum == n && rightBracketNum == n){
            result.add(currentString);
            return;
        }
        if(leftBracketNum < n){
            addBracket(result, currentString + "(", leftBracketNum+1, rightBracketNum, n);
        }
        if(rightBracketNum < leftBracketNum){
            addBracket(result, currentString + ")", leftBracketNum, rightBracketNum+1, n);
        }
    }






}
