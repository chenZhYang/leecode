package com.aaronchen.leecode.maxprofit;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/9 23:35
 */
public class ISolution extends Solution {

    @Override
    public int maxProfit(int[] prices) {
        if(prices ==null || prices.length == 0){
            return 0;
        }
        int x = 0;
        int min = prices[0];
        for(int i = 1;i<prices.length;i++){
            if(prices[i] < min){
                min = prices[i];
            }else{
                int n = prices[i] - min;
                if(n > x){
                    x = n;
                }
            }
        }
        return x;
    }
}
