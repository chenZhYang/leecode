package com.aaronchen.leecode.maxsubarray;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/17 0:52
 */
public class ISolution extends Solution {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    @Override
    public int maxSubArray(int[] nums) {
        //若nums为null或长度为0，返回0
        if (nums == null || nums.length == 0){
            return 0;
        }
        //设置当前序列遍历时连续相加最长和为0
        int s = 0;
        //设置整个数列数列连续相加最长和为第一个元素
        int max = nums[0];
        for(int i = 0;i < nums.length; i++){
            if(s > 0){
                //如果s大于0，则说明此次相加是有益的
                //就是说s+nums[i]+nums[i+1]...+nums[n-1]是比nums[i]+nums[i+1]...+nums[n-1]大
                //因此s = s + nums[i]
                s += nums[i];
            }else{
                //如果s小于等于0，则说明此次相加是无效的
                //就是说s+nums[i]+nums[i+1]...+nums[n-1]小于或等于nums[i]+nums[i+1]...+nums[n-1]
                //因此将s初始化为当前值nums[i],这样下次相加则从nums[i]开始
                s = nums[i];
            }
            //比较s和max，获取在遍历期间s所得到过最长和出来
            //遍历完之后，max就是遍历过程中连续相加最长和
            max = Math.max(s,max);
        }
        return max;
    }
}
