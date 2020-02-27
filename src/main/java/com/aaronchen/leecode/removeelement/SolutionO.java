package com.aaronchen.leecode.removeelement;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/27 23:06
 */
public class SolutionO extends Solution {
    /**
     * 算法
     * 当我们遇到 nums[i] = val时，我们可以将当前元素与最后一个元素进行交换，
     * 并释放最后一个元素。这实际上使数组的大小减少了 1。
     * 请注意，被交换的最后一个元素可能是您想要移除的值。
     * 但是不要担心，在下一次迭代中，我们仍然会检查这个元素。
     * @param nums
     * @param val
     * @return
     */
    @Override
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
