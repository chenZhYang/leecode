package com.aaronchen.leecode.surfacearea;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/25 22:06
 */
public class SolutionA extends Solution {

    /**
     * 首先：不要管啥立体图表面积，我们只要一个柱体一个柱体的来看就行啦，每个柱体都是有：
     *     2个底面（上表面/下表面）+ 所有的正方体都贡献了4个侧表面积
     *
     * 然后：把柱体贴合在一起之后，我们需要把贴合的表面积给减掉：
     *     2个柱体贴合的表面积就是  两个柱体高的最小值*2
     * @param grid
     * @return
     */
    @Override
    public int surfaceArea(int[][] grid) {
        int n = grid.length, area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 先把grid[i][j]赋值给level，省掉了bound check，可以略微略微略微优化一下耗时...
                int level = grid[i][j];
                if (level > 0) {
                    // 一个柱体中：2个底面 + 所有的正方体都贡献了4个侧表面积
                    area += (level << 2) + 2;
                    // 减掉 i 与 i-1 相贴的两份表面积
                    area -= i > 0? Math.min(level, grid[i - 1][j]) << 1: 0;
                    // 减掉 j 与 j-1 相贴的两份表面积
                    area -= j > 0? Math.min(level, grid[i][j - 1]) << 1: 0;
                }
            }
        }
        return area;
    }
}
