package com.aaronchen.leecode.countandsay;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/13 22:56
 */
public class ISolution extends Solution {

    @Override
    public String countAndSay(int n) {
        return dealLass(n-1,"1");
    }

    private String dealLass(int n,String val){
        if(n == 0){
            return val;
        }
        char[] chars = val.toCharArray();
        int num = 1;
        StringBuilder cas = new StringBuilder();
        for(int i = 0;i < chars.length;i++){
            if(i == chars.length-1){
                cas.append(num).append(chars[i]);
            }else if(chars[i] == chars[i+1]){
                num ++;
            }else{
                cas.append(num).append(chars[i]);
                num = 1;
            }
        }
        n--;
        return dealLass(n,cas.toString());
    }
}
