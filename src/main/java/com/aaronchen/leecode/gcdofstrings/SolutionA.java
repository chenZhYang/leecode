package com.aaronchen.leecode.gcdofstrings;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/12 21:52
 * 取最大公约数
 */
public class SolutionA extends Solution {

    /**
     * 辗转相除法
     * @param str1
     * @param str2
     * @return
     */
    @Override
    public String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    /**
     * 递归取模法
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    /**
     * 取模法
     * @param a
     * @param b
     * @return
     */
    private int gcd1(int a, int b) {
        while (b!=0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }

    /**
     * 更相减损法
     * @param a
     * @param b
     * @return
     */
    private int gcd2(int a,int b){
        if(a == b){
            return a;
        }else if(a < b){
            return gcd2(b-a,a);
        }else {
            return gcd2(a-b,b);
        }
    }

    /**
     * 移位递归运算
     * 当 a、b都为偶数时，gcd(a,b) = 2*gcd(a/2,b/2);
     * 当 a为偶数,b为奇数，gcd(a,b) = gcd(a/2,b)=gcd(a>>1,b);
     * 当 a为奇数,b为偶数，gcd(a,b) = gcd(a,b/2)=gcd(a,b>>1);
     * 当 a、b都为奇数时，利用更相减损术运算一次，gcd(a,b) = gcd(b,a-b),此时a-b肯定为偶数，就又可以进入下一步的移位运算
     * @param a
     * @param b
     * @return
     */
    public int gcd3(int a,int b){
        if(a == b){
            return a;
        }
        if(a < b){
            return gcd3(b,a);
        }else {
            //使用按位与运算来判断奇偶数
            if((a & 1) == 0 && (b & 1) == 0){
                //当 a、b都为偶数时，gcd(a,b) = 2*gcd(a/2,b/2)
                return gcd3(a >>1,b>>1) << 1;
            }else if((a & 1) == 0 && (b & 1) == 1){
                //当 a为偶数,b为奇数，gcd(a,b) = gcd(a/2,b)=gcd(a>>1,b);
                return gcd3(a >>1,b);
            }else if((a & 1) == 1 && (b & 1) == 0){
                //当 a为奇数,b为偶数，gcd(a,b) = gcd(a,b/2)=gcd(a,b>>1);
                return gcd3(a,b >>1);
            }else {
                //当 a、b都为奇数时，利用更相减损术运算一次，gcd(a,b) = gcd(b,a-b),此时a-b肯定为偶数，就又可以进入下一步的移位运算
                return gcd3(b,a-b);
            }
        }
    }
}
