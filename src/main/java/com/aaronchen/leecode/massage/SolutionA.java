package com.aaronchen.leecode.massage;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/24 22:04
 * 思维：
 * 1. 如果我们接第n个预约的话，由于相邻的预约不能接，
 * 所以dp[n] = dp[n - 2] + nums[n]（即等于到第n-2个预约的最大时长 +
 * 第n个预约的时长）；
 * 2.  反之如果我们不接第n个预约的话，那么dp[n] = d[n - 1]
 * （即等于到第n - 1个预约的最大时长）。
 *
 * 根据以上得到了状态转移方程：
 * dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
 */
public class SolutionA extends Solution {

    /**
     * 代码思维：
     * 用a表示 i - 2，b表示 i - 1，
     * 因此上面的方程变成了dp[i] = max(b, a + nums[i])，
     * 然后下一轮循环的时候：
     *  i - 1 就变成了i - 2，因此现在需要把b赋值给a；
     *  i 就变成了i - 1，因此现在需要把dp[i]赋值给b。
     * @param nums
     * @return
     */
    @Override
    public int massage(int[] nums) {
        int a = 0, b = 0;
        for(int i = 0;i<nums.length;i++){
            int val = Math.max(b,a+nums[i]);
            a = b;
            b = val;
        }
        return b;
    }

    public int massage1(int[] nums) {
        int n = nums.length;
        // 处理边界条件。
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        // 定义dp数组，按照状态转移方程递推。
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
