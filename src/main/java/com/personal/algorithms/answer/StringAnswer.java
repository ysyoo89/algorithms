package com.personal.algorithms.answer;

public class StringAnswer {

    public static int mostWordsFound(String[] sentences) {
        int result = 0;
        for (String words : sentences) {
            result = Math.max(result, words.split(" ").length);
        }
        return result;
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int result = 0;

        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) != -1) {
                result++;
            }
        }

        return result;
    }

    public static String interpret(String command) {
        String result = command;
        result = result.replace("()", "o");
        result = result.replace("(al)", "al");
        return result;
    }
}
