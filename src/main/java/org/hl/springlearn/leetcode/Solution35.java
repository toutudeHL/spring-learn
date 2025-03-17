package org.hl.springlearn.leetcode;

/**
 * 搜索插入位置
 * <p>给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>请必须使用时间复杂度为 O(log n) 的算法。
 */
class Solution35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                while (mid > 0 && nums[mid - 1] == nums[mid]) {
                    mid--;
                }
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // if (nums[left] < target) {
        //     while (left < nums.length && nums[left] < target) {
        //         left++;
        //     }
        //     return left - 1;
        // } else {
        //     while (left >= 0 && nums[left] > target) {
        //         left--;
        //     }
        //     return left + 1;
        // }
        return left;
    }

}