package org.hl.springlearn.leetcode;

/**
 * 盛最多水的容器
 * <p>给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>返回容器可以储存的最大水量
 * <p>说明：你不能倾斜容器。
 * <p>
 * 示例 1：
 * <p>输入：[1,8,6,2,5,4,8,3,7]
 * <p>输出：49
 * <p>
 * 示例 2：
 * <p>输入：height = [1,1]
 * <p>输出：1
 * <p>
 * 提示：
 * <p>n == height.length
 * <p>2 <= n <= 10^5
 * <p>0 <= height[i] <= 10^4
 */
class Solution11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}