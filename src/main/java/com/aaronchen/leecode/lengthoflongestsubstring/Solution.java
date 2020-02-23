package com.aaronchen.leecode.lengthoflongestsubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/23 22:15
 *
 */
public class Solution {
    /**
     * 时间复杂度：
     * O(2n) = O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次。
     * 空间复杂度：
     * O(min(m, n))，与之前的方法相同。滑动窗口法需要 O(k)的空间，其中 k 表示 Set 的大小。而 Set 的大小取决于字符串 n 的大小以及字符集 / 字母 m 的大小。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 时间复杂度：O(n)，索引 jj 将会迭代 n 次。
     * 空间复杂度（HashMap）：O(min(m, n))，与之前的方法相同。
     * 空间复杂度（Table）：O(m)，m 是字符集的大小。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringA(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        //创建map窗口,i为左区间，j为右区间，右边界移动
        Map<Character, Integer> map = new HashMap<>(16);
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            // 如果窗口中包含当前字符
            if (map.containsKey(s.charAt(j))) {
                //左边界移动到 相同字符的下一个位置和i当前位置中更靠右的位置，这样是为了防止i向左移动
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //比对当前无重复字段长度和储存的长度，选最大值并替换
            //j-i+1是因为此时i,j索引仍处于不重复的位置，j还没有向后移动，取的[i,j]长度
            ans = Math.max(ans, j - i + 1);
            // 将当前字符为key，下一个索引为value放入map中
            // value为j+1是为了当出现重复字符时，i直接跳到上个相同字符的下一个位置，if中取值就不用+1了
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * 假设字符集为 ASCII 128
     * int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
     * int [128] 用于ASCII码
     * int [256] 用于扩展ASCII码
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringB(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        int[] index = new int[128];
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            int a = s.charAt(j);
            int r = index[a];
            i = Math.max(r, i);
            ans = Math.max(ans, j - i + 1);
            index[a] = j + 1;
        }
        return ans;
    }
}
