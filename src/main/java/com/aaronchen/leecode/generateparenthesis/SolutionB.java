package com.aaronchen.leecode.generateparenthesis;

import com.aaronchen.leecode.solution.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/9 23:40
 */
public class SolutionB extends Solution {

    List<String> list = null;
    @Override
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        dfs(0,0,"",n);
        return list;
    }

    private void dfs(int left,int right,String subStr,int n){
        if(left > n || right > n || right > left){
            return;
        }
        if(left == n && right == n){
            list.add(subStr);
            return;
        }
        dfs(left+1,right,subStr+"(",n);
        dfs(left,right+1,subStr+")",n);
    }
}
