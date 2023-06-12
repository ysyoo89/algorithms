package com.personal.kakao;

import com.personal.programmers.answer.ProgrammersAnswerLevel2;

public class KakaoQuestion {
    /**
     * 소수의 개수 찾기
     * https://school.programmers.co.kr/learn/courses/30/lessons/92335
     */
    public int kakaoQuestion1() {
        int n = 3;
        int k = 3;
        return KakaoAnswer.kakaoQuestion1(n, k);
    }

    /**
     * 개인정보 수집 유효기간
     * https://school.programmers.co.kr/learn/courses/30/lessons/150370
     * @return
     */
    public int[] kakaoQuestion2() {
        String today = "";
        String[] terms = {};
        String[] privacies = {};
        return KakaoAnswer.kakaoQuestion2(today, terms, privacies);
    }
}
