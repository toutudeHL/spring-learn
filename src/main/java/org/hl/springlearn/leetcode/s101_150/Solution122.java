package org.hl.springlearn.leetcode.s101_150;

/**
 * 买卖股票的最佳时机 II
 * <p>给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>返回 你能获得的 最大 利润 。
 */
class Solution122 {

    public static void main(String[] args) {
        Solution122 Solution = new Solution122();
        System.out.println(Solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        // 121 思路不适用
        // 只要两天有差额为正，即可卖出，差额总数即为最大利润 贪心？
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                result += prices[i] - prices[i - 1];
            }
        }

        return result;
    }

}