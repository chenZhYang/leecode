package com.aaronchen.leecode.myatoi;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/3 22:52
 */
public class Test {

    public static void main(String[] args) {
        ISolution iSolution = new ISolution();
        int i = iSolution.myAtoi("    +0a32");
        System.out.println(i);
    }
}
