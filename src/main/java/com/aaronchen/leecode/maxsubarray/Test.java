package com.aaronchen.leecode.maxsubarray;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/17 0:38
 */
public class Test {
    public static void main(String[] args) {
        SolutionA solutionA = new SolutionA();
        int[] nums = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int i = solutionA.maxSubArray(nums);
        System.out.println(i);
    }
}
