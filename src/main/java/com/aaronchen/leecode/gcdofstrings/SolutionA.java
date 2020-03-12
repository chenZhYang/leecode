package com.aaronchen.leecode.gcdofstrings;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/12 21:52
 */
public class SolutionA extends Solution {

    /**
     * 辗转相除法
     * @param str1
     * @param str2
     * @return
     */
    @Override
    public String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    private int gcd1(int a, int b) {
        while (b!=0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
}
