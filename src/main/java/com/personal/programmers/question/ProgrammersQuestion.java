package com.personal.programmers.question;

import com.personal.programmers.answer.ProgrammersAnswer;

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
     * @return
     */
    public int appleBox() {
        int k = 3;
        int m = 4;
        int[] score = {1,2,3,1,2,3,1};
        return ProgrammersAnswer.appleBox(k,m,score);
    }
}
