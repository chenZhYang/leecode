package com.aaronchen.leecode.lengthoflongestsubstring;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/23 22:41
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        log.info("请求开始");
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstringB("addassdda");
        log.info("请求结束:"+i);
    }
}
