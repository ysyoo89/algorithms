package com.personal.season1.answer;

import org.springframework.stereotype.Service;

public class Answer {
    // 동전 찾기와 같은 문제는 그리디로 풀며, 아래에서부터 적은 조건 찾으면서 조건을 해결하는 것이다.
    // 이 문제는 그리디로 푸는 것처럼 최소한으로 거스르는 것과 같이 문제를 푸는 것이다.
    //https://school.programmers.co.kr/learn/courses/30/lessons/148653
    public int magicStone(int storey) {
        int answer = 0;

        for (int i = 8; i >= 0; i--) {
            double pow = Math.pow(10, i);
            if (pow == 1) {
                answer += storey;
                break;
            }

            if (storey > pow) {
                int value = (int) (storey / pow);

                int temp1 = (int) Math.abs(pow * value - storey);
                int temp2 = (int) Math.abs(pow * (value + 1) - storey);
                if (temp1 < temp2) {
                    answer += value;
                    storey = temp1;
                } else if (temp2 < temp1) {
                    answer += value + 1;
                    storey = temp2;
                }

            }
        }

        return answer;
    }

    // 그리디 문제 방법 풀이1
    public int magicStoneEtc(int storey) {
        int answer = 0;
        while(storey > 0) {
            int value = storey % 10;
            storey = storey / 10;

            if (value > 5 ) {
                answer += 10 - value;
                storey++;
            } else if (value < 5) {
                answer += value;
            } else if (storey % 10 >= 5) {
                answer += 5;
                storey++;
            } else {
                answer += 5;
            }

        }
        return answer;
    }

    // dp 방식의 풀이
    // 실제 풀이는 저 안에서 같은 1의 개수를 패턴대로 찾아서 수학적 공식으로 만드는 것.
    public int canto(int n, long l, long r) {
        int answer = 0;
        StringBuilder[] bit = new StringBuilder[n + 1];
        for (int i = 0; i <= n; i++) {
            bit[i] = new StringBuilder();
        }
        bit[0].append("1");
        bit[1].append("11011");
        for (int i = 2; i <= n; i++) {
            bit[i].append(bit[i-1]);
            bit[i].append(bit[i-1]);
            for (double j = 0; j < Math.pow(5, i-1); j++) {
                bit[i].append("0");
            }
            bit[i].append(bit[i-1]);
            bit[i].append(bit[i-1]);
        }

        for (long i = l-1; i < r; i++) {
            if (bit[n].charAt(Math.toIntExact(i)) == '1') {
                answer++;
            }
        }
        return answer;
    }

    public int xor(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int[][] temp = data;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j= 0; j < data.length - 1 - i; j++) {
                if (temp[j][col - 1] > temp[j+1][col - 1]) {
                    int[] arr = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j +1] = arr;
                } else if (temp[j][col - 1] == temp[j+1][col - 1]) {
                    if (temp[j][0] < temp[j+1][0]) {
                        int[] arr = temp[j];
                        temp[j] = temp[j + 1];
                        temp[j +1] = arr;
                    }
                }
            }
        }

        for (int i = row_begin - 1; i < row_end; i++) {
            int mod = 0;
            for (int j= 0; j < temp[i].length; j++) {
                mod += temp[i][j] % (i + 1);
            }
            answer = answer ^ mod;
        }
        return answer;
    }

}
