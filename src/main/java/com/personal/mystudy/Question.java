package com.personal.mystudy;

public class Question {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/12946
     * 하노이탑
     */
    public int[][] hanoi() {
        int n = 3;
        return Answer.hanoi(n);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/68645
     * 삼각달팽이
     */
    public int[] triangle() {
        int n = 3;
        return Answer.triangle(n);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/17687
     * n진수 게임
     */
    public String game() {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        return Answer.game(n, t, m, p);
    }
}
