package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/*
Given words = ["oath","pea","eat","rain"] and board =

        [
        ['o','a','a','n'],
        ['e','t','a','e'],
        ['i','h','k','r'],
        ['i','f','l','v']
        ]

Return ["eat","oath"].
*/

public class WordSearch {


    Set<String> res = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {

        //word: cat, cattle??
        // return the largest amount of words?

        //TODO reduce the dictionary during the search, until find a match   - could be solved by word tree
        //TODO change the board's letters to -1 if found a match   - no need since one letter could used multiple times
        //TODO if found a match or not found, go to next letter   - keep searching even have found one word for scenario like:  cat cats 2 words
        //TODO add memorisation    - no memorisation required since only go through the map once.


        //create prefix tree
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        //go through each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                DFS(board, visited, "", i, j, trie);
            }
        }

        return new ArrayList<String>(res);
    }



    void DFS(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie){
        //DFS:
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;

        if(visited[x][y]){
           return;
        }

        str += board[x][y];
        if(!trie.startsWith(str)){
            return;
        }
        if(trie.search(str)){
            res.add(str);
        }

        //TODO if go left, couldnt go right in the next step    - could be solved by using hashset containing visited letters in these cycle or by setting board[i][j] = '#';
        visited[x][y] = true;
        //left
        DFS(board, visited, str, x-1, y, trie);
        //right
        DFS(board, visited, str, x+1, y, trie);
        //up
        DFS(board, visited, str, x, y-1, trie);
        //down
        DFS(board, visited, str, x, y+1, trie);
        visited[x][y] = false;

    }
}
