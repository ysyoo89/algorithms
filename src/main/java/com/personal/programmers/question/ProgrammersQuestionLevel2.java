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

    /**
     * 롤케이크 토핑 종류 동일하게 맞추기
     * https://school.programmers.co.kr/learn/courses/30/lessons/132265
     * @return
     */
    public int rollCake() {
        int[] topping = {1,2,1,3,1,4,1,2};
        return ProgrammersAnswerLevel2.rollCake(topping);
    }

    /**
     * 피로도
     * https://school.programmers.co.kr/learn/courses/30/lessons/87946
     */
    public int fatigue() {
        int k = 3;
        int[][] dungeons = new int[3][3];
        return ProgrammersAnswerLevel2.fatigue(k, dungeons);
    }
    
    /**
     * 전력망을 둘로 나누기
     * https://school.programmers.co.kr/learn/courses/30/lessons/86971
     */
    public int electronic() {
    	 int n = 3;
         int[][] wires = new int[3][3];
         return ProgrammersAnswerLevel2.electronic(n, wires);
    }
    
    /**
     * 시소 문제
     * https://school.programmers.co.kr/learn/courses/30/lessons/152996
     * @return
     */
    public long seesaw() {
    	int[] weights = {100, 120, 240, 100};
    	return ProgrammersAnswerLevel2.seesaw(weights);
    }
}
