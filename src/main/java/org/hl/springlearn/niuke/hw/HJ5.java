package org.hl.springlearn.niuke.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ5 {

    public static Map<Character, Integer> hexMap = new HashMap<>(16);

    static {
        hexMap.put('0', 0);
        hexMap.put('1', 1);
        hexMap.put('2', 2);
        hexMap.put('3', 3);
        hexMap.put('4', 4);
        hexMap.put('5', 5);
        hexMap.put('6', 6);
        hexMap.put('7', 7);
        hexMap.put('8', 8);
        hexMap.put('9', 9);
        hexMap.put('A', 10);
        hexMap.put('B', 11);
        hexMap.put('C', 12);
        hexMap.put('D', 13);
        hexMap.put('E', 14);
        hexMap.put('F', 15);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String hex = in.nextLine();
        char[] chars = hex.toCharArray();
        int n = chars.length;
        int result = 0;
        for (int i = n - 1; i > 1; i--) {
            result += hexMap.get(chars[i]) * Math.pow(16, n - i - 1);
        }
        System.out.println(result);
    }

}
