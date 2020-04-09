package com.aaronchen.leecode.addbinary;


import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/4/10 0:18
 */
public class ISolution extends Solution {

    @Override
    public String addBinary(String a, String b) {
        //进位
        char add = '0';
        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();
        int n = chara.length-1,m = charb.length-1;
        char[] chars = new char[Math.max(chara.length,charb.length)+1];
        int i = chars.length-1;
        while ( n >= 0 || m >= 0){
            char x = n >= 0 ? chara[n--]:'0';
            char y = m >= 0 ? charb[m--]:'0';
            int num = x + y + add ;
            add = '0';
            if(num == 145){
                chars[i] = '1';
            }else if(num == 146){
                add = '1';
                chars[i] = '0';
            }else if(num == 147){
                add = '1';
                chars[i] = '1';
            }else if(num == 144){
                chars[i] = '0';
            }
            i--;
        }
        chars[0] = add;
        return add == '0' ? new String(chars).substring(1):new String(chars);
    }

    public static void main(String[] args) {
        ISolution iSolution = new ISolution();
        String s = iSolution.addBinary("10111111111111111111","1");
        System.out.println(s);
    }
}
