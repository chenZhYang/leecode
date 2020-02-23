package com.aaronchen.leecode.reverse;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/23 23:25
 */
public class ISolution extends Solution {
    /**
     * 整数型int
     * 最大数16进制表达式为：0x7fffffff
     * 最小数16进制表示为：0x80000000
     * @param x 进行反转的整数
     * @return 返回反转后的整数
     */
    @Override
    public int reverse(int x) {
        long l = 0;
        while (x != 0){
            l = l * 10 + x % 10;
            x = x / 10;
        }
        int max = 0x7fffffff, min = 0x80000000;
        return (l <= max && l >= min) ? (int)l:0;
    }
}
