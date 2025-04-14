package org.hl.springlearn.leetcode.s51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 II
 * <p>给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
 * <p>解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
class Solution90 {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtrack(result, new ArrayList<>(), nums, i, 0);
        }
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int size, int index) {
        if (tempList.size() == size) {
            if (!result.contains(tempList)) {
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, size, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtrack1(result, new ArrayList<>(), nums, used, i, 0);
        }
        return result;
    }

    private static void backtrack1(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used, int size, int index) {
        if (tempList.size() == size) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // 剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            used[i] = true;
            backtrack1(result, tempList, nums, used, size, i + 1);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

}