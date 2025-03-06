package org.hl.springlearn.leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * <p>给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>返回这三个数的和。
 * <p>假定每组输入只存在恰好一个解。
 */
class ThreeSumClosest16 {

    public static void main(String[] args) {
        // System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        // System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
        // System.out.println(threeSumClosest(new int[]{1, 1, 1, 1}, 3));
        System.out.println(threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return sum;
                }
            }
        }
        return res;
    }
}