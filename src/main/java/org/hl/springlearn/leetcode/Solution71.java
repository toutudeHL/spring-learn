package org.hl.springlearn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 简化路径
 * <p>给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
 * <p>在 Unix 风格的文件系统中规则如下：
 * <p>
 * <p>一个点 '.' 表示当前目录本身。
 * <p>此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
 * <p>任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
 * <p>任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
 * <p>返回的 简化路径 必须遵循下述格式：
 * <p>
 * <p>始终以斜杠 '/' 开头。
 * <p>两个目录名之间必须只有一个斜杠 '/' 。
 * <p>最后一个目录名（如果存在）不能 以 '/' 结尾。
 * <p>此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * <p>返回简化后得到的 规范路径 。
 */
class Solution71 {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }

    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        List<String> newPaths = new ArrayList<>();
        for (String singlePath : paths) {
            if (singlePath.isEmpty() || singlePath.equals(".")) {
                continue;
            }
            if (singlePath.equals("..")) {
                if (!newPaths.isEmpty()) {
                    newPaths.remove(newPaths.size() - 1);
                }
                continue;
            }
            newPaths.add(singlePath);
        }
        if (newPaths.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        for (String singlePath : newPaths) {
            result.append("/");
            result.append(singlePath);
        }
        return result.toString();
    }

}