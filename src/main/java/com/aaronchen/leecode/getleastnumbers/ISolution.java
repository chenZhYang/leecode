package com.aaronchen.leecode.getleastnumbers;

import com.aaronchen.leecode.solution.Solution;

import java.util.Arrays;


/**
 * @Author: Aaron chen
 * @Date: 2020/3/20 23:14
 */
public class ISolution extends Solution {

    /**
     * 使用Arrays.sort排序
     * @param arr
     * @param k
     * @return
     */
    @Override
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        Arrays.sort(arr);
        int[] ints = new int[k];
        for(int i = 0;i<k;i++){
            ints[i] = arr[i];
        }
        return ints;
    }

    /**
     * 使用快速排序
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.copyOf(arr,k);
        return null;
    }


}
