package com.crodi.abathur.leetcode;

/**
 * @Package: com.crodi.leetcode.leetcode.arrsys
 * @Author: crodi
 * @Description: leet code 1512. Number of Good Pairs
 * @Date: 2020/10/29 11:40 上午
 * @Version: 1.0
 */
public class Solution1029 {

    public static int numIdenticalPairs(int[] nums) {

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[i] == nums[j + 1]) {
                    total++;
                }
            }
        }
        return total;
    }


//    public static void main(String[] args) {
//
//        int[] nums = new  int[]{1,2,3};
//        System.out.println(numIdenticalPairs(nums));
//
//    }

}
