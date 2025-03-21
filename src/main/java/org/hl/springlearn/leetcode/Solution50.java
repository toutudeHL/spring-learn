package org.hl.springlearn.leetcode;

/**
 * Pow(x, n)
 * <p>实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 */
class Solution50 {

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.00000, 3));
        System.out.println(myPow(2.00000, -2));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        }
        double temp = 1;
        if (n % 2 != 0) {
            temp = n > 0 ? x : 1 / x;

        }
        return temp * myPow(x * x, n / 2);
    }

}