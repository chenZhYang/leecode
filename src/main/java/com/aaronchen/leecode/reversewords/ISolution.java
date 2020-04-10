package com.aaronchen.leecode.reversewords;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/10 22:36
 */
public class ISolution extends Solution {

    @Override
    public String reverseWords(String s) {
        if(s == null || "".equals(s.trim())){
            return "";
        }
        String[] strings = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = strings.length-1;i >= 0;i--){
            if("".equals(strings[i].trim())) {
                continue;
            }
            stringBuilder.append(strings[i]);
            if(i > 0){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        ISolution iSolution = new ISolution();
        String s1 = iSolution.reverseWords(s);
        System.out.println(s1);
    }
}
