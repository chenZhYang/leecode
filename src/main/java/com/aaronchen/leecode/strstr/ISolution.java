package com.aaronchen.leecode.strstr;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/27 23:32
 * 利用KMP算法计算
 */
public class ISolution extends Solution{
    @Override
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || needle.equals("")) {
            return 0;
        }
        int i = 1;
        int j = 1;
        int[] next = getNextVal(needle);
        for (int z:next){
            System.out.print(z+",");
        }
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
     * 计算KMP算法的next数组
     * @param str
     * @return
     */
    public int[] getNext(String str){
        char[] chars = str.toCharArray();
        int i = 1,j = 0;
        int[] next = new int[str.length()+1];
        while (i < chars.length) {
            if (j == 0 || chars[i-1] == chars[j-1]) {
                next[++i] = ++j;
            }else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * 优化改进的KMP算法的next数组计算方式
     * @param str
     * @return
     */
    public int[] getNextVal(String str){
        char[] chars = str.toCharArray();
        int i = 1,j = 0;
        int[] nextVal = new int[str.length()+1];
        while (i < chars.length) {
            if (j == 0 || chars[i-1] == chars[j-1]) {
                i++;j++;
                if(chars[i-1] != chars[j-1]){
                    nextVal[i] = j;
                }else {
                    nextVal[i] = nextVal[j];
                }
            }else {
                j = nextVal[j];
            }
        }
        return nextVal;
    }

}
