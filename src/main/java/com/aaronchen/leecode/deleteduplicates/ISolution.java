package com.aaronchen.leecode.deleteduplicates;

import com.aaronchen.leecode.addtwonumbers.ListNode;
import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/23 23:11
 */
public class ISolution extends Solution {

    @Override
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode root = new ListNode(head.val);
        ListNode prev = root;
        while(head.next != null){
            head = head.next;
            int val = head.val;
            if(prev.val != val){
                prev.next = new ListNode(val);
                prev = prev.next;
            }
        }
        return root;
    }
}
