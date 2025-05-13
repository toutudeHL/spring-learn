package org.hl.springlearn.leetcode.s151_200;

/**
 * 寻找旋转排序数组中的最小值
 * <p>已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * <p>  若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * <p>  若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * <p>注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
class Solution153 {

    public static void main(String[] args) {
        Solution153 solution = new Solution153();
        int[] nums = new int[]{3, 1, 2};
        System.out.println(solution.findMin(nums));
    }

    public int findMin(int[] nums) {
        // 二分查找
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                // 左半边是正常升序，因此最小值在右半边
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }

}

