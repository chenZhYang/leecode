package com.aaronchen.leecode.longestcommonprefix;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/24 1:04
 * 官方优解
 */
public class SolutionO extends Solution {

    /**
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和。
     * 最坏的情况下，n 个字符串都是相同的。算法会将 S1 与其他字符串 [S_2...S_N ] 都做一次比较。这样就会进行 S 次字符比较，其中 S 是输入数据中所有字符数量。
     * 空间复杂度：O(1)，我们只需要使用常数级别的额外空间。
     * @param strs
     * @return
     */
    @Override
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}
