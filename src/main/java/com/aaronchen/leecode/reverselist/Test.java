package com.aaronchen.leecode.reverselist;

import com.aaronchen.leecode.addtwonumbers.ListNode;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/2 22:36
 */
public class Test {

    public static void main(String[] args) {
        SolutionO iSolution = new SolutionO();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode root = iSolution.reverseList(l1);
        while (root != null){
            System.out.print(root.val+" ");
            if(root != null){
                root = root.next;
            }
        }
    }
}
