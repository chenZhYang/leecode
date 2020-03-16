package com.aaronchen.leecode.compressstring;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/16 22:32
 */
public class Test {
    public static void main(String[] args) {
        String s = "abbccd";
        ISolution iSolution = new ISolution();
        String sa = iSolution.compressString(s);
        System.out.println(sa);
    }
}
