package org.hl.meeting.hwod;

import java.util.Scanner;

public class BS2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // TODO: 修改为String接收并转换为二进制
        long num = in.nextLong();
        String binaryString = Long.toBinaryString(num);
        int binaryLength = binaryString.length();
        int groupFirstLen = binaryLength % 7;
        int groupLength = binaryLength / 7 + (groupFirstLen == 0 ? 0 : 1);
        String[] binaryGroup = new String[groupLength];
        for (int i = 0; i < groupLength; i++) {
            int startIndex = i == 0 ? 0 : groupFirstLen + (7 * (i - 1));
            int endIndex = i == 0 ? (groupFirstLen == 0 ? 7 : groupFirstLen) : startIndex + 7;
            StringBuilder temp = new StringBuilder(binaryString.substring(startIndex, endIndex));
            if (temp.length() < 7) {
                for (int j = temp.length(); j < 7; j++) {
                    temp.insert(0, "0");
                }
            }
            binaryGroup[i] = (i == 0 ? "0" : "1") + temp;
        }
        StringBuilder result = new StringBuilder();
        for (String group : binaryGroup) {
            String left = group.substring(0, 4);
            String right = group.substring(4, 8);
            result.insert(0, convert2Hex(right)).insert(0, convert2Hex(left));
        }
        System.out.println(result);
    }


    public static String convert2Hex(String bin) {
        int result = 0;
        int index = 3;
        for (char c : bin.toCharArray()) {
            result = c == '0' ? result : (int) (result + Math.pow(2, index));
            index--;
        }
        if (result > 9) {
            switch (result) {
                case 10:
                    return "A";
                case 11:
                    return "B";
                case 12:
                    return "C";
                case 13:
                    return "D";
                case 14:
                    return "E";
                case 15:
                    return "F";
            }
        }
        return String.valueOf(result);
    }

}
