package com.aaronchen.leecode.reverselist;

import com.aaronchen.leecode.addtwonumbers.ListNode;
import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/2 22:22
 */
public class SolutionO extends Solution {

    /**
     * 递归算法
     * @param head
     * @return
     */
    @Override
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode next = head.next;
        ListNode p = reverseList(next);
        next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 迭代算法
     * @param head
     * @return
     */
    public ListNode reverseListA(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }
}
