package org.hl.springlearn.leetcode;

import java.util.Arrays;

/**
 * 加一
 * <p>给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
class Solution66 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 3, 1})));
    }

    public static int[] plusOne(int[] digits) {
        int m = digits.length - 1;
        while (m >= 0) {
            digits[m]++;
            if (digits[m] == 10) {
                digits[m] = 0;
                if (m == 0) {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    for (int i = 1; i < digits.length; ++i) {
                        result[i] = digits[i - 1];
                    }
                    return result;
                }
                m--;
            } else {
                break;
            }
        }
        return digits;
    }


}