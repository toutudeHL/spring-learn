package org.hl.springlearn.leetcode.s51_100;

import java.util.Arrays;

/**
 * 交错字符串
 * <p>给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>  s = s1 + s2 + ... + sn
 * <p>  t = t1 + t2 + ... + tm
 * <p>  |n - m| <= 1
 * <p>  交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * <p>注意：a + b 意味着字符串 a 和 b 连接。
 */
class Solution97 {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        // 99 / 106 超时了
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray(), cs3 = s3.toCharArray();
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i < m && cs1[i] == cs3[i + j] && j < n && cs2[j] == cs3[i + j]) {
                return isInterleave(s1.substring(i + 1), s2.substring(j), s3.substring(i + j + 1))
                        || isInterleave(s1.substring(i), s2.substring(j + 1), s3.substring(i + j + 1));
            } else if (i < m && cs1[i] == cs3[i + j]) {
                i++;
            } else if (j < n && cs2[j] == cs3[i + j]) {
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isInterleave1(String s1, String s2, String s3) {
        // TODO 回顾 动态规划+记忆化实现
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        // 倒序匹配和正序匹配类似
        return dfs(m - 1, n - 1, s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), memo);
    }

    private static boolean dfs(int i, int j, char[] s1, char[] s2, char[] s3, int[][] memo) {
        if (i < 0 && j < 0) {
            return true;
        }
        if (memo[i + 1][j + 1] != -1) { // 之前计算过
            return memo[i + 1][j + 1] == 1;
        }
        boolean res = i >= 0 && s1[i] == s3[i + j + 1] && dfs(i - 1, j, s1, s2, s3, memo) ||
                j >= 0 && s2[j] == s3[i + j + 1] && dfs(i, j - 1, s1, s2, s3, memo);
        memo[i + 1][j + 1] = res ? 1 : 0; // 记忆化
        return res;
    }

}