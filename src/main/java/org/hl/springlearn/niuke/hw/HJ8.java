package org.hl.springlearn.niuke.hw;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeMap<Integer, Integer> result = new TreeMap<>();
        while (n > 0) {
            int key = in.nextInt();
            int value = in.nextInt();
            result.put(key, result.getOrDefault(key, 0) + value);
            n--;
        }
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
