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

    /**
     * 성격 검사
     * https://school.programmers.co.kr/learn/courses/30/lessons/118666
     */
    public String kakaoQuestion3() {
        String[] survey = {};
        int[] choices = {};
        return KakaoAnswer.kakaoQuestion3(survey, choices);
    }

    /**
     * 신고 결과 받기
     * https://school.programmers.co.kr/learn/courses/30/lessons/92334
     */
    public int[] kakaoQuestion4() {
        String[] id_list = {};
        String[] report = {};
        int k = 2;
        return KakaoAnswer.kakaoQuestion4(id_list, report, k);
    }

    /**
     * 숫자 문자열과 영어
     * https://school.programmers.co.kr/learn/courses/30/lessons/81301
     */
    public int kakaoQuestion5() {
        String s = "";
        return KakaoAnswer.kakaoQuestion5(s);
    }
}
