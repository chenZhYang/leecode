package com.aaronchen.leecode.mergetwolists;

import com.aaronchen.leecode.addtwonumbers.ListNode;
import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/25 2:30
 */
public class ISolutionA extends Solution {
    @Override
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode midNode = root;
        while (l1 != null && l2 != null) {
            int x1 = l1.val;
            int x2 = l2.val;
            midNode.next = new ListNode(Math.min(x1,x2));
            midNode = midNode.next;
            if(x1 < x2){
                if (l1 != null) {
                    l1 = l1.next;
                }
            }else{
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
        }
        if(l1 != null){
            midNode.next = l1;
        }
        if(l2 != null){
            midNode.next = l2;
        }
        return root.next;
    }
}
