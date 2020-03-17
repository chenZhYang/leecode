package com.aaronchen.leecode.countcharacters;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/18 0:30
 */
public class SolutionA extends Solution {

    @Override
    public int countCharacters(String[] words, String chars) {
        int[] table = new int[26];
        for (int i = 0; i < chars.length(); i++){
            table[chars.charAt(i) - 'a']++;
        }
        // 单词长度
        int count = 0;
        for (String str : words) {
            if (canSpellWords(str, table)){
                count += str.length();
            }
        }
        return count;
    }
    public boolean canSpellWords(String str, int[] table) {
        int[] tmp = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            // 临时表 和 字母表值相等，代表字母不存在
            if (tmp[now - 'a'] == table[now - 'a']){
                return false;
            }
            // 临时表 和 字母表值不相等，代表字母存在，
            // 假设字符bba 和比较字符串bca ，其中字母表b的位置值为1， a的位置值为1，c的位置值为1
            // 当运行第一个b时，临时表b的值为0，因此临时表 和 字母表值不相等，代表字母存在，临时表b的值加1
            // 当运行第二个b时，临时表b的值为1，临时表 和 字母表值相等，代表字母不存在
            // 此算法运用了int数组数据默认值为0的特点，如果有n个字母,则值为n
            // 所以在判断临时表 和 字母表值的时候，由于最先开始判断临时表还没加值
            // 所以当tmp[now - 'a'] == table[now - 'a']时，
            // 说明之前就已经有同样的字母经过比较或者临时表和字母表都没有比较，
            // 前者说明有过比较的字母已达到极限
            // 例如 当运行第二个b时，临时表b的值为1，
            // 但比较字符串bca只有一个b，这个b在上一次已经完成过比较，因此说明字母表不存在两个以上的b，所以不存在。
            tmp[now - 'a']++;
        }
        return true;
    }
}
