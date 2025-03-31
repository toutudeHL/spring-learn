package org.hl.springlearn.leetcode;

/**
 * x 的平方根
 * <p>给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 */
class Solution69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > x) {
                right = mid;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }

}