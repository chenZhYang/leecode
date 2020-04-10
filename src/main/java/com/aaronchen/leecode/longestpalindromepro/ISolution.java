package com.aaronchen.leecode.longestpalindromepro;


/**
 * @Author: Aaron chen
 * @Date: 2020/4/10 23:52
 */
public class ISolution {


    public String longestPalindrome(String s) {
        String maxStr = s == null || s.length() == 0 ? s : s.substring(0,1);
        for(int i= 0;i < s.length()-maxStr.length();i++){
            for(int j = s.length()-1;j >= i ;j--){
                if(s.charAt(i) == s.charAt(j)){
                    String reverse = s.substring(i,j+1);
                    StringBuilder stringBuilder = new StringBuilder(reverse);
                    stringBuilder.reverse();
                    if(stringBuilder.toString().equals(reverse) && maxStr.length() < reverse.length()){
                        maxStr = reverse;
                        break;
                    }
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        ISolution iSolution = new ISolution();
        String s = "cbba";
        String s1 = iSolution.longestPalindrome(s);
        System.out.println(s1);
    }
}
