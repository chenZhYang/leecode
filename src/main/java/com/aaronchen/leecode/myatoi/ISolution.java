package com.aaronchen.leecode.myatoi;

import com.aaronchen.leecode.solution.Solution;
/**
 * @Author: Aaron chen
 * @Date: 2020/4/3 22:22
 */
public class ISolution extends Solution {

    @Override
    public int myAtoi(String str) {
        if(str == null || "".equals(str.trim())){
            return 0;
        }
        char[] chars = str.trim().toCharArray();
        if(!isNum(chars[0]) && !addSub(chars[0])){
            return 0;
        }
        if(addSub(chars[0]) && str.length() == 1){
            return 0;
        }
        if(addSub(chars[0]) && addSub(chars[1])){
            return 0;
        }
        int j = 0;
        char[] chars1 = new char[chars.length];
        chars1[j] = chars[0];
        j++;
        boolean flag =false;
        if(isNum(chars[0]) && chars[0] != '0'){
            flag = true;
        }
        for(int i = 1;i<chars.length;i++){
            if(isNum(chars[i])){
                if(!flag && chars[i] == '0'){
                    continue;
                }
                chars1[j] = chars[i];
                j++;
                flag = true;
            }else {
                break;
            }
        }
        String nums = new String(chars1).trim();
        if(nums.equals("+") || nums.equals("-")){
            return 0;
        }
        if(nums.length() > 11){
            if(chars1[0] == '-'){
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        Long l = Long.valueOf(nums);
        if(l > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(l < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return  l.intValue();
    }

    private boolean isNum(char c){
        if(c >= 48 && c <= 57){
            return true;
        }
        return false;
    }

    private boolean addSub(char c){
        if(c == 43 || c == 45){
            return true;
        }
        return false;
    }
}
