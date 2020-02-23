package com.aaronchen.leecode.romantoint;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/24 0:53
 */
public class SolutionO extends Solution {
    @Override
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = PubFun.rToiByS(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = PubFun.rToiByS(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
}
