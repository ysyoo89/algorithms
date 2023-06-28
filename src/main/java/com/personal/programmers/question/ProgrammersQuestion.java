package com.personal.programmers.question;

import com.personal.programmers.answer.ProgrammersAnswer;
import com.personal.programmers.answer.ProgrammersAnswerLevel2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class ProgrammersQuestion {


    /**
     * A가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고 B가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
     * B가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, A가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
     * 즉, 한 곳에서만 나눠질 수 있는 수 중 가장 큰 수를 찾아라
     */
    public int cardDivide() {
        int[] arrayA = {10,20};
        int[] arrayB = {5,17};
        return ProgrammersAnswer.cardDivide(arrayA, arrayB);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/136798
     * 약수를 구한 뒤 약수의 크기가 한계치를 넘으면 power 값으로 처리하는 알고리즘
     */
    public int divisionSum() {
        int number = 5;
        int limit = 3;
        int power = 2;
        return ProgrammersAnswer.divisionSum(number, limit, power);
    }

    /**
     * 사과 1박스의 담을 수 있는 개수 m, 사과의 최대 상품 등급 k, 수확한 사과 score를 한 상자에 담았을 때
     * 가장 높은 가격을 받을 수 있는 알고리즘을 구하여라
     */
    public int appleBox() {
        int k = 3;
        int m = 4;
        int[] score = {1,2,3,1,2,3,1};
        return ProgrammersAnswer.appleBox(k,m,score);
    }

    /**
     * 매주 점수를 받는 프로그램에서 최고점을 k까지 저장하여 더 높은 점수를 받은 사람들의 점수들로 채우는 프로그램이 있다.
     * 이때 매주 저장되는 최하점의 점수가 어떤 점수인지 알 수 있는 알고리즘을 구하여라
     */
    public int[] gloryScore() {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        return ProgrammersAnswer.gloryScore(k,score);
    }

    /**
     * 푸드파이더들이 먹을 음식을 공평하게 나누어 두 명의 푸드파이터들이 음식을 먹게 한다.
     * 이때 가운데에는 물이 있어야하며 이 물은 '0'으로 지칭한다.
     * 한명은 왼쪽에서 오른쪽으로, 다른 한명은 오른쪽에서 왼쪽으로 먹으면서 이동하기에 똑같은 음식 배열이 필요하다.
     * 이때 두명의 푸드파이더가 같은 음식을 먹게 만드는 알고리즘을 만들어라.
     */
    public String foodFighter() {
        int[] food = {1,3,7,2};
        return ProgrammersAnswer.foodFighter(food);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/133502
     * 햄버거 만들기 문제
     */
    public int hamburger() {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        return ProgrammersAnswer.hamburger(ingredient);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/133499
     * 옹알이 문제 (한번에 발음이 가능한 단어 찾기)
     */
    public int babbling() {
        String[] babbling = {"aya", "yee", "u", "maa"};
        return ProgrammersAnswer.babbling(babbling);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/132267
     * 최대로 콜라병 바꿔 마시기 문제
     */
    public int cola() {
        int a = 2;
        int b = 1;
        int n = 20;
        return ProgrammersAnswer.cola(a, b, n);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/131705
     * 3명의 학생의 총 합이 0이 될 수 있는 값 구하기
     */
    public int threeMan() {
        int[] number = {-2, -1, 0, 1, 2};
        return ProgrammersAnswer.threeMan(number);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/1845
     * 최대 종류 포켓몬 개수
     */

    public int poketmon() {
        int[] nums = {3,2,1,3};
        return ProgrammersAnswer.pokemon(nums);
    }

    /**
     * 원하는 달의 요일을 구하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/12901
     */
    public String calendar() throws ParseException {
        int a = 5;
        int b = 24;
        return ProgrammersAnswer.calendar(a, b);
    }

    /**
     * 가운데 글자 가져오기
     * https://school.programmers.co.kr/learn/courses/30/lessons/12903
     */
    public String middleWord() {
        String s = "qwe";
        return ProgrammersAnswer.middleWord(s);
    }

    /**
     * 연속된 같은 숫자는 빼기
     * https://school.programmers.co.kr/learn/courses/30/lessons/12906
     */
    public int[] notDuplicationNumber() {
        int[] arr = {1,1,3,3,0,1,1};
        return ProgrammersAnswer.notDuplicationNumber(arr);
    }

    /**
     * 나누어 떨어지는 숫자 배열
     * https://school.programmers.co.kr/learn/courses/30/lessons/12910
     */
    public int[] divisionArray() {
        int[] arr = {};
        int divisor = 5;
        return ProgrammersAnswer.divisionArray(arr, divisor);
    }

    /**
     * 두 정수 사이의 모든 값을 더하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/12912
     */
    public long sumInteger(){
        int a = 3;
        int b = 5;
        return ProgrammersAnswer.sumInteger(a, b);
    }

    /**
     *  문자열 마음대로 정렬하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/12915
     */
    public String[] stringSort() {
        String[] strings = {"", ""};
        int n = 1;
        return ProgrammersAnswer.stringSort(strings, n);
    }

    /**
     * 두개의 문자열 개수 비교하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/12916
     */
    public boolean stringCount() {
        String s = "pPyY";
        return ProgrammersAnswer.stringCount(s);
    }

    /**
     * 최소직사각형 - 완전탐색
     * https://school.programmers.co.kr/learn/courses/30/lessons/86491
     */
    public int minimumRectangle() {
        int[][] sizes = new int[10][10];
        return ProgrammersAnswer.minimumRectangle(sizes);
    }

    /**
     * 모의고사
     * https://school.programmers.co.kr/learn/courses/30/lessons/42840
     */
    public int[] mockTest() {
        int[] answers = {1,2,3,4,5};
        return ProgrammersAnswer.mockTest(answers);
    }

    /**
     * 피보나치수열을 재귀함수로 구현하기
     * @return
     */
    public int fibonacci() {
        int n = 5;
        return ProgrammersAnswer.fibonacci(n);
    }
    /**
     * 팩토리얼 재귀함수로 구하기
     * https://www.acmicpc.net/problem/10872
     */
    public int factorial() {
        int n = 5;
        return ProgrammersAnswer.factorial(n);
    }
    
    public int isPalindrome() {
    	String s = "ABBA";
    	int count = 0;
    	return ProgrammersAnswer.isPalindrome(s, count);
    }
    
    /**
     * 별 찍기
     * https://www.acmicpc.net/problem/2447
     */
    public void star() {
    	int n = 9;
    	ProgrammersAnswer.star(n);
    }
    
    /**
     * 하노이탑 재귀
     * https://www.acmicpc.net/problem/11729
     */
    public void hanoiTower() {
    	int n = 3;
    	ProgrammersAnswer.hanoiTower(n);
    }

    /**
     * 자판 문제
     * https://school.programmers.co.kr/learn/courses/30/lessons/160586
     */
    public int[] keymap() {
        String[] keymap = {};
        String[] targets = {};
        return ProgrammersAnswer.keymap(keymap, targets);
    }

    /**
     * 덧칠하기 문제
     * https://school.programmers.co.kr/learn/courses/30/lessons/161989
     * @return
     */
    public int paint() {
        int n = 8;
        int m = 4;
        int[] section = {2, 4, 6};
        return ProgrammersAnswer.paint(n, m, section);
    }

    /**
     * 달리기 경주
     * https://school.programmers.co.kr/learn/courses/30/lessons/178871
     * @return
     */
    public String[] race() {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        return ProgrammersAnswer.race(players, callings);
    }

    /**
     * K번째 수 찾기
     * https://school.programmers.co.kr/learn/courses/30/lessons/42748
     */
    public int[] findNumber() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        return ProgrammersAnswer.findNumber(array, commands);
    }

    /**
     * 문자열 다루기
     * https://school.programmers.co.kr/learn/courses/30/lessons/12918
     */
    public boolean checkStr() {
        String s = "a123";
        return ProgrammersAnswer.checkStr(s);
    }

    public String stringChange() {
        String s = "try hello world";
        return ProgrammersAnswer.stringChange(s);
    }

    /**
     * 추억 점수 구하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/176963
     */
    public int[] memory() {
        String[] name = {};
        int[] yearning = {};
        String[][] photo = {{}};
        return ProgrammersAnswer.memory(name, yearning, photo);
    }

    /**
     * 자동 로봇 움직이기
     * https://school.programmers.co.kr/learn/courses/30/lessons/172928
     */
    public int[] robot() {
        String[] park = {"OXXO", "XSXO", "XXXX"};
        String[] routes = {"E 1", "S 1"};
        return ProgrammersAnswer.robot(park, routes);
    }

    /**
     * 바탕화면 정리
     * https://school.programmers.co.kr/learn/courses/30/lessons/161990
     */
    public int[] wallpaper() {
        String[] wallpaper = {};
        return ProgrammersAnswer.wallpaper(wallpaper);
    }

    /**
     * 카드 단어 선택하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/159994
     * @return
     */
    public String chooseWords() {
        String[] cards1 = {};
        String[] cards2 = {};
        String[] goal = {};
        return ProgrammersAnswer.chooseWords(cards1, cards2, goal);
    }

    /**
     * 둘만의 암호
     * https://school.programmers.co.kr/learn/courses/30/lessons/155652
     * @return
     */
    public String decoder() {
        String s = "ybcde";
        String skip = "az";
        int index = 1;
        return ProgrammersAnswer.decoder(s, skip, index);
    }

    /**
     * 가까운 문자 찾기
     * https://school.programmers.co.kr/learn/courses/30/lessons/142086
     */
    public int[] findWord() {
        String s = "";
        return ProgrammersAnswer.findWord(s);
    }

    /**
     * 문자열 나누기
     * https://school.programmers.co.kr/learn/courses/30/lessons/140108
     */
    public int straightWords() {
        String s = "";
        return ProgrammersAnswer.straightWords(s);
    }

    /**
     * 숫자 짝궁
     * https://school.programmers.co.kr/learn/courses/30/lessons/131128
     */
    public String numberPartner() {
        String X = "";
        String Y = "";
        return ProgrammersAnswer.numberPartner(X, Y);
    }

    /**
     * 1이 남은 작은 수 찾기
     * https://school.programmers.co.kr/learn/courses/30/lessons/87389
     */
    public int smallNumber() {
        int n = 11;
        return ProgrammersAnswer.smallNumber(n);
    }

    /**
     * 없는 숫자 더하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/86051
     */
    public int plusNumber() {
        int[] numbers = {};
        return ProgrammersAnswer.plusNumber(numbers);
    }

    /**
     * 놀이기구 금액
     * https://school.programmers.co.kr/learn/courses/30/lessons/82612
     */
    public long rides() {
        int price = 3;
        int money = 20;
        int count = 4;
        return ProgrammersAnswer.rides(price, money, count);
    }
}
