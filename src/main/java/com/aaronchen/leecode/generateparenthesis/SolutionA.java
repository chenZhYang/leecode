package com.aaronchen.leecode.generateparenthesis;

import com.aaronchen.leecode.solution.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/9 23:03
 */
public class SolutionA extends Solution {
    List<String> list = null;
    @Override
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        dfs(n,n,"");
        return list;
    }

    private void dfs(int left,int right,String subStr){
        if(left == 0 && right == 0){
            // 左右括号都不剩余了，递归终止
            list.add(subStr);
            return;
        }
        // 如果左括号还剩余的话，可以拼接左括号
        if(left > 0){
            dfs(left-1,right,subStr+"(");
        }
        // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
        if(right > left){
            dfs(left,right-1,subStr+")");
        }
    }

    public static void main(String[] args) {
        SolutionA solutionA = new SolutionA();
        List<String> list = solutionA.generateParenthesis(3);
        System.out.println(list);
    }
}
