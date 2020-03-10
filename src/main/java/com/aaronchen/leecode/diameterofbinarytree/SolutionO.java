package com.aaronchen.leecode.diameterofbinarytree;

import com.aaronchen.leecode.solution.Solution;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/10 22:34
 */
public class SolutionO extends Solution {
    int max = 0;
    @Override
    public int diameterOfBinaryTree(TreeNode root) {
        if (root != null) {
            //遍历每一个节点,求出此节点作为根的树的深度,那么,左子树深度加右子树深度的最大值即是答案
            setDepth(root);
            return max;
        }
        return 0;
    }

    public int setDepth(TreeNode root) {
        if (root != null) {
            int right = setDepth(root.right);
            int left = setDepth(root.left);
            if (right + left > max)
                max = right + left;
            return Math.max(right, left) + 1;
        }
        return 0;
    }
}
