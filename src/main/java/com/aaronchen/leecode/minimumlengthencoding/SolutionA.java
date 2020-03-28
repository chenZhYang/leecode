package com.aaronchen.leecode.minimumlengthencoding;

import com.aaronchen.leecode.solution.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/28 19:16
 * 其他优解
 */
public class SolutionA extends Solution {

    @Override
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word: words) {
            len += trie.insert(word);
        }
        return len;
    }
}
