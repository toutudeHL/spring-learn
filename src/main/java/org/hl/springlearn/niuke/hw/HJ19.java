package org.hl.springlearn.niuke.hw;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ19 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] lineArr = line.split(" ");
            String fileName = getFileName(lineArr[0]);
            String content = lineArr[1];
            String key = fileName + " " + content;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int size = map.size();
        int skip = size - 8;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (skip > 0) {
                skip--;
                continue;
            }
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static String getFileName(String fileName) {
        int index = fileName.lastIndexOf("\\");
        if (fileName.length() - index > 16) {
            return fileName.substring(fileName.length() - 16);
        }
        return fileName.substring(index + 1);
    }

}
