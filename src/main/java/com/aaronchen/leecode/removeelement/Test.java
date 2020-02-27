package com.aaronchen.leecode.removeelement;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/27 22:01
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        ISolution iSolution = new ISolution();
        int z = iSolution.removeElement(nums,2);
        System.out.println(z);
        for (int i = 0;i < z;i++){
            System.out.println("输出："+nums[i]);
        }

    }
}
