package com.aaronchen.leecode.numrookcaptures;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/26 22:30
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new ISolution();
        char[][] chars = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        int s = solution.numRookCaptures(chars);
        System.out.println(s);
    }
}
