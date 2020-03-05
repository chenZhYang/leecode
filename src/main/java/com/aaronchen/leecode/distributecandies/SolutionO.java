package com.aaronchen.leecode.distributecandies;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/5 23:23
 */
public class SolutionO extends Solution {

    /**
     * 时间复杂度：O(N)，计算 N 个人的糖果数量。
     *
     * 空间复杂度：O(1)，，除了答案数组只需要常数空间来存储若干变量。
     * @param candies
     * @param num_people
     * @return
     */
    @Override
    public int[] distributeCandies(int candies, int num_people) {
        int n = num_people;
        // how many people received complete gifts
        int p = (int)(Math.sqrt(2 * candies + 0.25) - 0.5);
        int remaining = (int)(candies - (p + 1) * p * 0.5);
        int rows = p / n, cols = p % n;

        int[] d = new int[n];
        for(int i = 0; i < n; ++i) {
            // complete rows
            d[i] = (i + 1) * rows + (int)(rows * (rows - 1) * 0.5) * n;
            // cols in the last row
            if (i < cols){
                d[i] += i + 1 + rows * n;
            }
        }
        // remaining candies
        d[cols] += remaining;
        return d;
    }
}
