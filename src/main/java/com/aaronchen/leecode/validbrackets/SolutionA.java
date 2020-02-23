package com.aaronchen.leecode.validbrackets;

import java.util.Stack;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/23 1:48
 * 其他优解
 */
public class SolutionA {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c: s.toCharArray()){
            switch (c){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop()) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
