package com.personal.mystudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer {
    static List<Map<Integer, Integer>> HANOI_LIST = new ArrayList<>();
    public static int[][] hanoi(int n) {
        hanoiTower(1, 2, 3, n);
        int[][] answer = new int[HANOI_LIST.size()][2];
        for (int i= 0; i < HANOI_LIST.size(); i++) {
            int[] val = new int[2];
            for (int key : HANOI_LIST.get(i).keySet()) {
                val[0] = key;
                val[1] = HANOI_LIST.get(i).get(key);
            }
            answer[i] = val;
        }
        return answer;
    }

    private static void hanoiTower(int start, int middle, int to, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if (n == 1) {
            // 배열의 이동 정보 저장
            map.put(start, to);
            HANOI_LIST.add(map);
            return;
        } else {
            hanoiTower(start, to, middle, n - 1);
            // 배열의 이동 정보 저장
            map.put(start, to);
            HANOI_LIST.add(map);
            hanoiTower(middle, start, to, n - 1);
        }
    }

    public static int[] triangle(int n) {
        int[][] result = new int[n][n];
        int number = 1;
        int i = 0;
        int j = 0;
        boolean isComplete = false;
        boolean isMove = true;
        while(!isComplete) {
            if (result[i][j] > 0) {
                if (isMove) {
                    j++;
                }
            }
            result[i][j] = number;
            number++;
            if (isMove && i == n - 1) {
                j++;
                if (j == n) {
                    isMove = false;
                    i--;
                    j -= 2;
                }
            } else if (!isMove) {
                i--;
                j--;
                if (result[i][j] > 0) {
                    isMove = true;
                    i += 2;
                    j++;
                }
            }
        }
        return new int[0];
    }
}
