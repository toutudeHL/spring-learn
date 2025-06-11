package org.hl.meeting.hwod;

import java.util.Arrays;

/**
 * 合并两个有序数组 leetcode-88-easy
 * 技术二面手撕
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int len = m + n - 1;
        int x = m - 1, y = n - 1;
        while (x >= 0 && y >= 0) {
            if (nums2[y] >= nums1[x]) {
                nums1[len] = nums2[y];
                y--;
            } else {
                nums1[len] = nums1[x];
                x--;
            }
            len--;
        }
        if (y >= 0) {
            for (int i = y; i >= 0; i--) {
                nums1[len--] = nums2[i];
            }
        }
    }

}