package com.leetcode;

public class ImplementTri {

//ALSO CALLED PREFIX TREE

}


//class Trie {
//
//    char value;
//    List<Trie> subTries;   //at most 26
//
//    /** Initialize your data structure here. */
//    public Trie() {
//
//    }
//
//
//    Trie subTrieContainsLetter(char letter){
//        for (Trie trie : subTries){
//            if(trie.value == letter){
//                return trie;
//            }
//        }
//        return null;
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        if(word == null || word.length() == 0){
//            return;
//        }
//
//        char[] letters = word.toCharArray();
//        Trie nextTrie = subTrieContainsLetter(letters[0]);
//        if(nextTrie != null){
//            nextTrie.insert(word.substring(1));
//        }else{
//            Trie newTrie = new Trie();
//            newTrie.value = letters[0];
//            subTries.add(newTrie);
//        }
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//
//    }
//
//
//
class TrieNode {
    public char val;
    public boolean isWord;      //interesting!
    public TrieNode[] children = new TrieNode[26];   //a is at [0], so O(n) time
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

        /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}