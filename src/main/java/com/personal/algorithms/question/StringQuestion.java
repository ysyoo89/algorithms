package com.personal.algorithms.question;

import com.personal.algorithms.answer.StringAnswer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * G = G, () = o, (al) = al 로 변환하는 문자열을 리턴하는 걸 만들어라.
     */
    public String interpretAnswer() {
        String interpret = "G()()(al)";
        return StringAnswer.interpret(interpret);
    }

    /**
     * 엑셀시트와 같은 모양의 시작 행과 마지막 행의 정보를 받았을 때
     * 그 사이에 존재하는 시트의 정보를 모두 담는 List를 만들어라.
     */
    public List<String> cellsInRages() {
        String s = "A1:B4";
        return StringAnswer.cellsInRages(s);

    }

    /**
     * 주어진 키(string)를 통해 메세지(string) 의 암호를 해석하는 알고리즘을 구하여라
     * 키에 맞는 문자열을 아래 문자 순서대로 변경하라
     * 'a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z'
     */
    public String decodeMessage() {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        return StringAnswer.decodeMessage(key, message);
    }

    /**
     * 주어진 메세지 값에 'L', 'R' 두 개의 문자의 개수가 동일한 문자열의 개수를 찾아라
     * "LRLRLLRR" : 3
     * "LLRLRRLLRR" : 2
     */
    public int balancedStringSplit() {
        String s = "LRLLRLRR";
        return StringAnswer.balancedStringSplit(s);
    }

    /**
     * 공백에 임의의 번호를 추가한 문자열을 번호 순서대로 재 정렬하여 노출하라
     * "is2 This1 sentence4 a3" -> "This is a sentence"
     */
    public String sortSentence() {
        String s = "is2 This1 sentence4 a3";
        return StringAnswer.sortSentence(s);
    }

    /**
     * 리스트에 type, color, name이 담겨있는 리스트에서
     * 해당 값과 같은 목록을 가지고 있는 리스트의 개수를 리턴하라.
     * [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver" : 1
     */
    public int countMatches() {
        List<String> itemDetail1 = new ArrayList<>(Arrays.asList("phone","blue","pixel"));
        List<String> itemDetail2 = new ArrayList<>(Arrays.asList("computer","silver","lenovo"));
        List<String> itemDetail3 = new ArrayList<>(Arrays.asList("phone","gold","iphone"));
        List<List<String>> items = new ArrayList<>(Arrays.asList(itemDetail1, itemDetail2, itemDetail3));
        String ruleKey = "color";
        String ruleValue = "silver";
        return StringAnswer.countMatches(items, ruleKey, ruleValue);
    }

    /**
     * 판그램은 모든 알파벳이 전부 하나씩은 존재하는 단어를 말한다.
     * 주어진 문자열이 판그램에 해당하는지 확인하는 알고리즘을 구현해라.
     */
    public boolean checkIfPangram() {
        String s = "abcdefghijklmnopqrstuvwxyz";
        return StringAnswer.checkIfPangram(s);
    }

    /**
     * 주어진 두 개의 문자배열내에 문자를 합쳤을 때 두 문자열이 같으면 true, 다르다면 false를 리턴하는 알고리즘을 구현하라
     */
    public boolean arrayStringsAreEqual() {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        return StringAnswer.arrayStringsAreEqual(word1, word2);
    }

    /**
     * 문자열을 모스부호로 변형했을 때 모스 부호의 모습이 동일한 모습을 제외한 개수를 구하여라
     */
    public int uniqueMorseRepresentations() {
        String[] words = {"gin","zen","gig","msg"};
        return StringAnswer.uniqueMorseRepresentations(words);
    }

    /**
     * 주어진 수식내에 ()의 최대 뎁스의 카운트를 구하여라
     */
    public int  maxDepth() {
        String s = "(1+(2*3)+((8)/4))+1";
        return StringAnswer.maxDepth(s);
    }
}
