package com.aaronchen.leecode.mystack;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/1 22:32
 */
public class Test {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_1 = obj.pop();
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println("param_1 = "+param_1);
        System.out.println("param_2 = "+param_2);
        System.out.println("param_3 = "+param_3);
        System.out.println("param_4 = "+param_4);
    }
}
