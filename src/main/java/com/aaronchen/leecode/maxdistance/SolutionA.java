package com.aaronchen.leecode.maxdistance;

import com.aaronchen.leecode.solution.Solution;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/29 21:09
 */
public class SolutionA extends Solution {

    /**
     * 使用BFS广度遍历算法
     * @param grid
     * @return
     */
    @Override
    public int maxDistance(int[][] grid) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid.length;j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        // 全是海洋或者全是陆地，返回-1。
        if (queue.size() == 0 || queue.size() == grid.length * grid.length) {
            return -1;
        }
        //从陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        int[] point = null;
        while (!queue.isEmpty()){
            point = queue.poll();
            int x = point[0],y = point[1];
            for (int i = 0;i<dx.length;i++){
                int tx = x + dx[i];
                int ty = y + dy[i];
                if(tx < 0 || ty < 0 || tx >= grid.length || ty >= grid.length || grid[tx][ty] != 0){
                    continue;
                }
                //修改海洋坐标的值，以免重复遍历,同时该值为曼哈顿距离（也就是每个坐标上下左右位移都会加1）
                grid[tx][ty] = grid[x][y] + 1;
                queue.offer(new int[]{tx,ty});
            }
        }
        // 返回最后一次遍历到的海洋的距离。
        return grid[point[0]][point[1]] - 1;
    }
}
