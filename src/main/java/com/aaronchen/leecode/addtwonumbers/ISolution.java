package com.aaronchen.leecode.addtwonumbers;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/23 20:25
 */
public class ISolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2,0);
    }
    private ListNode add(ListNode l1,ListNode l2,int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        if(l1 == null){
            l1 = new ListNode(0);
        }
        if(l2 == null){
            l2 = new ListNode(0);
        }
        int num = l1.val + l2.val + carry;
        ListNode result = new ListNode(num % 10);
        result.next = add(l1.next,l2.next,num/10);
        return result;
    }
}
