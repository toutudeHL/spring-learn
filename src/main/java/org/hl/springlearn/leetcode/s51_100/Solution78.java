package org.hl.springlearn.leetcode.s51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * <p>给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
class Solution78 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtrack(result, new ArrayList<>(), nums, i, 0);
        }
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int size, int index) {
        if (tempList.size() == size) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, size, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}