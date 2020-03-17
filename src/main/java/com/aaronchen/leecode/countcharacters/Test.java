package com.aaronchen.leecode.countcharacters;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/17 23:45
 */
public class Test {
    public static void main(String[] args) {
        String[] words = {"hyiozy"};
        SolutionA solutionA = new SolutionA();
        int i = solutionA.countCharacters(words,"ilumzpopwlhlky");
        System.out.println(i);
    }
}
