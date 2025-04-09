package com.cordi.abathur.leetcode;

/**
 * @Package: com.crodi.leetcode.leetcode.arrsys
 * @Author: crodi
 * @Description: leet code  1108. Defanging an IP Address
 * @Date: 2020/10/27 4:18 下午
 * @Version: 1.0
 */
public class Solution1027 {

    public static String defineIPAddr(String address) {


        char[] chars = address.toCharArray();

        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == '.') {
                result.append("[.]");
            } else {
                result.append(aChar);
            }
        }

        return result.toString();
    }


    public static void main(String[] args) {

        String address = "255.100.50.0";
        System.out.println(defineIPAddr(address));


    }

}
