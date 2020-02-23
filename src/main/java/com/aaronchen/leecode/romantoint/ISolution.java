package com.aaronchen.leecode.romantoint;

import com.aaronchen.leecode.solution.Solution;

import java.util.HashMap;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/24 0:47
 */
public class ISolution extends Solution {

    @Override
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        for(int i = 0;i < chars.length;i++){
            if(i == chars.length-1){
                num += PubFun.rToiByS(chars[i]);
            }else if(PubFun.rToiByS(chars[i]) >= PubFun.rToiByS(chars[i+1])){
                num += PubFun.rToiByS(chars[i]);
            }else {
                num -= PubFun.rToiByS(chars[i]);
            }
        }
        return num;
    }
}
