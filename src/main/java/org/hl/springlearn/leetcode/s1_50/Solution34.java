package org.hl.springlearn.leetcode.s1_50;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * <p>给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
class Solution34 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : result;
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return result;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                int start = mid, end = mid;
                while (start >= 0 && nums[start] == target) {
                    start--;
                }
                while (end < nums.length && nums[end] == target) {
                    end++;
                }
                return new int[]{start + 1, end - 1};
            }
        }
        return result;
    }

}