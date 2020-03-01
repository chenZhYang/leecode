package com.aaronchen.leecode.mystack;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/1 16:54
 */
public class MyStack {
    private ConcurrentLinkedQueue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue =  new ConcurrentLinkedQueue<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Integer r = null;
        for (int i = 0;i < queue.size();i++){
            r = queue.poll();
            if(i <= queue.size()-1){
                queue.offer(r);
            }else {
                break;
            }
        }
        return r.intValue();
    }

    /** Get the top element. */
    public int top() {
        Integer r = null;
        int i = queue.size();
        for (Integer integer:queue){
            r = integer;
            if(i < 0){
                break;
            }
            i--;
        }
        return r.intValue();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue != null && queue.size() > 0 ? false:true;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "queue=" + queue +
                '}';
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
