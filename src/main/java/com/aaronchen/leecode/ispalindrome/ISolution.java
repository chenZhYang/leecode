package com.aaronchen.leecode.ispalindrome;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/24 0:20
 */
public class ISolution extends Solution {
    @Override
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        long l = 0;
        int z = x;
        while (x != 0){
            l = l * 10 + x % 10;
            x = x / 10;
        }
        try{
            if((int)l != z){
                return false;
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
