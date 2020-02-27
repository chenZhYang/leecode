package com.aaronchen.leecode.removeduplicates;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/27 16:29
 */
public class Test {
    public static void main(String[] args) {
        int nums [] = {3,3,3,3,5,5,6,6,6,8,8,9};
        ISolution iSolution = new ISolution();
        int x = iSolution.removeDuplicates(nums);
        System.out.println(x);
        for (int i = 0;i < x;i++){
            System.out.println("输出："+nums[i]);
        }
    }
}
