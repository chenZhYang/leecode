package com.aaronchen.leecode.coinchange;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/10 0:17
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new SolutionA();
        int[] coins = {2,5,8};
        int num = solution.coinChange(coins,9);
        System.out.println(num);
    }
}
