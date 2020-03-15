package com.aaronchen.leecode.lengthoflis;

import com.aaronchen.leecode.solution.Solution;

import java.util.Arrays;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/15 1:11
 */
public class SolutionA extends Solution {

    /**
     * 维护一个结果数组，如果当前元素比结果数组的值都大的的话，
     * 就追加在结果数组后面（相当于递增序列长度加了1）；
     * 否则的话用当前元素覆盖掉第一个比它大的元素
     * （这样做的话后续递增序列才有可能更长，即使并没有更长，
     * 这个覆盖操作也并没有副作用哈，
     * 当然这个覆盖操作可能会让最终的结果数组值并不是最终的递增序列值，
     * 这无所谓）
     * @param nums
     * @return
     */
    @Override
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int len = 0;
        for (int num: nums) {
            int idx = Arrays.binarySearch(res, 0, len, num);
            idx = idx < 0? -idx - 1: idx;
            res[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
    }
}
