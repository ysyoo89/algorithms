package com.personal.study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public int twoPointer(int n) {
        int answer = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while(end_index != n) {
            if (sum == n) {
                answer++;
                end_index++;
                sum += end_index;
            } else if (sum > n) {
                sum -= start_index;
                start_index++;
            } else {
                end_index++;
                sum += end_index;
            }
        }
        return answer;
    }

    public int armor(int n, int m, int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int start_index = 0;
        int end_index = n -1;

        while(start_index != end_index) {
            int sum = 0;
            sum = numbers[start_index] + numbers[end_index];
            if (sum == m) {
                answer++;
                end_index--;
                start_index--;
            } else if (sum > m) {
                end_index--;
            } else {
                start_index++;
            }
        }

        return answer;
    }

    public int dnaPassword(int n, char[] dna, int[] pattern) {
        int[] password = new int[pattern.length];
        int answer = 0;
        int checkPassword = (int) Arrays.stream(pattern).filter(m -> m == 0).count();
        // 초기 값 확인
        for (int i = 0; i < n; i++) {
            checkPassword = add(dna[i], password, pattern, checkPassword);
        }

        if (checkPassword == 4) answer++;

        // 슬라이딩 윈도우 처리 시작
        for (int i = n; i < dna.length; i++) {
            int j = i - n;
            checkPassword= add(dna[i], password, pattern, checkPassword);
            checkPassword = remove(dna[j], password, pattern, checkPassword);
            if (checkPassword == 4) answer++;
        }
        return answer;
    }

    private int remove(char c, int[] myChar, int[] pattern, int checkPassword) {
        switch (c) {
            case 'A' :
                if (myChar[0] == pattern[0]) checkPassword--;
                myChar[0]--;
                break;
            case 'C' :
                if (myChar[1] == pattern[1]) checkPassword--;
                myChar[1]--;
                break;
            case 'G' :
                if (myChar[2] == pattern[2]) checkPassword--;
                myChar[2]--;
                break;
            case 'T' :
                if (myChar[3] == pattern[3]) checkPassword--;
                myChar[3]--;
                break;
        }
        return checkPassword;
    }

    private int add(char c, int[] myChar, int[] pattern, int checkPassword) {
        switch (c) {
            case 'A' :
                myChar[0]++;
                if (myChar[0] == pattern[0]) checkPassword++;
                break;
            case 'C' :
                myChar[1]++;
                if (myChar[1] == pattern[1]) checkPassword++;
                break;
            case 'G' :
                myChar[2]++;
                if (myChar[2] == pattern[2]) checkPassword++;
                break;
            case 'T' :
                myChar[3]++;
                if (myChar[3] == pattern[3]) checkPassword++;
                break;
        }
        return checkPassword;
    }

    public String stack(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number >= num) {
                while (number >= num) {
                    stack.push(num++);
                    builder.append("+");
                }
                stack.pop();
                builder.append("-");
            } else {
                int n = stack.pop();
                if (n > number) {
                    return "NO";
                } else {
                    builder.append("-");
                }
            }
        }
        return builder.toString();
    }

    public int card(int cards) {
        Queue<Integer> que = new LinkedList<>();
        for (int i= 1; i <= cards; i++) {
            que.add(i);
        }

        while(que.size() > 1) {
            que.poll();
            que.add(que.poll());
        }
        return que.poll();
    }
}
