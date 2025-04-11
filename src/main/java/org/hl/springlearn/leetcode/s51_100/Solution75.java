package org.hl.springlearn.leetcode.s51_100;

import java.util.Arrays;

/**
 * 颜色分类
 * <p>给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
class Solution75 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index < nums.length && index <= right) {
            if (nums[index] == 0) {
                int tmp = nums[left];
                nums[left] = nums[index];
                nums[index] = tmp;
                left++;
                index++;
            } else if (nums[index] == 2) {
                int tmp = nums[right];
                nums[right] = nums[index];
                nums[index] = tmp;
                right--;
            } else if (nums[index] == 1) {
                index++;
            }
        }
        for (int i = left; i <= right; i++) {
            nums[i] = 1;
        }
    }

}