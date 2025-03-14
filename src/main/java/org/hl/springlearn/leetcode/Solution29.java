package org.hl.springlearn.leetcode;

/**
 * 两数相除
 * <p>给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * <p>整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * <p>返回被除数 dividend 除以除数 divisor 得到的 商 。
 * <p>注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2^31,  2^31 − 1] 。
 * <p>本题中，如果商 严格大于 2^31 − 1 ，则返回 2^31 − 1 ；如果商 严格小于 -2^31 ，则返回 -2^31 。
 */
class Solution29 {

    public static void main(String[] args) {
        // System.out.println(divide(10, 3));
        // System.out.println(divide(2147483647, 1));
        System.out.println(divide(-2147483648, 1));
    }

    public static int divide(int dividend, int divisor) {
        // TODO：回顾倍增解法
        // 特殊情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            sign = 1;
        }
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int result = 0;
        while (dividend <= divisor) {
            int tmp = divisor;
            int count = 1;
            while (tmp >= dividend - tmp) {
                // 倍增
                tmp += tmp;
                count += count;
            }
            // 被除数减去除数的 2^x 倍数做为新的被除数
            dividend -= tmp;
            // count 即 2^x
            result += count;
        }
        return sign == 1 ? result : -result;
    }

}