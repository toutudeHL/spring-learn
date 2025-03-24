package org.hl.springlearn.leetcode;

/**
 * 跳跃游戏
 * <p>给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
class Solution55 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

    public static boolean canJump1(int[] nums) {
        int max = 0;
        // 这里是 max < nums.length-1 提前跳出循环
        for (int i = 0; max < nums.length - 1; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

}