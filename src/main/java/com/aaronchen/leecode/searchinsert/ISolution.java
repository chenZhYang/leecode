package com.aaronchen.leecode.searchinsert;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/29 22:25
 */
public class ISolution extends Solution {

    /**
     * 直接使用二分查找算法
     * 如果查到有值相等则直接返回mid
     * 如果没查到相等值则返回low值，因为不管如何
     * @param nums
     * @param target
     * @return
     */
    @Override
    public int searchInsert(int[] nums, int target) {
        int low = 0,high = nums.length-1,mid = 0;
        while (low <= high) {
            //使用low+(high - low)/2是为了防止int溢出（high+low）有可能大于int最大值
            mid = low+(high - low)/2;
            if(target < nums[mid]){
                high = mid - 1;
            }else if(target > nums[mid]){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return low;
    }
}
