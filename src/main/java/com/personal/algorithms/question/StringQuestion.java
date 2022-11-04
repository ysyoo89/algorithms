package com.personal.algorithms.question;

import com.personal.algorithms.answer.StringAnswer;
import org.springframework.stereotype.Service;

@Service
public class StringQuestion {

    /**
     * 문장에 단일 공백으로 구분된 단어 목록을 줬을 때
     * 한 문장에 나타나는 최대 단어 수를 반환하라.
     */
    public int answer() {
        String[] question = {"alice and bob love leetcode","i think so too","this is great thanks very much"};
        return StringAnswer.mostWordsFound(question);
    }

    /**
     * 보석과 돌을 나타내는 문자열을 줬을 때
     * 돌에 구성되어 있는 문자열 내에 보석은 몇개가 있는지 확인하라.
     * (대신 문자의 대소문자를 구분하여야 한다. a , A 는 다른 문자로 본다)
     */
    public int stoneAnswer() {
        String jewels = "aA";
        String stones = "aAAbBBCC";
        return StringAnswer.numJewelsInStones(jewels, stones);
    }
}
