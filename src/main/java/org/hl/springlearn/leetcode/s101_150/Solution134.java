package org.hl.springlearn.leetcode.s101_150;

/**
 * 加油站
 * <p>在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */
class Solution134 {

    public static void main(String[] args) {
        Solution134 solution = new Solution134();
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(solution.canCompleteCircuit(gas, cost));
        System.out.println(solution.canCompleteCircuit1(gas, cost));
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        // 始发站
        int startIdx = 0;
        // 到达下一个加油站加油之前的累计剩余油量
        int curGas = 0;

        // 一遍循环下来之后，始发站一定是可以走到末尾，这样，后半段的条件已经满足了，只需要在验证前半段是否满足即可
        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                // 油量不够, 更新始发站，从i+1重新出发
                startIdx = i + 1;
                curGas = 0;
            }
        }

        // 判断累计剩余油量能否走完始发站之前的加油站（也就是前半段）
        for (int i = 0; i < startIdx; i++) {
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                // 不满足，直接返回 -1
                return -1;
            }
        }

        return startIdx;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 34 / 39 超时
        for (int i = 0; i < gas.length; i++) {
            // 从第 i 个开始遍历
            boolean can = dps(gas, cost, i, i, i + 1, gas[i]);
            if (can) {
                return i;
            }
        }
        return -1;
    }

    public boolean dps(int[] gas, int[] cost, int start, int pre, int next, int gasCount) {
        // 如果 next 到达数组末尾，需要重置为开始
        if (next >= gas.length) {
            next = 0;
        }
        // 如果 next 等于 start 说明够一圈了，只要油够即可完成
        if (next == start && gasCount >= cost[pre]) {
            return true;
        }
        if (gasCount < cost[pre]) {
            // 油不够，直接返回 false
            return false;
        } else {
            // 尝试到下一地点
            return dps(gas, cost, start, next, next + 1, gasCount + gas[next] - cost[pre]);
        }
    }

}