package com.aaronchen.leecode.mergearray;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/3 22:49
 * 其他优解
 */
public class SolutionA extends Solution {
    /**
     * 思路:
     * 从后往前推，首先知道，两数组何必，最终数据长度下标肯定为 k = m+n-1
     * 因此可以先从两个数组最高位开始判断,A、B最高位下标分别为 i = m-1, j = n-1
     * 在 i 大于等于 0 和 j 大于等于的情况下执行下面操作
     *      若A[i] < B[j],则A[k] = B[j],此时B的下标前移一位 j-- , k的下标前移一位 k--;
     *      若A[i] < B[j],则A[k] = A[i],此时A的下标前移一位 j-- , k的下标前移一位 k--;
     * 接着判断 j 是否大于 0 ，若大于0，执行下面操作
     *      A[k] = B[j],此时B的下标前移一位 j-- , k的下标前移一位 k--;
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    @Override
    public void mergeArray(int[] A, int m, int[] B, int n) {
        int k = m+n-1,i=m-1,j=n-1;
        while(i>=0&&j>=0) {
            if (A[i]<B[j]) {
                A[k--]=B[j--];
            }else {
                A[k--]=A[i--];
            }
        }
        while(j>=0){
            A[k--]=B[j--];
        }
    }

}
