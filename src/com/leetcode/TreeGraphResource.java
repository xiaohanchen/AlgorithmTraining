package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeGraphResource {

    static LinkedList<Integer> linkedList = new LinkedList<>();

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
/*
        //              1
        //          2
        //      3      6
        //  4        7
        //5            8
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;

        node2.right = node6;
        node6.left = node7;
        node7.right = node8;

        treeToLinkedlist(node1);
*/



        //              20
        //          10
        //      8       16
        //  6        12
        //1           15
        TreeNode nodeA = new TreeNode(20);
        TreeNode nodeB = new TreeNode(10);
        TreeNode nodeC = new TreeNode(8);
        TreeNode nodeD = new TreeNode(6);
        TreeNode nodeE = new TreeNode(1);
        TreeNode nodeF = new TreeNode(16);
        TreeNode nodeG = new TreeNode(12);
        TreeNode nodeH = new TreeNode(15);

        nodeA.left = nodeB;
        nodeB.left = nodeC;
        nodeC.left = nodeD;
        nodeD.left = nodeE;

        nodeB.right = nodeF;
        nodeF.left = nodeG;
        nodeG.right = nodeH;

//        boolean isBST = checkIfBST(nodeA, Integer.MIN_VALUE, Integer.MAX_VALUE);

        ArrayList<Integer> list = new ArrayList<>();
        getTreeValuesInArray(nodeA, list);
        return;

    }

    static void getTreeValuesInArray(TreeNode node, ArrayList<Integer> list){

        if(node == null){
            return;
        }

        getTreeValuesInArray(node.left,list);
        list.add(node.val);
        getTreeValuesInArray(node.right, list);

    }





    static void treeToLinkedlist(TreeNode node){

        if(node == null){
            return;
        }

        treeToLinkedlist(node.left);
        linkedList.add(node.val);
        treeToLinkedlist(node.right);
    }





    static boolean checkIfBST(TreeNode node, int min, int max){
        if(node == null){
            return true;
        }

        if(node.val > min && node.val < max){
            return checkIfBST(node.left, min, node.val) && checkIfBST(node.right, node.val, max);
        }else{
            return false;
        }
    }

}
