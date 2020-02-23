package com.aaronchen.leecode.validbrackets;

import java.util.Stack;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/22 22:52
 * 在官方答案上使用switch代替hashmap,优化内存
 */
public class ISolution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if('F' == reChar(c)){
                // TODO: 2020/2/23 这是闭括号，校验栈顶是否与此为相同元素
                if(stack.isEmpty() || stack.pop() != re(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private char reChar(char c){
        switch (c){
            case '{':
                return '}';
            case '(':
                return ')';
            case '[':
                return ']';
            default:
                return 'F';
        }
    }

    private char re(char c){
        switch (c){
            case '}':
                return '{';
            case ')':
                return '(';
            case ']':
                return '[';
            default:
                return 'F';
        }
    }

}
