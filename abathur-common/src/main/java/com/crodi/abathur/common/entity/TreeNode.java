package com.crodi.abathur.common.entity;

import lombok.Data;

/**
 * @author Crodi
 * @date 2024/8/5 10:40
 * @description: 二叉树节点对象
 */

@Data
public class TreeNode {

    private int val;

    private TreeNode left;

    private TreeNode right;


    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
