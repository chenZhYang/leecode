package com.aaronchen.leecode.canthreepartsequalsum;


import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/11 20:53
 */
public class ISolution extends Solution {

    @Override
    public boolean canThreePartsEqualSum(int[] A) {
        if(A.length < 3){
            return false;
        }
        int num = 0;
        for(int i = 0;i<A.length;i++){
            num += A[i];
        }
        int x = num % 3;
        if(x != 0){
            return false;
        }
        x = num / 3;
        int n = 0;
        int s = 0;
        for(int j = 0;j<A.length;j++){
            n += A[j];
            if(n == x){
                n = 0;
                s++;
                //检测到有两个子数组已经达到相等，并且A还没遍历完，说明A数据肯定能被分成三个和相同的数组
                if(s == 2 && j < A.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
