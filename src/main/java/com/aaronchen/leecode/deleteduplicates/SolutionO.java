package com.aaronchen.leecode.deleteduplicates;

import com.aaronchen.leecode.addtwonumbers.ListNode;
import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/23 23:12
 */
public class SolutionO extends Solution {


    /**
     * current.next 是 current 的副本。
     * 在这种情况下，删除 current.next 中的重复结点，
     * 并且current保持指向与之前相同的结点。因此，情况仍然成立；
     * 一直到 current 仍然没有重复项。
     *
     * current.next 不是 current 的副本
     * （并且，因为列表已经排序，current.next 也不是 current 之前出现的任何其他元素的副本）。
     * 在这种情况下，current 向前移动一步指向 current.next。因此，情况仍然成立；
     * 一直到 current 仍然没有重复项。
     * @param head
     * @return
     */
    @Override
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
