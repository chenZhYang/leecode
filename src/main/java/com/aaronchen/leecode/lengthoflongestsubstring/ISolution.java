package com.aaronchen.leecode.lengthoflongestsubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Aaron chen
 * @Date: 2020/2/23 21:49
 */
public class ISolution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        List<String> arrayList = new ArrayList<>();
        for(int i = 0;i<chars.length;i++){
            String str = new String(new char[]{chars[i]});
            if(arrayList.contains(str)){
                if(arrayList.size() > max || max == 0){
                    max = arrayList.size();
                }
                int tag = arrayList.indexOf(str);
                for(int j = 0;j<=tag;j++){
                    arrayList.remove(0);
                }
            }
            arrayList.add(str);
        }
        if(max < arrayList.size()){
            max = arrayList.size();
        }
        return max;
    }
}
