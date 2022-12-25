package com.personal.programmers.answer;

import java.util.ArrayList;

public class ProgrammersAnswerLevel2 {

    public static String numberChange(int n) {
        char[] numberChar = {'4', '1', '2'};
        StringBuffer buffer = new StringBuffer();
        int val = n;
        int division = 0;
        while(val != 0) {
            division = val % 3;
            val = val / 3;
            if (division == 0) {
                val--;
            }
            buffer.append(numberChar[division]);
        }
        return buffer.reverse().toString();
    }

    public static int[] lineSort(int n, long k) {
        int[] answer = new int[n];
        long temp = k - 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (temp == 0) {
                answer[i] = list.get(0);
                list.remove(0);
                continue;
            }
            long num = temp / factorial(n - i - 1);
            answer[i] = list.get((int)num);
            list.remove((int)num);
            temp = temp % factorial(n - i - 1);
        }

        return answer;
    }

    private static long factorial(int num) {
        long result = 1;
        for (long i = num; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public static String solve() {
        return "";
    }
}
