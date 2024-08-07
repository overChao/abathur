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


    private final List<Integer> results = Lists.newArrayList();

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


}
