package org.hl.springlearn.leetcode;

/**
 * 下一个排列
 * <p>整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>  例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * <p>整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>  例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * <p>  类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * <p>  而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * <p>给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>必须 原地 修改，只允许使用额外常数空间。
 */
class Solution31 {

    public static void main(String[] args) {
        nextPermutation(new int[]{3, 2, 1});
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        // 从后往前，需要先找到第一个升序的位置
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // 不是最大的数，说明还有比他大的
            // 此时从i开始，找到比nums[i]大的最小的数，然后交换位置
            int min = i + 1;
            for (int k = i + 2; k < nums.length; k++) {
                if (nums[k] > nums[i] && nums[k] < nums[min]) {
                    min = k;
                }
            }
            swap(nums, i, min);
            // 交换后，需要将i之后的数据进行升序排序
            i++;
        } else {
            // 是最大的数，直接找最小的数，即从头开始升序排序
            i = 0;
        }
        while (i <= nums.length - 2) {
            // 冒泡排序，从i开始的数进行从小到大排序
            int min = i;
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[min] > nums[k]) {
                    min = k;
                }
            }
            if (min != i) {
                swap(nums, i, min);
            }
            i++;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}