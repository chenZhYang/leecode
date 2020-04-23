package com.aaronchen.leecode.myheap;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/18 13:05
 */
public class MyHeap {


    public int left(int index){
        return (index + 1) * 2 - 1;
    }

    public int right(int index){
        return (index + 1) * 2 ;
    }

    public int parent(int index){
        if(index == 0){
            return -1;
        }
        return (index-1) / 2;
    }
}
