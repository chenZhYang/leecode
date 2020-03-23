package com.aaronchen.leecode.middlenode;

import com.aaronchen.leecode.addtwonumbers.ListNode;
import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/23 22:24
 */
public class SolutionA extends Solution {

    /**
     * 快慢指针法，快的指针比慢的快两倍，当快的执行完时，慢的刚好到一半
     * @param head
     * @return
     */
    @Override
    public ListNode middleNode(ListNode head) {
        ListNode q = head ,p = head;
        while (p != null && p.next != null){
            q = q.next;
            p = p.next.next;
        }
        return q;
    }
}
