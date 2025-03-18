package org.hl.springlearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 * <p>给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>注意：解集不能包含重复的组合。
 */
class Solution40 {

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> single = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        int start = 0;
        backtrack(candidates, target, result, single, start, used);
        return result;
    }

    private static void backtrack(int[] candidates, int target, ArrayList<List<Integer>> result, ArrayList<Integer> single, int start, boolean[] used) {
        if (target == 0) {
            result.add(new ArrayList<>(single));
            return;
        }
        while (start < candidates.length && target >= candidates[start]) {
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (start > 0 && candidates[start] == candidates[start - 1] && !used[start - 1]) {
                start++;
                continue;
            }
            single.add(candidates[start]);
            used[start] = true;
            // 每个元素只能使用一次，所以此处需要 start + 1
            backtrack(candidates, target - candidates[start], result, single, start + 1, used);
            used[start] = false;
            single.remove(single.size() - 1);
            start++;
        }
    }

}