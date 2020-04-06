package com.aaronchen.leecode.plusone;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/6 21:26
 */
public class ISolution extends Solution {

    @Override
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i >= 0;i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] nums = new int[digits.length+1];
        nums[0] = 1;
        return nums;
    }
}
