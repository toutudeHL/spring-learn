package org.hl.springlearn.leetcode;

/**
 * 爬楼梯
 * <p>假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
class Solution70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        int[] bp = new int[n + 1];
        bp[0] = 1;
        bp[1] = 2;
        for (int i = 2; i < n; i++) {
            bp[i] = bp[i - 1] + bp[i - 2];
        }
        return bp[n - 1];
    }

}