package org.hl.springlearn.leetcode.s51_100;

/**
 * 搜索旋转排序数组 II
 * <p>已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * <p>在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * <p>给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * <p>你必须尽可能减少整个操作步骤。
 */
class Solution81 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }

    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        // 分情况讨论
        if (nums[0] < nums[nums.length - 1]) {
            // 如果数组未旋转，则二分法搜索
            return notRotate(nums, target);
        } else {
            // 如果数组旋转了，则通过目标值确定区间遍历
            return rotate(nums, target);
        }
    }

    public static boolean notRotate(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean rotate(int[] nums, int target) {
        int length = nums.length - 1;
        if (target == nums[0] || target == nums[length]) {
            return true;
        }
        int index;
        if (target > nums[0]) {
            index = 0;
            while (index < length - 1 && nums[index + 1] >= nums[index]) {
                if (nums[index + 1] == target) {
                    return true;
                } else {
                    index++;
                }
            }
        } else {
            index = length;
            while (index > 0 && nums[index - 1] <= nums[index]) {
                if (nums[index - 1] == target) {
                    return true;
                } else {
                    index--;
                }
            }
        }
        return false;
    }

}