package com.personal.mystudy;

import java.util.*;

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
        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                matrix[x][y] = num++;
            }
        }

        int k = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }

    public static String game(int n, int t, int m, int p) {
        StringBuilder binary = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int number = 0;
        while(m * t > binary.length()) {
            binary.append(Integer.toString(number, n));
            number++;
        }

        char[] temp = binary.toString().toCharArray();

        for (int i = p - 1; i < m * t; i = i + m) {
            answer.append(temp[i]);
        }

        return answer.toString().toUpperCase();
    }

    public static int[] quad(int[][] arr) {
        return quadDfs(arr, 0, 0, arr.length, new int[2]);
    }

    private static int[] quadDfs(int[][] arr, int row, int col, int length, int[] count) {
        int value = arr[row][col];
        boolean match = true;

        for (int i = row; match && i < row + length; i++) {
            for (int j = col; match && j < col + length; j++) {
                match &= value == arr[i][j];
            }
        }

        if (match) {
            count[value]++;
        } else {
            length /= 2;

            quadDfs(arr, row, col, length, count);
            quadDfs(arr, row + length, col, length, count);
            quadDfs(arr, row, col + length, length, count);
            quadDfs(arr, row + length, col + length, length, count);
        }
        return count;
    }

    public static int[] capet(int brown, int yellow) {
        int sum = brown + yellow;
        int y = 0, x = 0;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                y = Math.min(i, yellow / i);
                x = Math.max(i, yellow / i);
                if ((y + 2) * (x + 2) == sum) {
                    break;
                }
            }
        }

        return new int[] {x + 2, y + 2};
    }
}
