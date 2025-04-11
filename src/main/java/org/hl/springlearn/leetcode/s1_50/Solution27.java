package org.hl.springlearn.leetcode.s1_50;

/**
 * 移除元素
 * <p>给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * <p>假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * <p>更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * <p>返回 k。
 */
class Solution27 {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 1));
    }

    public static int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }

}