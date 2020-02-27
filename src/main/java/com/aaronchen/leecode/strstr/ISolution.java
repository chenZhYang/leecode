package com.aaronchen.leecode.strstr;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/27 23:32
 * 利用KMP算法计算
 */
public class ISolution extends Solution {
    @Override
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || needle.equals("")) {
            return 0;
        }
        int i = 1;
        int j = 1;
        int[] next = getNext(needle);
        while (i <= haystack.length() && j <= needle.length()) {
            if (j == 0 || haystack.charAt(i-1) == needle.charAt(j-1)) {
                ++i;
                ++j;
            }else {
                j = next[j];
            }
        }
        if(j > needle.length()){
            return i-needle.length()-1;
        }
        return -1;
    }

    /**
     * 计算next数组
     * @param str
     * @return
     */
    public int[] getNext(String str){
        char[] chars = str.toCharArray();
        int i = 1,j = 0;
        int[] next = new int[str.length()+1];
        //第一个字符的next值是0, 假设数组next是从1开始的算，next[0]不用
        next[1] = 0;
        while (i < chars.length) {
            if (j == 0 || chars[i-1] == chars[j-1]) {
                next[++i] = ++j;
            }else {
                j = next[j];
            }
        }
        return next;
    }
}
