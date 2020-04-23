package com.aaronchen.leecode.mysqrt;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/12 22:14
 */
public class ISolution extends Solution {


    /**
     * 使用二分查找算法
     * @param x
     * @return
     */
    @Override
    public int mySqrt(int x) {
        if(x == 1){
            return x;
        }
        int min = 0;
        int max = x;
        while(max-min > 1){
            int mid = (max+min) / 2;
            if(x/mid < mid){
                max = mid;
            }else{
                min = mid;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        ISolution iSolution = new ISolution();
        int s = iSolution.mySqrt(Integer.MAX_VALUE);
        System.out.println(s);
    }
}
