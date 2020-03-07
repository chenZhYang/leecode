package com.aaronchen.leecode.findcontinuoussequence;

import com.aaronchen.leecode.solution.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/6 23:38
 */
public class SolutionA extends Solution {
    @Override
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        for(int i = 1;i<=target/2;i++){
            int sum = 0;
            int j = i;
            while(sum<target){
                sum += j;
                j++;
            }
            if(sum == target){
                int[] sol = new int[j-i];
                for(int k = 0;k<j-i;k++){
                    sol[k] = k+i;
                }
                res.add(sol);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
