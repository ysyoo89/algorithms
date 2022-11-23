package com.personal.programmers.answer;

import java.util.Arrays;

public class ProgrammersAnswer {

    public static int cardDivide(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int gdcA = cardDivideMethod(arrayA);
        int gdcB = cardDivideMethod(arrayB);

        if (gdcA == gdcB) return answer;

        answer = cardDivideCheck(gdcA, arrayB, answer);
        answer = cardDivideCheck(gdcB, arrayA, answer);

        return answer;
    }
    private static int cardDivideCheck(int divide, int[] arrays, int answer) {
        for (int num : arrays) {
            if (num % divide == 0) {
                return Math.max(answer, 0);
            }
        }
        return Math.max(answer, divide);
    }

    private static int cardDivideMethod(int[] arrays) {
        int gdc = 1;

        for (int i = 2; i <= arrays[0]; i++) {
            if (isGcd(arrays, i)) {
                gdc = i;
            }
        }

        return gdc;
    }

    private static boolean isGcd(int[] array, int i) {
        for (int num : array) {
            if (num % i != 0) {
                return false;
            }
        }
        return true;
    }

    public static int divisionSum(int number, int limit, int power) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            result += divisionNumber(i, limit, power);
        }
        return result;
    }

    private static int divisionNumber(int number, int limit, int power) {
        int result = 0;
        if (number == 1) return 1;
        else {
            for (int i = 1; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    result++;
                    if (number / i != i) {
                        result++;
                    }
                }
            }
        }
        if (limit < result) {
            result = power;
        }
        return result;
    }
}
