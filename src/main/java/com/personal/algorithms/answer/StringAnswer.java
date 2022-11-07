package com.personal.algorithms.answer;

import java.util.ArrayList;
import java.util.List;

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

    public static List<String> cellsInRages(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder curAns = new StringBuilder();
        for(int i = s.charAt(0); i<=s.charAt(3); i++)
        {
            for(int f = s.charAt(1)-'0'; f<=s.charAt(4)-'0'; f++)
            {
                curAns.append((char)i);
                curAns.append(f);
                ans.add(curAns.toString());
                curAns.delete(0,2);
            }
        }
        return ans;
    }
}
