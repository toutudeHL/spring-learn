package org.hl.springlearn.leetcode.s101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * <p>给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
class Solution118 {

    public static void main(String[] args) {
        Solution118 Solution = new Solution118();
        System.out.println(Solution.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        generate(result, numRows, 1);
        return result;
    }

    public void generate(List<List<Integer>> result, int numRows, int row) {
        if (row > numRows) {
            return;
        }
        List<Integer> rowList = new ArrayList<>();
        // 首位固定为 1
        rowList.add(1);
        if (row > 1) {
            // 中间位置 从第二个元素开始直到倒数第二个元素
            List<Integer> preRow = result.get(row - 2);
            for (int i = 1; i <= row - 2; i++) {
                rowList.add(preRow.get(i - 1) + preRow.get(i));
            }
            // 末尾固定为 1
            rowList.add(1);
        }
        result.add(rowList);
        generate(result, numRows, row + 1);
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> oneRow = new ArrayList<>(1);
        oneRow.add(1);
        result.add(oneRow);
        for (int rowIndex = 1; rowIndex < numRows; rowIndex++) {
            List<Integer> row = new ArrayList<>(rowIndex + 1);
            row.add(1);
            for (int j = 1; j < rowIndex; j++) {
                // 左上方的数 + 正上方的数
                row.add(result.get(rowIndex - 1).get(j - 1) + result.get(rowIndex - 1).get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

}