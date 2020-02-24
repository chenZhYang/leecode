package com.aaronchen.leecode.mergetwolists;

import com.aaronchen.leecode.addtwonumbers.ListNode;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/25 2:03
 */
public class Test {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(4);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(4);
        listNode4.next = listNode5;
        ISolution iSolution = new ISolution();
        ListNode listNode6 = iSolution.mergeTwoLists(listNode,listNode3);
        while (listNode6 != null){
            System.out.println(listNode6.val);
            listNode6 = listNode6.next;
        }
    }
}
