package org.hl.meeting.hwod;

import java.util.Scanner;

public class BS1 {

    public static void main(String[] args) {

        // 应输出12+34*5=182
        System.out.println(calculateFormula("abc12+34*5def"));
        // 应输出0
        System.out.println(calculateFormula("no formula here"));
        // 应输出10-6=4
        System.out.println(calculateFormula("10-2*3"));
        // 应输出3
        System.out.println(calculateFormula("-5+8"));

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        // 匹配数学表达式
        char[] chars = line.toCharArray();
        int left = 0, right = 0, len = 0;
        for (int i = 1; i < chars.length - 1; i++) {
            if (valid(chars[i - 1], chars[i], chars[i + 1])) {
                // 当前段中，起始位置为 left，已经确定三位置，从 left+2 开始判断，且后续 +1 循环
                int nowLeft = i - 1, nowRight = i + 1, nowLen = 3;
                char pre = chars[nowRight - 1];
                char cur = chars[nowRight];
                char next = chars[nowRight + 1];
                while (valid(pre, cur, next)) {
                    if (cur == '+' || cur == '-' || cur == '*') {
                        nowRight += 2;
                        nowLen += 2;
                    } else {
                        nowRight += 1;
                        nowLen += 1;
                    }
                }
                if (nowLen > len) {
                    left = nowLeft;
                    right = nowRight;
                    len = nowLen;
                }
            }
        }
        if (len < 3) {
            System.out.println(0);
            return;
        }
        // 计算
        String mathStr = line.substring(left, right + 1);
        String[] mathSpilt = mathStr.split("\\*");
        int result = getTemp1(mathSpilt[0]);
        for (int i = 1; i < mathSpilt.length; i++) {
            result *= getTemp1(mathSpilt[i]);
        }
        System.out.println(result);
    }

    private static int getTemp(String spilt) {
        int temp;
        if (spilt.contains("+")) {
            String[] temps = spilt.split("\\+");
            temp = Integer.parseInt(temps[0]);
            for (int i = 1; i < temps.length; i++) {
                temp += Integer.parseInt(temps[i]);
            }
        } else if (spilt.contains("-")) {
            String[] temps = spilt.split("-");
            temp = Integer.parseInt(temps[0]);
            for (int i = 1; i < temps.length; i++) {
                temp -= Integer.parseInt(temps[i]);
            }
        } else {
            temp = Integer.parseInt(spilt);
        }
        return temp;
    }

    private static int getTemp1(String spilt) {
        int temp = 0;
        if (spilt.contains("+")) {
            String[] temps = spilt.split("\\+");
            for (String jia : temps) {
                if (jia.contains("-")) {
                    String[] temps1 = jia.split("-");
                    for (String jia1 : temps1) {
                        temp -= Integer.parseInt(jia1);
                    }
                } else {
                    temp += Integer.parseInt(jia);
                }
            }
        } else if (spilt.contains("-")) {
            String[] temps = spilt.split("-");
            for (String jia : temps) {
                if (jia.contains("+")) {
                    String[] temps1 = jia.split("\\+");
                    for (String jia1 : temps1) {
                        temp += Integer.parseInt(jia1);
                    }
                } else {
                    temp -= Integer.parseInt(jia);
                }
            }
        } else {
            temp = Integer.parseInt(spilt);
        }
        return temp;
    }

    public static boolean valid(char pre, char cur, char next) {
        // 保证前后两位为数字，中间位置为数字或运算符
        return (pre >= '0' && pre <= '9') && (next >= '0' && next <= '9')
                && ((cur >= '0' && cur <= '9') || cur == '+' || cur == '-' || cur == '*');
    }

    public static int calculateFormula(String input) {
        // 1. 提取字符串中的数学公式
        String formula = extractFormula(input);
        if (formula == null || formula.isEmpty()) {
            return 0; // 没有找到公式
        }

        // 2. 计算公式结果
        try {
            return calculate(formula);
        } catch (Exception e) {
            System.out.println("公式计算错误: " + e.getMessage());
            return 0;
        }
    }

    // 提取字符串中的数学公式
    private static String extractFormula(String input) {
        // 简单实现：假设公式是连续的数字和运算符组成的子串
        // 实际场景可能需要更复杂的正则表达式
        StringBuilder formula = new StringBuilder();
        boolean inFormula = false;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c) || c == '+' || c == '-' || c == '*') {
                inFormula = true;
                formula.append(c);
            } else if (inFormula) {
                // 遇到非数字和运算符且已处于公式中，结束提取
                break;
            }
        }

        return formula.toString();
    }

    // 计算公式结果
    private static int calculate(String formula) {
        // 先处理乘法，再处理加减
        // 1. 处理乘法
        formula = processMultiplication(formula);

        // 2. 处理加减
        return processAdditionSubtraction(formula);
    }

    // 处理乘法运算
    private static String processMultiplication(String formula) {
        // 简单实现：使用正则表达式查找并计算乘法
        while (formula.contains("*")) {
            int starIndex = formula.indexOf('*');
            int leftNum = findNumberBefore(formula, starIndex);
            int rightNum = findNumberAfter(formula, starIndex);
            int result = leftNum * rightNum;

            // 构建新公式
            String newFormula = formula.substring(0, starIndex - String.valueOf(leftNum).length())
                    + result
                    + formula.substring(starIndex + 1 + String.valueOf(rightNum).length());
            formula = newFormula;
        }
        return formula;
    }

    // 处理加减运算
    private static int processAdditionSubtraction(String formula) {
        // 处理可能的负号开头
        if (formula.startsWith("-")) {
            formula = "0" + formula;
        }

        // 分割为项
        String[] terms = formula.split("\\+|\\-");
        boolean[] isAdd = new boolean[terms.length];

        // 确定每个项是加还是减
        int signIndex = 0;
        isAdd[0] = true; // 第一个项默认为加

        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '+' || formula.charAt(i) == '-') {
                signIndex++;
                isAdd[signIndex] = (formula.charAt(i) == '+');
            }
        }

        // 计算结果
        int result = 0;
        for (int i = 0; i < terms.length; i++) {
            if (!terms[i].isEmpty()) {
                int num = Integer.parseInt(terms[i]);
                result += (isAdd[i] ? num : -num);
            }
        }

        return result;
    }

    // 查找运算符前的数字
    private static int findNumberBefore(String formula, int operatorIndex) {
        int i = operatorIndex - 1;
        while (i >= 0 && Character.isDigit(formula.charAt(i))) {
            i--;
        }
        return Integer.parseInt(formula.substring(i + 1, operatorIndex));
    }

    // 查找运算符后的数字
    private static int findNumberAfter(String formula, int operatorIndex) {
        int i = operatorIndex + 1;
        while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
            i++;
        }
        return Integer.parseInt(formula.substring(operatorIndex + 1, i));
    }

}
