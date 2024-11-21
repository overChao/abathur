package com.crodi.abathur.leetcode;


import com.alibaba.fastjson2.JSON;
import com.crodi.abathur.common.entity.TreeNode;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@ActiveProfiles("dev")
@SpringBootTest
public class SolutionTest {


    @Resource
    private Solution solution;


    @Test
    public void testInorderTraversal() {

        final TreeNode childLeftNode = new TreeNode();
        childLeftNode.setVal(3);

        final TreeNode riftNode = new TreeNode();
        riftNode.setVal(2);
        riftNode.setLeft(childLeftNode);

        final TreeNode treeNode = new TreeNode();
        treeNode.setVal(1);
        treeNode.setRight(riftNode);


        final List<Integer> result = solution.inorderTraversal(treeNode);

        System.out.println(result);

    }


    @Test
    public void testIsValidBST() {

//        int[] nums = {1, 2, 2, 3, 4, 4, 3};
        Integer[] nums = {1, 2, 2, null, 3, null, 3};

        final TreeNode treeNode = solution.sortedToBST(nums, 0);
        System.out.println(JSON.toJSONString(treeNode));
        System.out.println(solution.isSymmetric(treeNode));

    }





}