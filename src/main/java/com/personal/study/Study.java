package com.personal.study;

public class Study {

    public int numberSum(int n, String number) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += number.charAt(i) - '0';
        }
        return answer;
    }

    public double average(int n, int[] numbers) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, numbers[i]);
            sum += numbers[i];
        }
        return sum * 100.0 / max / n;
    }

    public long[] particleSum(int n, int[] numbers, int[][] questions) {
        long[] answers = new long[questions.length];
        long[] sums = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + numbers[i - 1];
        }

        for (int i = 0; i < questions.length; i++) {
            answers[i] = sums[questions[i][1]] - sums[questions[i][0] - 1];
        }
        return answers;
    }
}
