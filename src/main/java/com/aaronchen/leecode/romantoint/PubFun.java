package com.aaronchen.leecode.romantoint;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/24 0:59
 * 公共函数
 */
public class PubFun {
    public static int rToiByS(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
