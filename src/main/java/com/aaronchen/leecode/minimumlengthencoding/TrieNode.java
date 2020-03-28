package com.aaronchen.leecode.minimumlengthencoding;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/28 21:14
 * 字典树实体类
 */
public class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}
