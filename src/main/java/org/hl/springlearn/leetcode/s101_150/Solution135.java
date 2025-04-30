package org.hl.springlearn.leetcode.s101_150;

/**
 * 只出现一次的数字
 * <p>给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
class Solution135 {

    public static void main(String[] args) {
        Solution135 solution = new Solution135();
        int[] nums = new int[]{2, 2, 1};
        System.out.println(solution.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // TODO 异或回顾
            // 交换律：a ^ b ^ c = a ^ c ^ b
            // 任何数与0异或为任何数 0 ^ n = n
            // 相同的数异或为0: n ^ n = 0
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

}