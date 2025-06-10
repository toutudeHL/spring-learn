package org.hl.meeting.hwod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BS3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int smfNum = in.nextInt();
        int[][] smfArr = new int[smfNum][2];
        for (int i = 0; i < smfNum; i++) {
            smfArr[i][0] = in.nextInt();
            smfArr[i][1] = in.nextInt();
        }

        int upfNum = in.nextInt();
        int[][] upfArr = new int[upfNum][2];
        for (int i = 0; i < upfNum; i++) {
            upfArr[i][0] = in.nextInt();
            upfArr[i][1] = in.nextInt();
        }

        int[][] distanceArr = new int[smfNum][upfNum];
        for (int i = 0; i < smfNum; i++) {
            for (int j = 0; j < upfNum; j++) {
                distanceArr[i][j] = calCheByShev(smfArr[i][0], smfArr[i][1], upfArr[j][0], upfArr[j][1]);
            }
        }

        List<Integer> smfList = new ArrayList<>();
        List<Integer> upfList = new ArrayList<>();

        int result = 0;
        for (int i = 0; i < smfNum; i++) {
            int min = Integer.MAX_VALUE;
            int minSmf = Integer.MAX_VALUE;
            int minUpf = Integer.MAX_VALUE;
            for (int m = 0; m < smfNum; m++) {
                if (smfList.contains(m)) {
                    continue;
                }
                for (int n = 0; n < upfNum; n++) {
                    if (upfList.contains(n)) {
                        continue;
                    }
                    int cur = distanceArr[m][n];
                    if (cur < min) {
                        min = cur;
                        minSmf = m;
                        minUpf = n;
                    } else if (cur == min) {
                        if (m < minSmf || (m == minSmf && n < minUpf)) {
                            minSmf = m;
                            minUpf = n;
                        }
                    }
                }
            }
            smfList.add(minSmf);
            upfList.add(minUpf);
            result += min;
        }
        System.out.println(result);
    }

    public static int calCheByShev(int smfX, int smfY, int upfX, int upfY) {
        return Math.max(Math.abs(smfX - upfX), Math.abs(smfY - upfY));
    }

}
