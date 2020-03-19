package com.aaronchen.leecode.longestpalindrome;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/19 22:17
 */
public class SolutionO extends Solution {

    @Override
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray()){
            count[c]++;
        }
        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0){
                ans++;
            }

        }
        return ans;
    }
}
