package com.leetcode;

public class SudokuChecker {

    public static void main(String[] args) {
        int[][] sMatrix={

                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
        };


        checker(sMatrix);
    }




    static boolean checker(int[][] grid){

        for(int i=0; i < grid.length; i++){
            int[] checkModelRow = new int[10];   //initilise array
            int[] checkModelColumn = new int[10];   //initilise array
            int[] checkModelSqaure = new int[10];   //initilise array
            for(int j=0; j < grid.length; j++){
                //check the horizontal line
                int rowNum = grid[i][j];
                if(checkModelRow[rowNum] == 0) {
                    checkModelRow[rowNum] = 1;
                }else{
                    System.out.printf("cell %d %d incorrect in row \n", i, j);
                    return false;
                }

                int columnNum = grid[j][i];  //BRAVO!!!
                if(checkModelColumn[columnNum] == 0) {
                    checkModelColumn[columnNum] = 1;
                }else{
                    System.out.printf("cell %d %d incorrect in column \n", j, i);
                    return false;
                }

                //i for locate the specific square
                //j for locate the specific cell
                //i/3*3 => row complement, j/3 => the actual cell (can only be 0,1,2)
//                0 1 2 => 0
//                3 4 5 => 1
//                6 7 8 => 2

                //i%3*3 => column complement, j%3 => the actual cell (can only be 0,1,2)
                int squareNum = grid[i/3*3 + j/3][i%3*3 + j%3];
                if(checkModelSqaure[squareNum] == 0) {
                    checkModelSqaure[squareNum] = 1;
                }else{
                    System.out.printf("cell %d %d incorrect in sqaure \n", j, i);
                    return false;
                }
            }
        }
        System.out.println("correct");
        return true;
    }


}
