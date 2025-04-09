package com.cordi.abathur.leetcode;


import com.alibaba.fastjson2.JSON;
import com.crodi.abathur.entity.TreeNode;
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


    @Test
    public void testMaxDepth() {

//        Integer[] root = {3,9,20,null,null,15,7};
        Integer[] root = {2,null,3,null,4,null,5,null,6};
        final TreeNode treeNode = solution.sortedToBST(root, 0);

        System.out.println(JSON.toJSONString(treeNode));
        System.out.println(solution.maxDepth(treeNode));



    }


    @Test
    public void testIsBalanced() {
//        Integer[] root = {1,2,2,3,3,null,null,4,4};
        Integer[] root = {1,2,2,3,null,null,3,4,null,null,4};
        final TreeNode treeNode = solution.sortedToBST(root, 0);

        System.out.println(JSON.toJSONString(treeNode));
        System.out.println(solution.isBalanced(treeNode));
    }

    @Test
    public void testHasPathSum() {
        Integer[] root = {10,2,11,0};
        final TreeNode treeNode = solution.sortedToBST(root, 0);

        System.out.println(JSON.toJSONString(treeNode));
        System.out.println(solution.hasPathSum(treeNode, 12));

    }


    @Test
    public void testPathSum() {


        Integer[] root = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        final TreeNode treeNode = solution.sortedToBST(root, 0);

        System.out.println(JSON.toJSONString(treeNode));

        final List<List<Integer>> lists = solution.pathSum(treeNode, 22);
        System.out.println(lists);
    }





    @Test
    public void testValueReference(){


        final List<@Nullable Object> res = Lists.newArrayList();
        final List< Object> objects = Lists.newArrayList();

        System.out.println("1. " + JSON.toJSONString(objects));
        objects.add(1);

        System.out.println("2. " + JSON.toJSONString(objects));
        res.add(objects);
        System.out.println("3. " + JSON.toJSONString(res));
        objects.remove(objects.size() -1);
        System.out.println("4. " + JSON.toJSONString(objects));
        System.out.println("5. " + JSON.toJSONString(res));



    }



}