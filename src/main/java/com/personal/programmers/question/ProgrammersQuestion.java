package com.personal.programmers.question;

import com.personal.programmers.answer.ProgrammersAnswer;

import java.text.ParseException;

public class ProgrammersQuestion {


    /**
     * A가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고 B가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
     * B가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, A가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
     * 즉, 한 곳에서만 나눠질 수 있는 수 중 가장 큰 수를 찾아라
     */
    public int cardDivide() {
        int[] arrayA = {10,20};
        int[] arrayB = {5,17};
        return ProgrammersAnswer.cardDivide(arrayA, arrayB);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/136798
     * 약수를 구한 뒤 약수의 크기가 한계치를 넘으면 power 값으로 처리하는 알고리즘
     */
    public int divisionSum() {
        int number = 5;
        int limit = 3;
        int power = 2;
        return ProgrammersAnswer.divisionSum(number, limit, power);
    }

    /**
     * 사과 1박스의 담을 수 있는 개수 m, 사과의 최대 상품 등급 k, 수확한 사과 score를 한 상자에 담았을 때
     * 가장 높은 가격을 받을 수 있는 알고리즘을 구하여라
     */
    public int appleBox() {
        int k = 3;
        int m = 4;
        int[] score = {1,2,3,1,2,3,1};
        return ProgrammersAnswer.appleBox(k,m,score);
    }

    /**
     * 매주 점수를 받는 프로그램에서 최고점을 k까지 저장하여 더 높은 점수를 받은 사람들의 점수들로 채우는 프로그램이 있다.
     * 이때 매주 저장되는 최하점의 점수가 어떤 점수인지 알 수 있는 알고리즘을 구하여라
     */
    public int[] gloryScore() {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        return ProgrammersAnswer.gloryScore(k,score);
    }

    /**
     * 푸드파이더들이 먹을 음식을 공평하게 나누어 두 명의 푸드파이터들이 음식을 먹게 한다.
     * 이때 가운데에는 물이 있어야하며 이 물은 '0'으로 지칭한다.
     * 한명은 왼쪽에서 오른쪽으로, 다른 한명은 오른쪽에서 왼쪽으로 먹으면서 이동하기에 똑같은 음식 배열이 필요하다.
     * 이때 두명의 푸드파이더가 같은 음식을 먹게 만드는 알고리즘을 만들어라.
     */
    public String foodFighter() {
        int[] food = {1,3,7,2};
        return ProgrammersAnswer.foodFighter(food);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/133502
     * 햄버거 만들기 문제
     */
    public int hamburger() {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        return ProgrammersAnswer.hamburger(ingredient);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/133499
     * 옹알이 문제 (한번에 발음이 가능한 단어 찾기)
     */
    public int babbling() {
        String[] babbling = {"aya", "yee", "u", "maa"};
        return ProgrammersAnswer.babbling(babbling);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/132267
     * 최대로 콜라병 바꿔 마시기 문제
     */
    public int cola() {
        int a = 2;
        int b = 1;
        int n = 20;
        return ProgrammersAnswer.cola(a, b, n);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/131705
     * 3명의 학생의 총 합이 0이 될 수 있는 값 구하기
     */
    public int threeMan() {
        int[] number = {-2, -1, 0, 1, 2};
        return ProgrammersAnswer.threeMan(number);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/1845
     * 최대 종류 포켓몬 개수
     */

    public int poketmon() {
        int[] nums = {3,2,1,3};
        return ProgrammersAnswer.pokemon(nums);
    }

    /**
     * 원하는 달의 요일을 구하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/12901
     */
    public String calendar() throws ParseException {
        int a = 5;
        int b = 24;
        return ProgrammersAnswer.calendar(a, b);
    }

    /**
     * 가운데 글자 가져오기
     * https://school.programmers.co.kr/learn/courses/30/lessons/12903
     */
    public String middleWord() {
        String s = "qwe";
        return ProgrammersAnswer.middleWord(s);
    }
}
