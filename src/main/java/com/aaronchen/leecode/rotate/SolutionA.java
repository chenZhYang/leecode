package com.aaronchen.leecode.rotate;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/7 22:05
 */
public class SolutionA extends Solution {

    @Override
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //左右翻
        for(int i=0;i<len;i++){
            for(int j=0;j<len/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-1-j] = temp;
            }
        }
        //对角线翻转
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][len-1-i];
                matrix[len-1-j][len-1-i] = temp;
            }
        }
    }
}
