package com.aaronchen.leecode.climbstairs;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/19 23:42
 * 动态规划
 */
public class SolutionA extends Solution {


    @Override
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int s1 = 1,s2 = 2;
        for(int i = 3;i<=n;i++){
            int temp = s1+s2;
            s1 = s2;
            s2 = temp;
        }
        return s2;
    }
}
