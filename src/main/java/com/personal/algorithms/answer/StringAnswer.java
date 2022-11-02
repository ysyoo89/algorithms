package com.personal.algorithms.answer;

public class StringAnswer {

    public static int mostWordsFound(String[] sentences) {
        int result = 0;
        for (String words : sentences) {
            result = Math.max(result, words.split(" ").length);
        }
        return result;
    }
}
