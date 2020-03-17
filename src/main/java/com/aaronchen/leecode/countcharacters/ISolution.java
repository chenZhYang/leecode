package com.aaronchen.leecode.countcharacters;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/17 23:21
 */
public class ISolution extends Solution {

    @Override
    public int countCharacters(String[] words, String chars) {
        String dup = chars;
        int max = 0;
        for(int i = 0;i < words.length;i++){
            char[] sub = words[i].toCharArray();
            for(int j = 0;j < sub.length;j++){
                int l = dup.indexOf(sub[j]);
                if(l == -1){
                    break;
                }
                if(j == sub.length-1){
                    max += sub.length;
                    System.out.println(i+"："+words[i]);
                    break;
                }
                if(l < dup.length()-1){
                    dup = dup.substring(0,l)+dup.substring(l+1);
                }else{
                    dup = dup.substring(0,l);
                }
            }
            dup = chars;
        }
        return max;
    }

}
