package com.aaronchen.leecode.compressstring;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/16 22:21
 */
public class ISolution extends Solution {

    @Override
    public String compressString(String S) {
        if(S.length() == 1) return S;
        char[] chars = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int num = 1;
        for (int i = 1;i<chars.length;i++){
            if(chars[i-1] == chars[i]){
                num++;
                if(i == chars.length-1){
                    stringBuilder.append(chars[i-1]).append(num);
                }
            }else{
                stringBuilder.append(chars[i-1]).append(num);
                num = 1;
            }
        }
        return stringBuilder.length() >= S.length() ? S:stringBuilder.toString();
    }
}
