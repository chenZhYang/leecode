package com.aaronchen.leecode.climbstairs;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/19 23:32
 * 深度遍历，递归，O(2^n)
 */
public class SolutionO extends Solution {


    @Override
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return dfs1(0,n,memo);
    }

    int dfs(int i,int n){
        if(i > n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        int num = 0;
        num += dfs(i+1,n);
        num += dfs(i+2,n);
        return num;
    }

    /**
     * 优化递归，使用额外数组
     * @param i
     * @param n
     * @return
     */

    int dfs1(int i,int n,int[]memo){
        if(i > n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        if(memo[i] > 0){
            return memo[i];
        }
        memo[i] = dfs1(i+1,n,memo) + dfs1(i+2,n,memo);
        return memo[i];
    }
}
