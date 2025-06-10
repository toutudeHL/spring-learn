package org.hl.springlearn.leetcode.s151_200;

import java.util.Arrays;

/**
 * 轮转数组
 * <p>给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
class Solution189 {

    public static void main(String[] args) {
        Solution189 solution = new Solution189();
        int[] nums = new int[]{3, 1, 2};
        solution.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }

}

