package com.aaronchen.leecode.reverse;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/23 23:39
 * 其他优解
 */
public class SolutionA extends Solution {
    @Override
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            //判断ans乘以10之后没有大于Integer.MAX_VALUE或小于Integer.MIN_VALUE
            //也就是首先判断本次计算有没有溢出
            if ((ans * 10) / 10 != ans) {
                return 0;
            }
            ans = x % 10 + ans * 10;
            x /= 10;
         }
        return ans;
    }
}
