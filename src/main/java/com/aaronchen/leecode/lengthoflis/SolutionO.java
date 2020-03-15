package com.aaronchen.leecode.lengthoflis;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/15 1:37
 */
public class SolutionO extends Solution {

    /**
     * 动态规划
     *复杂度分析
     * 时间复杂度：O(n^2)，其中 n 为数组 nums 的长度。
     * 动态规划的状态数为 n，计算状态 dp[i]时，需要 O(n) 的时间遍历 dp[0…i−1] 的所有状态，
     * 所以总时间复杂度为 O(n^2)。
     * 空间复杂度：O(n)，需要额外使用长度为 n 的 dp 数组。
     * @param nums
     * @return
     */
    @Override
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
