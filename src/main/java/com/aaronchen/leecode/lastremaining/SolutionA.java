package com.aaronchen.leecode.lastremaining;

import com.aaronchen.leecode.solution.Solution;

import java.util.*;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/30 21:54
 */
public class SolutionA extends Solution {

    /**
     * 模拟链表
     * @param n
     * @param m
     * @return
     */
    @Override
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0;i<n;i++){
            list.add(i);
        }
        int i = 0;
        while (n > 1){
            //
            i = (i + m - 1) % n;
            list.remove(i);
            n--;
        }
        return list.get(n);
    }

    /**
     * 瑟夫环问题
     * 以n = 5, m = 3举例
     * 第一轮是 [0, 1, 2, 3, 4] ，所以是 [0, 1, 2, 3, 4] 这个数组的多个复制。这一轮 2 删除了。
     *
     * 第二轮开始时，从 3 开始，所以是 [3, 4, 0, 1] 这个数组的多个复制。这一轮 0 删除了。
     *
     * 第三轮开始时，从 1 开始，所以是 [1, 3, 4] 这个数组的多个复制。这一轮 4 删除了。
     *
     * 第四轮开始时，还是从 1 开始，所以是 [1, 3] 这个数组的多个复制。这一轮 1 删除了。
     *
     * 最后剩下的数字是 3。
     *
     * 图中的绿色的线指的是新的一轮的开头是怎么指定的，每次都是固定地向前移位 mm 个位置。
     *
     * 然后我们从最后剩下的 3 倒着看，我们可以反向推出这个数字在之前每个轮次的位置。
     *
     * 最后剩下的 3 的下标是 0。
     *
     * 第四轮反推，补上 m 个位置，然后模上当时的数组大小 2，位置是(0 + 3) % 2 = 1。
     *
     * 第三轮反推，补上 m 个位置，然后模上当时的数组大小 3，位置是(1 + 3) % 3 = 1。
     *
     * 第二轮反推，补上 m 个位置，然后模上当时的数组大小 4，位置是(1 + 3) % 4 = 0。
     *
     * 第一轮反推，补上 m 个位置，然后模上当时的数组大小 5，位置是(0 + 3) % 5 = 3。
     *
     * 所以最终剩下的数字的下标就是3。因为数组是从0开始的，所以最终的答案就是3。
     *
     * 总结一下反推的过程，就是 (当前index + m) % 上一轮剩余数字的个数。
     * @param n
     * @param m
     * @return
     */
    private int lastRemaining1(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
