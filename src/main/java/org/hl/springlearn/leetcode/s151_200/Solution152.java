package org.hl.springlearn.leetcode.s151_200;

import java.util.Arrays;

/**
 * 乘积最大子数组
 * <p>给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>测试用例的答案是一个 32-位 整数。
 */
class Solution152 {

    public static void main(String[] args) {
        Solution152 solution = new Solution152();
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(solution.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] fMax = new int[n];
        int[] fMin = new int[n];
        fMax[0] = fMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            // 把 x 加到右端点为 i-1 的（乘积最大/最小）子数组后面，
            // 或者单独组成一个子数组，只有 x 一个元素
            fMax[i] = Math.max(Math.max(fMax[i - 1] * x, fMin[i - 1] * x), x);
            fMin[i] = Math.min(Math.min(fMax[i - 1] * x, fMin[i - 1] * x), x);
        }
        return Arrays.stream(fMax).max().getAsInt();
    }

}

