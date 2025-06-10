package org.hl.springlearn.leetcode.s701_750;

/**
 * 单调递增的数字
 * <p>当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * <p>给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 */
class Solution738 {

    public static void main(String[] args) {
        Solution738 solution = new Solution738();
        System.out.println(solution.monotoneIncreasingDigits(332));
    }

    public int monotoneIncreasingDigits(int n) {
        char[] numsChar = String.valueOf(n).toCharArray();
        int len = numsChar.length;
        int first = len;
        for (int i = len - 1; i > 0; i--) {
            if (numsChar[i] < numsChar[i - 1]) {
                numsChar[i - 1]--;
                first = i - 1;
            }
        }
        if (first != len) {
            for (int i = first + 1; i < len; i++) {
                numsChar[i] = '9';
            }
        }

        return Integer.parseInt(String.valueOf(numsChar));
    }

}