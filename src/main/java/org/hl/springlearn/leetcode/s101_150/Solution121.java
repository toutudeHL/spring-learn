package org.hl.springlearn.leetcode.s101_150;

/**
 * 买卖股票的最佳时机
 * <p>给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
class Solution121 {

    public static void main(String[] args) {
        Solution121 Solution = new Solution121();
        System.out.println(Solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        // 维护一个当前数值之前最小的值，也就是最低买入点
        int minPrices = Math.min(prices[0], prices[1]);
        // 最大收益，初始化为前两天差额
        int result = prices[1] - prices[0];
        for (int i = 2; i < length; i++) {
            // 更新最低买入点
            minPrices = Math.min(minPrices, prices[i]);
            // 最大收益 为 前一天的最大收益 和 当天的数值-最低买入点 的 最大值
            result = Math.max(result, prices[i] - minPrices);
        }

        return Math.max(result, 0);

        // 100%
        // int cost = Integer.MAX_VALUE, profit = 0;
        // for (int price : prices) {
        //     cost = Math.min(cost, price);
        //     profit = Math.max(profit, price - cost);
        // }
        // return profit;
    }

    public int maxProfit1(int[] prices) {
        // 202 / 212 超时
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int result = prices[1] - prices[0];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                result = Math.max(result, prices[j] - prices[i]);
            }
        }
        return Math.max(result, 0);
    }

}