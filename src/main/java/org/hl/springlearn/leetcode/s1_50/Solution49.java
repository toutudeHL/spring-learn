package org.hl.springlearn.leetcode.s1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 * <p>给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
class Solution49 {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        HashMap<String, List<String>> tempMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (tempMap.containsKey(key)) {
                tempMap.get(key).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                tempMap.put(key, list);
            }
        }
        for (String key : tempMap.keySet()) {
            result.add(tempMap.get(key));
        }
        return result;
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        ArrayList<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        HashMap<String, List<String>> tempMap = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            if (tempMap.containsKey(key)) {
                tempMap.get(key).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                tempMap.put(key, list);
            }
        }
        for (String key : tempMap.keySet()) {
            result.add(tempMap.get(key));
        }
        return result;
    }

}