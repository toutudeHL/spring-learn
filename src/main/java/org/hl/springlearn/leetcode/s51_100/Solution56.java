package org.hl.springlearn.leetcode.s51_100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 合并区间
 * <p>以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
class Solution56 {

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        System.out.println(Arrays.deepToString(merge(intervals)));
        int[][] intervals1 = {
                {1, 4},
                {4, 5}
        };
        System.out.println(Arrays.deepToString(merge(intervals1)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                result.add(new int[]{temp[0], temp[1]});
                temp = intervals[i];
            }
        }
        result.add(new int[]{temp[0], temp[1]});
        return result.toArray(new int[result.size()][]);
    }

}