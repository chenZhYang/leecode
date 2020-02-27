package com.aaronchen.leecode.strstr;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/28 1:50
 */
public class Test {
    public static void main(String[] args) {
        ISolution iSolution = new ISolution();
        int i = iSolution.strStr("abxbcadfs","bca");
        System.out.println(i);
    }
}
