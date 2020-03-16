package com.aaronchen.leecode.maxsubarray;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/17 0:10
 */
public class SolutionA extends Solution {

    @Override
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int sum = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            sum = Math.max(sum + nums[i], nums[i]);
            ans = Math.max(sum , ans);
        }
        return ans;
    }
}
