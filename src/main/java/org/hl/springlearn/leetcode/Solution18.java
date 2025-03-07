package org.hl.springlearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 四数之和
 * <p>给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * <p>0 <= a, b, c, d < n
 * <p>a、b、c 和 d 互不相同
 * <p>nums[a] + nums[b] + nums[c] + nums[d] == target
 * <p>你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * <p>输入：nums = [1,0,-1,0,-2,2], target = 0
 * <p>输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * 示例 2：
 * <p>输入：nums = [2,2,2,2,2], target = 8
 * <p>输出：[[2,2,2,2]]
 * <p>
 * 提示：
 * <p>1 <= nums.length <= 200
 * <p>-109 <= nums[i] <= 109
 * <p>-109 <= target <= 109
 */
class Solution18 {

    public static void main(String[] args) {
        // System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        // System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        // System.out.println(fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
        // System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
        System.out.println(fourSum(new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2}, -9));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过和下标i相等的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1 = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min1 > target) {
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1 = nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }
            for (int j = nums.length - 1; j > i + 2; j--) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
                int min2 = nums[i] + nums[i + 1] + nums[i + 2] + nums[j];
                if (min2 > target) {
                    break;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max2 = nums[i] + nums[j - 1] + nums[j - 2] + nums[j];
                if (max2 < target) {
                    continue;
                }
                int left = i + 1;
                int right = j - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[left] + nums[right] + nums[j];
                    // 和大于目标值，要减少，所以right--，反之left++
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int start = 0; start < length - 3; start++) {
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }

            // 当前最小值比目标值大，且随着start下标的变大后面不可能有解，直接跳出循环
            if ((long) nums[start] + nums[start + 1] + nums[start + 2] + nums[start + 3] > target) {
                break;
            }
            // 当前最大值比目标值小，但是后续随着start下标的变大可能有解，所以continue
            if ((long) nums[start] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }

            for (int end = start + 1; end < length - 2; end++) {
                if (end > start + 1 && nums[end] == nums[end - 1]) {
                    continue;
                }

                int left = end + 1, right = length - 1;

                if ((long) nums[start] + nums[end] + nums[left] + nums[left + 1] > target) {
                    break;
                }
                if ((long) nums[start] + nums[end] + nums[right] + nums[right - 1] < target) {
                    continue;
                }

                while (left < right) {
                    long sum = (long) nums[start] + nums[end] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[start], nums[end], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}