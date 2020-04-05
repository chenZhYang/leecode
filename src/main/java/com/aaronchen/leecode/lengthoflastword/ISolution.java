package com.aaronchen.leecode.lengthoflastword;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/5 22:09
 */
public class ISolution extends Solution {

    @Override
    public int lengthOfLastWord(String s) {
        if(s == null || "".equals(s.trim())){
            return 0;
        }
        s = s.trim();
        int len = s.lastIndexOf(" ");
        if(len == -1){
            return s.length();
        }
        return s.length() - len -1;
    }
}
