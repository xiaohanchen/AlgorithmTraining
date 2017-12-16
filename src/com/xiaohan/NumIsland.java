package com.xiaohan;

//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//You may assume all four edges of the grid are all surrounded by water.

//11000
//11000
//00100
//00011

//3 islands


//Thinking: there is at least 1 island in the graph, so every 1 will eventually be part of the island (or island itself)

public class NumIsland {
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j); //search until find the edge of the island!!! AMAZING
                    ++count;
                }
        }
        return count;
    }


    //SUPER BEAUTIFUL PART!!!!
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';   //这是最精妙的一步，没有这一步，就会infinite loop
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}



