package com.aaronchen.leecode.longestpalindrome;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/19 21:47
 */
public class ISolution extends Solution {

    @Override
    public int longestPalindrome(String s) {
        int[] array = new int[128];
        for(char c:s.toCharArray()){
            array[c]++;
        }
        int max = 0;
        //判断是否有字符个数为奇数的
        boolean flag = true;
        for(int i = 0;i < array.length;i++){
            //字符个数大于为奇数个
            if((array[i] & 1 )== 1){
                max += array[i]-1;
                if(flag){
                    max++;
                    flag = false;
                }
            }else{
                max += array[i];
            }
        }
        return max;
    }
}
