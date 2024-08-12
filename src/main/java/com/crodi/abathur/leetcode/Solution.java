package com.crodi.abathur.leetcode;

import com.crodi.abathur.entity.TreeNode;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @Author: crodi
 * @Description:
 * @Date: 2020/10/26 1:57 下午
 * @Version: 1.0
 */

@Component
public class Solution {

    private final List<Integer> results = Lists.newArrayList();

    public int[] shuffle(int[] nums, int n) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length / 2; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[nums.length + i - nums.length / 2];
        }
        return result;
    }

    /**
     * leetCode 20201210
     *
     * @param s
     * @param indices
     * @return
     */
    public String restoreString(String s, int[] indices) {

        byte[] bytes = new byte[indices.length];
        byte[] sBytes = s.getBytes();
        for (int i = 0; i < indices.length; i++) {
            bytes[indices[i]] = sBytes[i];
        }
        return new String(bytes);
    }

    /**
     * 二叉树中序遍历
     * @param treeNode
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            if (Objects.nonNull(treeNode.getLeft())){
                this.inorderTraversal(treeNode.getLeft());
            }
            results.add(treeNode.getVal());

            if (Objects.nonNull(treeNode.getRight())) {
                this.inorderTraversal(treeNode.getRight());
            }
        }
        return results;
    }


    /**
     * 有效二叉树
     * 借题思路：
     *  有效二叉树 根节点的所有左子树的元素均小于根节点； 右子树所有的元素均大于根节点
     *  以递归的方式，通过不断更新比较的最大值和最小值，实现对左右子树的判断
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return this.isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    private boolean isValidBST(TreeNode root, long min, long max) {
        if (Objects.isNull(root)) {
            return true;
        }

        if (root.getVal() <= min || root.getVal() >= max) {
            return false;
        }

        return isValidBST(root.getLeft(), root.getVal(), max) && isValidBST(root.getRight(), min, root.getVal());
    }


}
