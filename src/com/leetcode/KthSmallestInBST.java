package com.leetcode;

public class KthSmallestInBST {

    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        //              1
        //          2
        //      3       6
        //  4       7
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

//        int count = leaveCount(node1.left, 0);
        int count = leaveCountFast(node1.left);

        traverse(node1, 0, 5, -1000000);
        Main.print(count);
    }
    public int kthSmallest(TreeNode root, int k) {

        return  0;
    }

    //should really keep sequence and res in the object, so that they wont be reverted when go back to previous stack
    public static int traverse(TreeNode node, int sequence, int k, int res) {
        //return the current root sequence
        if(node == null){
            return sequence;
        }

        sequence = traverse(node.left, sequence, k, res);
        //come back to this stack again, so need to add 1 sequence number!!!!!!!!!!!!
        sequence+=1;
        if(sequence == k){
            res = node.val;
        }
        sequence = traverse(node.right, sequence, k, res);
        return sequence;
    }


    public static int leaveCount(TreeNode node, int counter) {
        if(node == null){
            return counter;
        }else{
            counter++;
        }
        counter = leaveCount(node.left, counter);
        counter = leaveCount(node.right, counter);
        return counter;
    }

    public static int leaveCountFast(TreeNode node) {
        if(node == null) {  //the leaves of a null node is 0
            return 0;
        }
        return 1 + leaveCountFast(node.left) + leaveCountFast(node.right);
    }

}






    /*
        //              1
        //          2
        //      3
        //  4
        //5    6
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        node4.right = node6;
*/