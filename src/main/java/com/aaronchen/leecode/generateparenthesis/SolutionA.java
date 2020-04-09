package com.aaronchen.leecode.generateparenthesis;

import com.aaronchen.leecode.solution.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/9 23:03
 * 深度遍历DFS+剪枝。
 * 原理1：左括号永远是第一个；
 * 原理2：右括号插入的时候剩余数量永远应该比左括号剩余数量多；
 * 原理3：左右括号总数最终等于有效括号总数
 *
 * 使用深度遍历技巧：
 * 第一步：明确递归参数
 * 第二步：明确递归终止条件
 * 第三步：明确递归函数中的内容
 * 第四步：明确回溯返回值
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
