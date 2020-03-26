package com.aaronchen.leecode.numrookcaptures;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/26 21:29
 */
public class ISolution extends Solution {

    @Override
    public int numRookCaptures(char[][] board) {
        int nums = 0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int i = 0;i<board.length;i++){
            for (int j = 0;j < board[i].length;j++){
                if(board[i][j] == 'R'){
                    for(int z = 0;z<dx.length;z++){
                        int tx = i,ty = j;
                        while (true){
                            tx += dx[z];
                            ty += dy[z];
                            if(tx < 0 || ty < 0 || tx >= board.length || ty >= board[i].length || board[tx][ty] == 'B'){
                                break;
                            }
                            if(board[tx][ty] == 'p'){
                                nums++;
                                break;
                            }
                        }
                    }
                    return nums;
                }
            }
        }
        return nums;
    }

}
