package com.aaronchen.leecode.removeduplicates;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/27 15:35
 */
public class ISolution extends Solution {
    @Override
    public int removeDuplicates(int[] nums) {
        int x = 0;
        for(int i = 0;i < nums.length;i++ ){
            if(nums[i] != nums[x]){
                nums[x+1] = nums[i];
                x++;
            }
        }
        return x+1;
    }
}
