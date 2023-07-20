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
}
