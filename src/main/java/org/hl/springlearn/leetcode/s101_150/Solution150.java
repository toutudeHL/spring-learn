package org.hl.springlearn.leetcode.s101_150;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * <p>给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * <p>请你计算该表达式。返回一个表示表达式值的整数。
 * <p>注意：
 * <p>  有效的算符为 '+'、'-'、'*' 和 '/' 。
 * <p>  每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * <p>  两个整数之间的除法总是 向零截断 。
 * <p>  表达式中不含除零运算。
 * <p>  输入是一个根据逆波兰表示法表示的算术表达式。
 * <p>  答案及所有中间计算结果可以用 32 位 整数表示。
 */
class Solution150 {

    public static void main(String[] args) {
        Solution150 solution = new Solution150();
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(solution.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        // 循环递归入栈，先入后出，只要碰到运算符就将最近的两个数进行运算，并将结果放回
        for (String token : tokens) {
            boolean isOperator = token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
            if (isOperator) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result;
                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    default:
                        result = 0;
                }
                stack.push(result);
            } else {
                int operand = Integer.parseInt(token);
                stack.push(operand);
            }
        }

        return stack.pop();
    }

}

