package com.xiaohan;

import java.util.*;

public class BinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {


        //         1
        //     2     3
        //  4    5
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);

        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        List<String> treePath = printTree(tree);
        averageOfLevels(tree);
        for (String path : treePath){
            Main.print(path);
        }

    }


    public static List<String> printTree(TreeNode root) {
        List<String> resultPath = new ArrayList<>();
        if(root == null){
            return resultPath;
        }
        String nodePath =  root.val + "->";
        if(root.left != null){
            List<String> leftTreePathList = printTree(root.left);
            resultPath.addAll(leftTreePathList);
        }

        if(root.right != null) {
            List<String> rightTreePathList = printTree(root.right);
            resultPath.addAll(rightTreePathList);
        }


        if(resultPath.size() == 0){
            return Arrays.asList(root.val+"");
        }else{
            for(int i =0; i < resultPath.size(); i++){
                resultPath.set(i, nodePath + resultPath.get(i));    //use set!!!!  instead of array.get(i) = 5
            }
            return resultPath;
        }
    }




    /*FIND AVERAGE OF LEVELS*/

    //DFS
    //The range of node's value is in the range of 32-bit signed integer. max: 2^31 - 1
    //range of double is 64bits!!!
    public static List<Double> averageOfLevels(TreeNode root) {

        ArrayList<Double> averageOfLevel = new ArrayList<>();
        ArrayList<Double> sumOfLevel = new ArrayList<>();
        ArrayList<Integer> numOfLevel = new ArrayList<>();

        if(root == null){
            return averageOfLevel;
        }
        DFS(root, sumOfLevel, numOfLevel, 0);

        for(int i = 0; i < sumOfLevel.size(); i++){
            averageOfLevel.add( (sumOfLevel.get(i)) / numOfLevel.get(i));
        }

        return averageOfLevel;
    }


    public static void DFS(TreeNode root, ArrayList<Double> sumOfLevel, ArrayList<Integer> numOfLevel, int level) {
        if(root == null){
            return;
        }

        if(sumOfLevel.size()-1 < level){
            sumOfLevel.add((double)root.val);
            numOfLevel.add(1);
        }else{
            sumOfLevel.set(level, sumOfLevel.get(level) + root.val);
            numOfLevel.set(level, numOfLevel.get(level)+1);
        }

        DFS(root.left, sumOfLevel, numOfLevel, level + 1);  //search DEEP one branch firstly
        DFS(root.right, sumOfLevel, numOfLevel, level + 1);
    }


    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();  //BFS doesnt need recursion, just a queue to implement :)

        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();  //at this stage, the queue only contains nodes in the same level
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);    //find all neighbors   BFS
                if(node.right != null) q.offer(node.right);  //find all neighbors   BFS
                //at this stage, nodes in the next level are stored at the end of the queue
            }
            result.add(sum / n);
        }
        return result;
    }


    }
