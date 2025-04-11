package org.hl.springlearn.leetcode.s1_50;

/**
 * 搜索旋转排序数组
 * <p>整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * <p>  例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
class Solution33 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (nums[0] < nums[nums.length - 1]) {
            // 如果nums[0]小于nums[nums.length - 1]，说明数组没有反转，二分法查找
            if (target < nums[0] || target > nums[nums.length - 1]) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        } else {
            // 数组反转了，需要判断目标值在哪个区间
            // 如果目标值比nums[0]小，说明目标值需要在反转的后半段寻找；反之，目标值需要在反转的前半段寻找
            if (target < nums[0]) {
                for (int i = nums.length - 1; i > 0; i--) {
                    if (nums[i] == target) {
                        return i;
                    }
                    if (nums[i - 1] > nums[i]) {
                        break;
                    }
                }
            } else {
                for (int i = 0; i < nums.length - 1; i++) {
                    if (nums[i] == target) {
                        return i;
                    }
                    if (nums[i + 1] < nums[i]) {
                        break;
                    }
                }
            }
        }
        return -1;
    }

}