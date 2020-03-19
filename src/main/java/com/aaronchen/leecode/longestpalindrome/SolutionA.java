package com.aaronchen.leecode.longestpalindrome;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/19 22:27
 */
public class SolutionA extends Solution {

    @Override
    public int longestPalindrome(String s) {
        int[] array = new int[58];
        for(char c:s.toCharArray()){
            array[c-'A']++;
        }
        int max = 0;
        for(int i:array){
            //i-(i & 1)实现整数i奇数减一，偶数不变的功能
            max += i-(i & 1);
        }
        return max < s.length() ? max + 1 : max ;
    }
}
