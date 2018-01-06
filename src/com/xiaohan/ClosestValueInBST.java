package com.xiaohan;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ClosestValueInBST {


    public static void main(String[] args) {

    }




    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new LinkedList<>();
        // populate the predecessor and successor stacks
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();

        TreeNode curr = root;
        while(curr != null){
            if(curr.val <= target){
                //getting larger but less than target
                pred.add(curr);
                curr = curr.right;
            }else{
                //getting smaller but more than target
                succ.add(curr);
                curr = curr.left;
            }
        }

        while (k-- > 0){
            int value;
            if(pred.empty()){
                value = getSuccessor(succ);
            }else if(succ.empty()){
                value = getPredecessor(pred);
            }else if (Math.abs(target - pred.peek().val) < Math.abs(target - succ.peek().val)) {
                value = getPredecessor(pred);
            } else {
                value = getSuccessor(succ);
            }

            //TODO below is incorrect, have to use peek!!!!
//            else{
//                int successor = getSuccessor(succ);
//                int predecessor= getPredecessor(pred);
//                value = Math.abs(successor - target) > Math.abs(predecessor - target) ? predecessor : successor;
//            }
            result.add(value);
        }

        return result;
    }


    private int getPredecessor(Stack<TreeNode> st) {
        TreeNode curr = st.pop();
        int result = curr.val;

        //find its subnodes which is smaller but close to it
        curr = curr.left;
        while (curr != null){
            st.push(curr.right);
            curr = curr.right;
        }
        return result;
    }

    private int getSuccessor(Stack<TreeNode> st) {
        TreeNode popped = st.pop();
        TreeNode p = popped.right;
        while (p != null) {
            st.push(p);
            p = p.left;
        }
        return popped.val;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
