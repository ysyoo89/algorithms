package com.personal.programmers.question;

import com.personal.programmers.answer.ProgrammersAnswerLevel2;

public class ProgrammersQuestionLevel2 {

    public String changeNumberLevel2() {
        int n = 10;
        return ProgrammersAnswerLevel2.numberChange(n);
    }

    public int[] lineSort() {
        int n = 3;
        long k = 5;
        return ProgrammersAnswerLevel2.lineSort(n, k);
    }

    /**
     * 문자열에 있는 숫자의 최대값과 최소값 구하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/12939
     * @return
     */
    public String minAndMax() {
        String s = "1 2 3 4";
        return ProgrammersAnswerLevel2.minAndMax(s);
    }

    /**
     * 혼자놀기 게임
     * https://school.programmers.co.kr/learn/courses/30/lessons/131130
     * @return
     */
    public int aloneGame() {
        int[] cards = {3,4,1,7,6,5,8,9};
        return ProgrammersAnswerLevel2.aloneGame(cards);
    }
}
