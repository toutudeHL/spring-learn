package org.hl.springlearn.leetcode.s1_50;

/**
 * 跳跃游戏 II
 * <p>给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>  0 <= j <= nums[i]
 * <p>  i + j < n
 * <p>返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
class Solution45 {

    public static void main(String[] args) {
        // System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        // System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(jump(new int[]{1, 2, 1, 1, 1}));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int length = nums.length;
        int result = 1;
        int index = 0;
        while (index < length) {
            int maxIndex = 0;
            for (int i = 1; i <= nums[index]; i++) {
                // 当前位置能直接跳到最后一个位置，直接返回
                if (index + i >= length - 1) {
                    return result;
                }
                if (i + nums[index + i] >= maxIndex + nums[index + maxIndex]) {
                    maxIndex = i;
                }
            }
            index += maxIndex;
            result++;
        }
        return result;
    }

}