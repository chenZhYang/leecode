package com.aaronchen.leecode.orangesrotting;

import com.aaronchen.leecode.solution.Solution;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/4 23:33
 */
public class SolutionO extends Solution {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    /**
     * 复杂度分析
     *
     * 时间复杂度：O(nm)
     * 即进行一次广度优先搜索的时间，其中 n=grid.length, m=grid[0].lengthm。
     *
     * 空间复杂度：O(nm)
     * 需要额外的 dis 数组记录每个新鲜橘子被腐烂的最短时间，大小为 O(nm)，
     * 且广度优先搜索中队列里存放的状态最多不会超过 nm 个，最多需要 O(nm) 的空间，
     * 所以最后的空间复杂度为 O(nm)。
     * @param grid
     * @return
     */
    @Override
    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        // queue : all starting cells with rotten oranges
        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> depth = new HashMap();
        for (int r = 0; r < R; ++r){
            for (int c = 0; c < C; ++c){
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row: grid){
            for (int v: row){
                if (v == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}
