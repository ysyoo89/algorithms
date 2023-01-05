package com.personal.programmers.answer;

import java.util.*;

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

    /**
     * 사람찾기
     * @param office
     * @param k
     * @return
     */
    public static int solve(int[][] office, int k) {
        int result = -1;
        int count = 0;

        for (int y = 0; y < office.length; y++) {
            if (y + k > office.length) {
                break;
            }
            for (int x = 0; x < office.length; x++) {
                count = 0;
                if (x + k > office.length) {
                    break;
                }
                for (int i = y; i < y + k; i++) {
                    for (int j = x; j < x + k; j++) {
                        count += office[i][j];
                        result = Math.max(result, count);
                    }
                }
            }
        }

        return result;
    }

    /**
     * 피보나치수열
     */
    public static int solution(int n) {
        int x = 1, y = 1;
        for (int i = 2; i <= n; i++) {
            int temp = x;
            x = x + y;
            y = temp;
        }
        return x;
    }

    /**
     * 3의 배수 구하기
     * @param n
     * @return
     */
    public static long power(long n) {
        return powerDfs(n);
    }

    private static long powerDfs(long n) {
        long result = 0;
        for(long i = 0; i <= n; i++) {

        }
        return 0;
    }


    public static String minAndMax(String s) {
        String[] temp = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.length; i++) {
            int num = Integer.valueOf(temp[i]);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(min));
        builder.append(" ");
        builder.append(String.valueOf(max));
        return builder.toString();
    }

    public static int aloneGame(int[] cards) {
        int card = 1;
        List<Integer> numbers = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < cards.length; ) {
            if (cards[i] != 0) {
                int count = 0;
                card = i + 1;
                while(card != 0) {
                    int index = card - 1;
                    if (cards[index] != 0) {
                        card = cards[index];
                        cards[index] = 0;
                        count++;
                    } else {
                        card = cards[index];
                    }
                }
                numbers.add(count);
            } else {
                i++;
            }
        }
        if (numbers.size() > 1) {
            Collections.sort(numbers, Collections.reverseOrder());
            result = numbers.get(0) * numbers.get(1);
        }

        return result;
    }

    public static int rollCake(int[] topping) {
        int answer = 0;
        int[] left = new int[10001], right = new int[10001];
        int ls = 0, rs = 0;
        for(var i : topping) right[i]++;
        for(var i : right) rs += i > 0 ? 1 : 0;
        for(var i : topping) {
            right[i]--;
            if (right[i] == 0) rs--;
            if (left[i] == 0) ls++;
            left[i]++;
            if (rs == ls) answer++;
        }
        return answer;
    }

    public static int fatigue(int k, int[][] dungeons) {
        return dfs(k, dungeons);
    }

    private static int dfs(int k, int[][] dungeons) {
        int cnt = 0;
        for(int[] d: dungeons) {
            int a = d[0];
            int b = d[1];
            if (a <= k) {
                d[0] = 9999;
                cnt = Math.max(1 + dfs(k - b, dungeons), cnt);
                d[0] = a;
            }
        }
        return cnt;
    }
}
