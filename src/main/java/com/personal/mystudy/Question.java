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

    public int test1() {
        String s = "aabbbccd";
        return Answer.test1(s);
    }

    public int test2() {
        String p = "82195";
        String s = "64723";
        return Answer.test2(p, s);
    }

    public int test3() {
        // int[][] atmos = {{80, 35}, {70, 38}, {100, 41}, {75, 30}, {160, 80}, {77, 29}, {181, 68}, {151, 76}};
        int[][] atmos = {{140, 90}, {177, 75}, {95, 45}, {71, 31}, {150, 30}, {80, 35}, {72, 33}, {166, 81}, {151, 75}};
        // int[][] atmos = {{30, 15}, {80, 35}};

        return Answer.test3(atmos);
    }

    public int test4() {
//        String[] ip_addrs = {"5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0"};
//        String[] langs = {"Java", "C++", "Python3", "C#", "Java", "C", "Python3", "Javascript"};
//        int[] scores = {294, 197, 373, 45, 294, 62, 373, 373};

//        String[] ip_addrs = {"7.124.10.0", "7.124.10.0", "0.0.0.0", "7.124.10.0", "0.0.0.0", "7.124.10.0"};
//        String[] langs = {"C++", "Java", "C#", "C#", "C", "Python3"};
//        int[] scores = {314, 225, 45, 0, 155, 400};

        String[] ip_addrs = {"5.5.5.5", "155.123.124.111", "10.16.125.0"};
        String[] langs = {"Java", "C++", "Python3"};
        int[] scores = {294, 197, 373};
        return Answer.test4(ip_addrs, langs, scores);
    }

    public int test5() {
        int n = 50;
        int[][] battery = {{10, 100000}, {4, 35000}, {1,15000}};
//        int n = 20;
//        int[][] battery = {{6, 30000}, {3, 18000}, {4,28000}, {1, 9500}};
        return Answer.test5(n, battery);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/43162
     * 네트워크
     */
    public int network() {
        int n = 3;
        int[][] computers = {{1}};
        return Answer.network(n, computers);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/12907
     * 거스름돈
     */
    public int money() {
        int n = 5;
        int[] money = {1, 2, 5};
        return Answer.money(n, money);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/49191
     * 순위
     */
    public int rank() {
        int n = 5;
        int[][] results = {{4,3}};
        return Answer.rank(n, results);
    }

    public String exam() {
        int N = 3;
        int K = 2;
        return Answer.exam(N, K);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/12929
     * 괄호 개수 찾기
     */
    public int bracketCount() {
        int n = 4;
        return Answer.bracketCount(n);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/64064
     * 불량 사용자
     */
    public int badUser() {
        String[] user_id = {};
        String[] banned_id = {};
        return Answer.badUser(user_id, banned_id);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/17678
     * 셔틀버스
     */
    public String bus() {
        int n = 1;
        int t = 2;
        int m = 3;
        String[] timetable = {"asd", "sad"};
        return Answer.bus(n, t, m , timetable);
    }
}
