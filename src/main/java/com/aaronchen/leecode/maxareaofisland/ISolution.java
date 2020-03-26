package com.aaronchen.leecode.maxareaofisland;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/27 2:10
 */
public class ISolution extends Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    @Override
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, area(i, j, grid));
                }
            }
        }
        return res;
    }

    private int area(int i,int j,int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        for(int x = 0;x<dx.length;x++){
            num += area(i + dx[x],j+dy[x],grid);
        }
        return num;
    }
}
