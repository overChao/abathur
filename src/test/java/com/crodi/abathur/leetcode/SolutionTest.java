package com.crodi.abathur.leetcode;

import com.alibaba.fastjson2.JSON;
import com.crodi.abathur.entity.TreeNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.List;


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

        System.out.println(JSON.toJSONString(treeNode));


        final List<Integer> result = solution.inorderTraversal(treeNode);

        System.out.println(result);

    }


    @Test
    public void testIsValidBST() {

        final TreeNode childLeftNode = new TreeNode();
        childLeftNode.setVal(3);

        final TreeNode childRightNode = new TreeNode();
        childRightNode.setVal(4);

        final TreeNode riftNode = new TreeNode();
        riftNode.setVal(2);
//        riftNode.setLeft(childLeftNode);
//        riftNode.setRight(childRightNode);

        final TreeNode leftNode = new TreeNode();
        leftNode.setVal(2);

        final TreeNode treeNode = new TreeNode();
        treeNode.setVal(2);
        treeNode.setRight(riftNode);
        treeNode.setLeft(leftNode);

        final boolean validBST = solution.isValidBST(treeNode);

        System.out.println(validBST);

    }


}