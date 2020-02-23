package com.aaronchen.leecode.addtwonumbers;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/23 20:27
 * 时间复杂度：
 * O(\max(m, n))，假设 m 和 n 分别表示 l1 和 l2 的长度，
 * 上面的算法最多重复 max(m, n) 次。
 * 空间复杂度：
 * O(max(m, n))， 新列表的长度最多为 max(m,n) + 1。
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null){
                p = p.next;
            }
            if (q != null){
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
