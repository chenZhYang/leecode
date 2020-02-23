package com.aaronchen.leecode.reverse;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/23 23:31
 * 官方优解
 */
public class SolutionO extends Solution {
    /**
     * 复杂度分析
     * 时间复杂度：O(log(x))，x 中大约有 log{10}(x) 位数字。
     * 空间复杂度：O(1)。
     * @param x
     * @return
     */
    @Override
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
