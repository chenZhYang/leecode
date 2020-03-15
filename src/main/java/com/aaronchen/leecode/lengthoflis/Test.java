package com.aaronchen.leecode.lengthoflis;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/15 1:54
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new SolutionO();
        int[] nums = {10,9,2,5,3,7,101,18};
        int n = solution.lengthOfLIS(nums);
        System.out.println(n);
    }
}
