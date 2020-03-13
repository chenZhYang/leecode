package com.aaronchen.leecode.majorityelement;

import com.aaronchen.leecode.solution.Solution;

import java.util.HashMap;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/13 22:13
 */
public class ISolution extends Solution {

    @Override
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>(16);
        int maxNum = 0;
        int maxVal = 0;
        for (int i:nums){
            if(hashMap.containsKey(Integer.valueOf(i))){
                Integer integer = hashMap.get(Integer.valueOf(i));
                integer ++;
                if(integer > maxNum){
                    maxNum = integer;
                    maxVal = i;
                }
                hashMap.put(Integer.valueOf(i),integer);
            }else{
                hashMap.put(Integer.valueOf(i),1);
                if(1 > maxNum){
                    maxNum = 1;
                    maxVal = i;
                }
            }
        }
        return maxVal;
    }
}
