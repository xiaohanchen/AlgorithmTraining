package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinPathSumInTriangle {

//https://stomachache007.wordpress.com/2017/04/09/%E4%B9%9D%E7%AB%A0%E7%AE%97%E6%B3%95%E7%AC%94%E8%AE%B0-9-%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92-dynamic-programming/

    //1 DFS  (or backtracking), which list out all possibility
                //DFS(x+1,y, sum); DFS(x+1, y+1, sum);   O(2^n)
    //2. Divide & Conquer:
                //return triangle[x][y] + min(DC(x+1, y), DC(x+1, y+1));    O(2^n)


    //3. Divide and Conquer 加 memorization   (so without duplication calculation)
    //2 DP: when traverse through each node, find the current optimal path with smallest sum  O(n^2)   n is the length of triangle   or O(n) n is the num of nodes



    public static void main(String[] args) {

        int[][] triangle = {{1},
                            {2,3},
                            {5,6,7},
                            {10,5,1,8}};

        minPath(triangle);


    }


    public static DPRecord[][] minPath(int[][] triangle){

        DPRecord[][] record = new DPRecord[triangle.length][triangle.length];
        for(int x=0; x < triangle.length; x ++){
            for(int y=0; y < triangle[x].length; y++){
                if(x == 0){
                    DPRecord newRecord = new DPRecord(triangle[x][y]);
                    newRecord.preNodes.add(triangle[x][y]);
                    record[x][y] = newRecord;
                }else{
                    int minSum = Integer.MAX_VALUE;
                    List minPath = new ArrayList();
                    DPRecord newRecord = new DPRecord(minSum);
                    record[x][y] = newRecord;

                    if(y-1 >= 0){
                        int tempSUm = record[x-1][y-1].sum + triangle[x][y];
                        if(tempSUm < minSum){
                            minSum = tempSUm;
                            minPath.addAll(record[x-1][y-1].preNodes);
                            minPath.add(triangle[x][y]);
                            newRecord.sum = minSum;
                            newRecord.preNodes.addAll(minPath);
                        }
                    }

                    if(y < triangle[x-1].length){
                        int tempSUm = record[x-1][y].sum + triangle[x][y];
                        if(tempSUm < minSum){
                            minSum = tempSUm;
                            minPath.addAll(record[x-1][y].preNodes);
                            minPath.add(triangle[x][y]);
                            newRecord.sum = minSum;
                            newRecord.preNodes.addAll(minPath);
                        }
                    }

                }
            }
        }


        return record;

    }




}



class DPRecord{
    int sum;
    List preNodes = new ArrayList();
    DPRecord(int sum){
        this.sum = sum;
    }

}
