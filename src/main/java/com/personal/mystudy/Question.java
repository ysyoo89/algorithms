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
}
