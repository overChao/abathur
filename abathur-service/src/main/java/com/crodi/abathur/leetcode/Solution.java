package com.crodi.abathur.leetcode;

import com.crodi.abathur.common.entity.TreeNode;
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

    /**
     * 数组转二叉树 仅对数组元素进行依次遍历，逐个写入到树中
     *
     * @param nums
     * @param index
     * @return
     */
    public TreeNode sortedToBST(Integer[] nums, int index) {

        if (index >= nums.length) {
            return null;
        }

        TreeNode root = new TreeNode();

        if (Objects.isNull(nums[index])) {
            return null;
        }
        root.setVal(nums[index]);
        root.setLeft(sortedToBST(nums, 2 * index + 1));
        root.setRight(sortedToBST(nums, 2 * index + 2));
        return root;
    }


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
     *
     * @param treeNode
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            if (Objects.nonNull(treeNode.getLeft())) {
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
     * 有效二叉树 根节点的所有左子树的元素均小于根节点； 右子树所有的元素均大于根节点
     * 以递归的方式，通过不断更新比较的最大值和最小值，实现对左右子树的判断
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


    /**
     * 相同树 结构和节点均相同  2024-11-18
     *
     * @param p 树A
     * @param q 树B
     * @return boolean
     */
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        }
        if (Objects.nonNull(p) && Objects.nonNull(q) && Objects.equals(p.getVal(), q.getVal())) {
            return this.isSameTree(p.getLeft(), q.getLeft()) && this.isSameTree(p.getRight(), q.getRight());
        }
        return false;
    }

    /**
     * leetCode  101. 对称二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        if (Objects.nonNull(root)) {
            return this.isSymmetric(root.getLeft(), root.getRight());
        }
        return false;
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        }
        if ((Objects.nonNull(left) && Objects.nonNull(right)) && Objects.equals(right.getVal(), left.getVal())) {
            return this.isSymmetric(left.getLeft(), right.getRight()) && this.isSymmetric(left.getRight(), right.getLeft());
        }
        return false;
    }

    /**
     * leetCode  104. 二叉树最大深度 2024 11 21
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int index = 0;
        if (Objects.isNull(root)) {
            return index;
        }
        return Math.max(maxDepth(root.getLeft(), index), maxDepth(root.getRight(), index)) + 1;
    }


    private int maxDepth(TreeNode root, int index) {
        if (Objects.isNull(root)) {
            return index;
        }
        return Math.max(maxDepth(root.getLeft(), index + 1), maxDepth(root.getRight(), index + 1));
    }


    /**
     * 111. 二叉树最小深度
     * 左右子树均存在的情况， 最小深度为 深度的最小值
     * 但是存在任一子树为空的情况下， 二叉树退化成链表，深度为链表长度
     * todo 2024 11 21 执行效率偏低 需要优化
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        int index = 0;
        if (Objects.isNull(root)) {
            return index;
        }

        if (Objects.isNull(root.getLeft())) {
            return minDepth(root.getRight(), index) + 1;
        }

        if (Objects.isNull(root.getRight())) {
            return minDepth(root.getLeft(), index) + 1;
        }

        return Math.min(minDepth(root.getLeft(), index), minDepth(root.getRight(), index)) + 1;

    }

    private int minDepth(TreeNode root, int index) {
        if (Objects.isNull(root)) {
            return index;
        }
        return Math.min(minDepth(root.getLeft(), index + 1), minDepth(root.getRight(), index + 1));
    }




}
