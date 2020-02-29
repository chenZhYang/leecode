package com.aaronchen.leecode.searchinsert;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/29 22:45
 */
public class Test {
    public static void main(String[] args) {
        SolutionO solutionO = new SolutionO();
        int[] nums = {1,3,5,7};
        int i = solutionO.searchInsert(nums,6);
        System.out.println(i);
    }
}
