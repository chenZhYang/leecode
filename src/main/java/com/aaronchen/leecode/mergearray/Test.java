package com.aaronchen.leecode.mergearray;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/3 23:27
 */
public class Test {
    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        SolutionA iSolution = new SolutionA();
        iSolution.mergeArray(A,3,B,3);
    }
}
