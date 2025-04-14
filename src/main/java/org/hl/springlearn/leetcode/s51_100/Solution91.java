package org.hl.springlearn.leetcode.s51_100;

/**
 * 解码方法
 * <p>一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>  "1" -> 'A'
 * <p>  "2" -> 'B'
 * <p>  ...
 * <p>  "25" -> 'Y'
 * <p>  "26" -> 'Z'
 * <p>然而，在 解码 已编码的消息时，你意识到有许多不同的方式来解码，因为有些编码被包含在其它编码当中（"2" 和 "5" 与 "25"）。
 * <p>例如，"11106" 可以映射为：
 * <p>  "AAJF" ，将消息分组为 (1, 1, 10, 6)
 * <p>  "KJF" ，将消息分组为 (11, 10, 6)
 * <p>  消息不能分组为  (1, 11, 06) ，因为 "06" 不是一个合法编码（只有 "6" 是合法的）。
 * <p>注意，可能存在无法解码的字符串。
 * <p>给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。如果没有合法的方式解码整个字符串，返回 0。
 * <p>题目数据保证答案肯定是一个 32 位 的整数。
 */
class Solution91 {

    public static void main(String[] args) {
        // TODO 动态规划回顾
        System.out.println(numDecodings1("12"));
        System.out.println(numDecodings1("226"));
        System.out.println(numDecodings1("06"));
    }

    public static int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        s = " " + s;
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            int now = s.charAt(i) - '0';
            int pre = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (1 <= now && now <= 9 && 10 <= pre && pre <= 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else if (1 <= now && now <= 9) {
                dp[i] = dp[i - 1];
            } else if (10 <= pre && pre <= 26) {
                dp[i] = dp[i - 2];
            }
        }
        return dp[length];
    }

    public static int numDecodings1(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        s = " " + s;
        // 压缩空间
        int[] dp = new int[3];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            dp[i % 3] = 0;
            int now = s.charAt(i) - '0';
            int pre = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (1 <= now && now <= 9 && 10 <= pre && pre <= 26) {
                dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
            } else if (1 <= now && now <= 9) {
                dp[i % 3] = dp[(i - 1) % 3];
            } else if (10 <= pre && pre <= 26) {
                dp[i % 3] = dp[(i - 2) % 3];
            }
        }
        return dp[length % 3];
    }

}