package com.aaronchen.leecode.gameoflife;

import com.aaronchen.leecode.solution.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/2 21:20
 */
public class ISolution extends Solution {
    int[] dx = {0,0,1,-1,-1,1,-1,1};
    int[] dy = {1,-1,0,0,-1,1,1,-1};
    List<Integer[]> coordinate = new ArrayList<Integer[]>();
    @Override
    public int[][] gameOfLife(int[][] board) {
        int n = board.length,m = board[0].length;
        int [][] nums = board;
        int z = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                livingCell(nums,i,j);
            }
        }
        for(Integer[] integers: coordinate){
            board[integers[0]][integers[1]] = integers[2];
        }
        return board;
    }

    private void livingCell(int[][] board,int x,int y){
        int living = board[x][y];
        for(int i = 0;i < dx.length;i++){
            int tx = x,ty = y;
            tx += dx[i];
            ty += dy[i];
            if(tx < 0||ty < 0||tx >= board.length || ty > board[0].length){
                continue;
            }
            if(board[x][y] == 1){
                living ++;
            }
        }
        if(board[x][y] == 1 && (living < 2 || living > 3)){
            Integer[] ints ={x,y,0};
            coordinate.add(ints);
        }
        if(board[x][y] == 0 && living == 3){
            Integer[] ints ={x,y,1};
            coordinate.add(ints);
        }
    }
}
