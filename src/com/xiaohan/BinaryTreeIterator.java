package com.xiaohan;

import java.util.Stack;

public class BinaryTreeIterator {



    //Note: next() and hasNext() should run in **AVERAGE** O(1)  (有时候是O(n)超出一点也没关系) time and uses O(h) memory, where h is the height of the tree.

    //O(1) is the quickest time we can have, average O(1) means we allows some exceptions that taking more than constant time


    public class BSTIterator {

        private Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            TreeNode cur = root;
            while(cur != null){
                stack.push(cur);
                if(cur.left != null)
                    cur = cur.left;
                else
                    break;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            TreeNode cur = node;
            // traversal right branch
            if(cur.right != null){
                cur = cur.right;
                while(cur != null){
                    stack.push(cur);
                    if(cur.left != null)
                        cur = cur.left;
                    else
                        break;
                }
            }
            return node.val;
        }
    }


}



class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }