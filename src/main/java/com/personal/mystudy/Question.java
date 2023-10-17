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

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/68936
     * 쿼드압축
     */
    public int[] quad() {
        int[][] arr = {{123}};
        return Answer.quad(arr);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/42842
     * 카펫
     */
    public int[] capet() {
        int brown = 50;
        int yellow = 22;
        return Answer.capet(brown, yellow);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/12941
     * 최소값 만들기
     */
    public int minimumNumber() {
        int[] A = {1};
        int[] B = {2};
        return Answer.minimumNumber(A, B);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/12953
     * 최소공배수
     */
    public int lcm() {
        int[] arr = {1};
        return Answer.lcm(arr);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/86971
     * 전력망 나누기
     */
    public int electronic() {
        int n = 4;
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        return Answer.electronic(n, wires);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/67257
     * 수식 최대화
     */
    public long maxRole() {
        String expression = "";
        return Answer.maxRole(expression);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/42888
     * 오픈채팅방
     */
    public String[] openChat() {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        return Answer.openChat(record);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/43163
     * 단어 변환
     */
    public int wordChange() {
        String begin= "";
        String target = "";
        String[] words = {};
        return Answer.wordChange(begin, target, words);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/42628
     * 이중우선큐
     */
    public int[] arrQueue() {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        return Answer.arrQueue(operations);
    }
}
