package com.aaronchen.leecode.movingcount;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/8 23:11
 */
public class ISolution extends Solution {

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    boolean[][] flags = null;
    @Override
    public int movingCount(int m, int n, int k) {
        flags = new boolean[m][n];
        return dfs(0,0,m,n,k);
    }

    private int dfs(int tx,int ty,int m,int n,int k){
        if(tx >= m || ty >= n || tx < 0 || ty < 0 || flags[tx][ty]
                || add(tx) + add(ty) > k){
            return 0;
        }
        flags[tx][ty] = true;
        int num = 1;
        for(int x = 0;x<dx.length;x++){
            num += dfs(tx + dx[x],ty+dy[x],m,n,k);
        }
        return num;
    }

    public int add(int x){
        if(x < 10){
            return x;
        }
        int num = 0;
        while (x / 10 != 0){
            num += x%10;
            x /= 10;
        }
        num += x;
        return num;
    }

    public static void main(String[] args) {
        ISolution iSolution = new ISolution();
        int i = iSolution.movingCount(3,2,17);
        System.out.println(i);
    }
}
