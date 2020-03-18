package com.aaronchen.leecode.isrectangleoverlap;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/18 22:34
 */
public class ISolution extends Solution {

    @Override
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec2[0] >= rec1[2] || rec2[1] >= rec1[3]
                || rec2[2] <= rec1[0] || rec2[3] <= rec1[1]){
            return false;
        }
        return true;
    }
}
