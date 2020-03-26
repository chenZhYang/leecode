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
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }

    /**
     * 针对递归调用不同版本，使用dx{1,-1,0,0}/dy{0，0,1,-1}两种数组来完成坐标的位移，
     * 1、坐标a（x,y）平行左移，x轴减少，y轴不变
     * 2、坐标a（x,y）平行右移，x轴增加，y轴不变
     * 3、坐标a（x,y）竖直上移，x轴不变，y轴增加
     * 4、坐标a（x,y）竖直下移，x轴不变，y轴减少
     * 因此，可以用dx{1,-1,0,0}/dy{0，0,1,-1}两种数组来分别表示坐标的上下左右移动时x/y轴值得变化
     * @param i
     * @param j
     * @param grid
     * @return
     */
    private int dfs(int i,int j,int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        for(int x = 0;x<dx.length;x++){
            num += dfs(i + dx[x],j+dy[x],grid);
        }
        return num;
    }
}
