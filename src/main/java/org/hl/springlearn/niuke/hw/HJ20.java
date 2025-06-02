package org.hl.springlearn.niuke.hw;

import java.util.Scanner;

public class HJ20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String password = in.nextLine();
            System.out.println(isValid(password) ? "OK" : "NG");
        }
    }

    public static boolean isValid(String password) {
        // 长度不少于 8 位
        if (password.length() < 8) {
            return false;
        }
        // 必须包含大写字母、小写字母、数字、特殊字符中的至少三种
        boolean hasUpper = false, hasLower = false, hasNum = false, hasSpecial = false;
        int count = 0;
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9' && !hasNum) {
                hasNum = true;
                count += 1;
            } else if (c >= 'a' && c <= 'z' && !hasLower) {
                hasLower = true;
                count += 1;
            } else if (c >= 'A' && c <= 'Z' && !hasUpper) {
                hasUpper = true;
                count += 1;
            } else if (isSpecial(c) && !hasSpecial) {
                hasSpecial = true;
                count += 1;
            }
        }
        if (count < 3) {
            return false;
        }
        // 不能分割出两个独立的、长度大于 2 的连续子串，使得这两个子串完全相同
        return !getString(password, 0, 3);
    }

    public static boolean isSpecial(char c) {
        return c >= '!' && c <= '/' || c >= ':' && c <= '@'
                || c >= '[' && c <= '·' || c >= '{' && c <= '~';
    }

    private static boolean getString(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return getString(str,l+1,r+1);
        }
    }

}
