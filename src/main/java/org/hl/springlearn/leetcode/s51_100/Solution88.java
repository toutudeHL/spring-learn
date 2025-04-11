package org.hl.springlearn.leetcode.s51_100;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * <p>给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
class Solution88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 0, 0};
        int[] nums2 = new int[]{-1, 5, 6};
        merge(nums1, 0, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 边界极端情况判断
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        // 从大到小依次倒序填充
        int index1 = Math.max(m - 1, 0);
        int index2 = n - 1;
        int index3 = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index3--] = nums1[index1--];
            } else {
                nums1[index3--] = nums2[index2--];
            }
        }
        while (index2 >= 0) {
            nums1[index3--] = nums2[index2--];
        }
    }

}