package com.aaronchen.leecode.minimumlengthencoding;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/28 21:51
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new SolutionA();
        String[] array = {"time","me","hello"};
        int i = solution.minimumLengthEncoding(array);
        System.out.println(i);
    }
}
