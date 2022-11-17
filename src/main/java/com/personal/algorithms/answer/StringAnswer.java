package com.personal.algorithms.answer;

import java.util.ArrayList;
import java.util.HashSet;
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

    public static String decodeMessage(String key, String message) {
        List<Character> map = new ArrayList<>();
        char[] dft = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 0; i < key.length(); i++) {
            if (!map.contains(key.charAt(i)) && key.charAt(i) != ' ') {
                map.add(key.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                result.append(' ');
            } else {
                result.append(dft[map.indexOf(message.charAt(i))]);
            }
        }
        return result.toString();
    }

    public static int balancedStringSplit(String s) {
        int result = 0;
        int strCount= 0;
        for (int i = 0; i< s.length(); i++) {
            int temp = s.charAt(i);
            if (temp == 'L') {
                strCount++;
            } else {
                strCount--;
            }
            if (strCount == 0) {
                result++;
            }
        }
        return result;
    }
}
