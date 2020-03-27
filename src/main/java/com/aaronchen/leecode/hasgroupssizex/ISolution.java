package com.aaronchen.leecode.hasgroupssizex;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/27 19:09
 */
public class ISolution extends Solution {

    @Override
    public boolean hasGroupsSizeX(int[] deck) {
        int X = 0;
        int[] nums = new int[10000];
        for(int i:deck){
            X = Math.min(X,++nums[i]);
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > 0){
                X = gcd(nums[i],X);
            }
        }
        return X >= 2 ? true : false;
    }

    private int gcd(int a,int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
