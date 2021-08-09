package com.crodi.leetcode.arrsys;

/**
 * @Package: com.crodi.leetcode.leetcode.arrsys
 * @Author: crodi
 * @Description: leet code 1470. Shuffle the Array
 * @Date: 2020/10/26 1:57 下午
 * @Version: 1.0
 */
public class Solution {


    public static int[] shuffle(int[] nums, int n) {

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
    public static String restoreString(String s, int[] indices) {

        byte[] bytes = new byte[indices.length];
        byte[] sBytes = s.getBytes();
        for (int i = 0; i < indices.length; i++) {
            bytes[indices[i]] = sBytes[i];
        }
        return new String(bytes);
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 2, 2};

        int[] indices = new int[]{4, 5, 6, 7, 0, 2, 1, 3};

        System.out.println(restoreString("codeleet", indices));
//        System.out.println(Arrays.toString(shuffle(nums, 2)));

    }

}
