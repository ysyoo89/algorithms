package com.personal.algorithms.question;

import com.personal.algorithms.answer.StringAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StringQuestion {

    /**
     * String 문제
     * 문장에 단일 공백으로 구분된 단어 목록을 줬을 때
     * 한 문장에 나타나는 최대 단어 수를 반환하라.
     */
    public int answer() {
        String[] question = {"alice and bob love leetcode","i think so too","this is great thanks very much"};
        return StringAnswer.mostWordsFound(question);
    }

}
