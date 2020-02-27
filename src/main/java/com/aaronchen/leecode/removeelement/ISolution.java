package com.aaronchen.leecode.removeelement;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/27 21:49
 */
public class ISolution extends Solution {

    @Override
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int x = 0;
        for (int i = 0;i < nums.length;i++){
            if(nums[i] != val){
                nums[x] = nums[i];
                x++;
            }
        }
        return x;
    }
}
