package org.hl.springlearn.niuke.hw;

import java.util.Scanner;

public class HJ17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] steps = line.split(";");
        int[] result = new int[]{0, 0};
        for (String step : steps) {
            if (step.length() < 2 || step.length() > 3) {
                continue;
            }
            String dir = step.substring(0, 1);
            if (!("A".equals(dir) || "D".equals(dir) || "W".equals(dir) ||
                    "S".equals(dir))) {
                continue;
            }
            String numStr = step.substring(1);
            if (!isNum(numStr)) {
                continue;
            }
            int num = Integer.parseInt(numStr);
            if (num < 0 || num > 99) {
                continue;
            }
            switch (dir) {
                case "A":
                    result[0] = result[0] - num;
                    break;
                case "D":
                    result[0] = result[0] + num;
                    break;
                case "W":
                    result[1] = result[1] + num;
                    break;
                case "S":
                    result[1] = result[1] - num;
                    break;
                default:
            }
        }
        System.out.println(result[0] + "," + result[1]);
    }

    public static boolean isNum(String num) {
        char[] chars = num.toCharArray();
        for (char c : chars) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}
