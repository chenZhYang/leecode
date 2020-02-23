package com.aaronchen.leecode.validbrackets;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/23 1:54
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        ISolution iSolution = new ISolution();
        boolean flag = iSolution.isValid("(([]){})");
        System.out.println(flag);
    }
}
