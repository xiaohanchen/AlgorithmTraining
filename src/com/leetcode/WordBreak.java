package com.leetcode;

import java.util.*;

public class WordBreak {


    public static void main(String[] args) {

        String s = "leetcoded";
        List<String> wordDict = Arrays.asList("leet","code","co","ded");
//        wordBreakII(s, wordDict);
//        wordBreakDP(s, wordDict);
//        wordBreakIIDP(s, wordDict);


        String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict2 = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
//        wordBreak(s2, wordDict2);


        String s3 = "catsanddog";
        List<String> wordDict3 = Arrays.asList("cat", "cats", "and", "sand", "dog");
//        wordBreakII(s3, wordDict3);
//        wordBreakIIDP(s3, wordDict3);

        String s4 = "aaaaaaa";
        List<String> wordDict4 = Arrays.asList("aaaa","aaa");
        wordBreakIIDP(s4, wordDict4);


    }




    // This Algorithm's Time Complex is O(n^2), Space Complex is O(n)  (queue size), n is the length of string
    // for each node in the queue, we need to search through the string (  O(n)  )to find its neighbors
    // and there are aN node for the string, where 0 < a < 1
    //需要n个 loop 确定下一个node，一个String里有约n个node
    public static boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> bfsQueue = new LinkedList<>();
        Set<Integer> visitedIndex = new HashSet<>();   //constant time to use "contain" method because it is hash based set
        bfsQueue.add(0);
        visitedIndex.add(0);
        while (!bfsQueue.isEmpty()){
            int headIndex = bfsQueue.remove();
            for(int i = headIndex; i < s.length(); i++){
                String subString = s.substring(headIndex,i+1);     //LAST CHAR IN SUBSTRING IS at the index i-1
                if(!visitedIndex.contains(i+1) && wordDict.contains(subString)){
                    bfsQueue.add(i+1);        //BFS  store the next char (as the start of next matching word)
                    visitedIndex.add(i+1);    //avoid repeat search
                    if(i == s.length()-1){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public static boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] checklist = new boolean[s.length()+1];
        checklist[0] = true;
        char[] sChar = s.toCharArray();

        for(int i = 0; i < sChar.length; i++){
            for(int j = 0; j < i; j++){
                String subString = s.substring(j,i+1);
                if(checklist[j] && wordDict.contains(subString)){    //i is one place larger than the last char in the matching word
                    checklist[i+1] = true;
                    if(i+1 == s.length()){
                        return true;
                    }
                }
            }
        }
        return false;
    }




    /****************************** II ***************************************************/
    //this method will exceed time limit
    public static List<String> wordBreakII(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Node head = new Node(0, "");
        Queue<Node> bfsQueue = new LinkedList<>();
        Set<Integer> visitedIndex = new HashSet<>();   //constant time to use "contain" method because it is hash based set
        bfsQueue.add(head);
//        visitedIndex.add(0);
        while (!bfsQueue.isEmpty()){
            Node nodeToExplore= bfsQueue.remove();
            int headIndex = nodeToExplore.index;
            for(int i = headIndex; i < s.length(); i++){
                String subString = s.substring(headIndex,i+1);     //LAST CHAR IN SUBSTRING IS at the index i-1
//                if(!visitedIndex.contains(i+1) && wordDict.contains(subString)){
                if(wordDict.contains(subString)){
                    String matchedString = nodeToExplore.matchedString + " " + subString;
                    Node nodeToAdd = new Node(i+1, matchedString);
                    nodeToExplore.subNodes.add(nodeToAdd);
//                    visitedIndex.add(i+1);    //avoid repeat search
                    if(i == s.length()-1){    //search complete for one branch
                        nodeToAdd.wordBreakComplete = true;
                        result.add(matchedString.substring(1));  //remove first space
                    }else{
                        bfsQueue.add(nodeToAdd);        //BFS  store the next char (as the start of next matching word)
                    }
                }
            }
        }
        return result;
    }


    static class Node{
        int index;
        String matchedString;
        boolean wordBreakComplete;
        List<Node> subNodes = new ArrayList<>();
        Node(int index, String s){
            this.index = index;
            this.matchedString = s;
        }
    }




    public static List<String> wordBreakIIDP(String s, List<String> wordDict) {
        CheckNode[] checklist = new CheckNode[s.length()+1];
        CheckNode head = new CheckNode();
        head.matchedString.add("");
        checklist[0] = head;

        if(wordDict.isEmpty()){
            return new ArrayList<>();
        }
        char[] sChar = s.toCharArray();

        for(int i = 0; i < sChar.length; i++){
            for(int j = 0; j <= i; j++){
                String subString = s.substring(j,i+1);   //i is the last char in matched word
                if(checklist[j] != null && wordDict.contains(subString)){    //i is one place larger than the last char in the matching word
                    CheckNode checkNode = checklist[j];
                    CheckNode newCheckNode;
                    if(checklist[i+1] != null){
                        newCheckNode = checklist[i+1];
                    }else{
                        newCheckNode = new CheckNode();
                        checklist[i+1] = newCheckNode;
                    }

                    for(String str : checkNode.matchedString){
                        if(j==0){
                            newCheckNode.matchedString.add(subString);
                        }else{
                            newCheckNode.matchedString.add(str + " " + subString);
                        }
                    }
                }
            }
        }
        return checklist[s.length()] == null ? new ArrayList<String>() : checklist[s.length()].matchedString;
    }


    static class CheckNode{
        List<String> matchedString = new ArrayList<>();
    }

}
