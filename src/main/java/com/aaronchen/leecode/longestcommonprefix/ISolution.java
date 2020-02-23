package com.aaronchen.leecode.longestcommonprefix;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/24 1:03
 */
public class ISolution extends Solution {
    @Override
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        char[] start = strs[0].toCharArray();
        int num = 0;
        boolean flag = true;
        while (flag){
            for(int i = 1;i < strs.length;i++){
                char[] comp = strs[i].toCharArray();
                if(num < comp.length && num < start.length && comp[num] == start[num]){
                    if(i == strs.length-1){
                        num++;
                    }
                }else{
                    flag = false;
                    break;
                }
            }
        }
        if(num == 0){
            return "";
        }
        return strs[0].substring(0,num);
    }
}
