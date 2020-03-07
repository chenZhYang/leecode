package com.aaronchen.leecode.maxqueue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/7 20:08
 */
public class MaxQueue {

    LinkedBlockingQueue<Integer> queue;
    LinkedBlockingQueue<Integer> help;
    int max = 0;
    public MaxQueue() {
        queue = new LinkedBlockingQueue<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : max;
    }

    public void push_back(int value) {
        if (max < value) {
            max = value;
        }
       queue.offer(Integer.valueOf(value));
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        Integer integer = queue.poll();
        if(integer == max){
            max = 0;
            for(int i = 0;i < queue.size();i++){
                Integer integer1 = queue.poll();
                if(integer1 > max){
                    max = integer1;
                }
                queue.offer(integer1);
            }
        }
        return integer;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
