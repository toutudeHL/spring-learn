package org.hl.springlearn.leetcode.s51_100;

/**
 * 删除有序数组中的重复项 II
 * <p>给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
class Solution80 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    public static int removeDuplicates(int[] nums) {
        // TODO 同向双指针，理解为入栈，如果当前元素和前两个元素不同即可入栈
        int left = 2;
        for (int right = 2; right < nums.length; ++right) {
            if (nums[right] != nums[left - 2]) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }

}