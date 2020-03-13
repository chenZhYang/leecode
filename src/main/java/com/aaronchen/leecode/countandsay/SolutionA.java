package com.aaronchen.leecode.countandsay;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/14 0:55
 */
public class SolutionA extends Solution {

    /**
     * 使用描述函数
     * @param n
     * @return
     */
    @Override
    public String countAndSay(int n) {
        return dealLass(n-1,"1");
    }

    private String dealLass(int n,String val){
        if(n == 0){
            return val;
        }
        char[] chars = val.toCharArray();
        StringBuilder string = new StringBuilder();
        char ch = chars[0];
        int temp = 1, i = 1;
        while (i < chars.length){
            if (chars[i] == ch) {
                temp++;
            } else {
                string.append(temp).append(chars[i - 1]);
                ch = chars[i];
                temp = 1;
            }
            i++;
        }
        string.append(temp).append(chars[i - 1]);
        n--;
        return dealLass(n,string.toString());
    }
}
