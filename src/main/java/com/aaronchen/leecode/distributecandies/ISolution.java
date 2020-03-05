package com.aaronchen.leecode.distributecandies;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/5 23:22
 */
public class ISolution extends Solution {

    @Override
    public int[] distributeCandies(int candies, int num_people) {
        int[] nums = new int[num_people];
        int n = 0;
        while(candies > 0){
            for(int i = 0;i < num_people;i++){
                n++;
                if(candies < n){
                    n = candies;
                }
                nums[i] += n;
                candies -= n;
            }
        }
        return nums;
    }
}
