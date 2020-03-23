package com.aaronchen.leecode.middlenode;

import com.aaronchen.leecode.addtwonumbers.ListNode;
import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/23 22:06
 */
public class ISolution extends Solution {

    @Override
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode root = head;
        while(root != null){
            len ++;
            root = root.next;
        }
        int mid = len % 2 == 0 ? (len / 2) + 1:  (len + 1) / 2;
        len = 0;
        ListNode midNode = null;
        while(head != null){
            len ++;
            if(len == mid) {
                midNode = head;
                break;
            }
            head = head.next;
        }
        return midNode;
    }
}
