package com.aaronchen.leecode.movingcount;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/8 23:53
 */
public class SolutionA extends Solution {

    boolean[][] visited;
    @Override
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }

    private int dfs(int x, int y, int m, int n, int k) {
        if (x >= m || y >= n || visited[x][y]
                || (x % 10 + x / 10 + y % 10 + y / 10) > k) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y, m, n, k) + dfs(x, y + 1, m, n, k);
    }
}
