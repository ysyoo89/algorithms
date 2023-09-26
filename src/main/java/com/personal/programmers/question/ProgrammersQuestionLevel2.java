package com.personal.programmers.question;

import com.personal.programmers.answer.ProgrammersAnswerLevel2;

public class ProgrammersQuestionLevel2 {

    public String changeNumberLevel2() {
        int n = 10;
        return ProgrammersAnswerLevel2.numberChange(n);
    }

    public int[] lineSort() {
        int n = 3;
        long k = 5;
        return ProgrammersAnswerLevel2.lineSort(n, k);
    }

    /**
     * 문자열에 있는 숫자의 최대값과 최소값 구하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/12939
     * @return
     */
    public String minAndMax() {
        String s = "1 2 3 4";
        return ProgrammersAnswerLevel2.minAndMax(s);
    }

    /**
     * 혼자놀기 게임
     * https://school.programmers.co.kr/learn/courses/30/lessons/131130
     * @return
     */
    public int aloneGame() {
        int[] cards = {3,4,1,7,6,5,8,9};
        return ProgrammersAnswerLevel2.aloneGame(cards);
    }

    /**
     * 롤케이크 토핑 종류 동일하게 맞추기
     * https://school.programmers.co.kr/learn/courses/30/lessons/132265
     * @return
     */
    public int rollCake() {
        int[] topping = {1,2,1,3,1,4,1,2};
        return ProgrammersAnswerLevel2.rollCake(topping);
    }

    /**
     * 피로도
     * https://school.programmers.co.kr/learn/courses/30/lessons/87946
     */
    public int fatigue() {
        int k = 3;
        int[][] dungeons = new int[3][3];
        return ProgrammersAnswerLevel2.fatigue(k, dungeons);
    }
    
    /**
     * 전력망을 둘로 나누기
     * https://school.programmers.co.kr/learn/courses/30/lessons/86971
     */
    public int electronic() {
    	 int n = 3;
         int[][] wires = new int[3][3];
         return ProgrammersAnswerLevel2.electronic(n, wires);
    }
    
    /**
     * 시소 문제
     * https://school.programmers.co.kr/learn/courses/30/lessons/152996
     * @return
     */
    public long seesaw() {
    	int[] weights = {100, 120, 240, 100};
    	return ProgrammersAnswerLevel2.seesaw(weights);
    }
    
    public int discount() {
    	String[] want = {"banana", "apple", "rice", "pork", "pot"};
    	int[] number = {3, 2, 2, 2, 1};
    	String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
    	return ProgrammersAnswerLevel2.discount(want, number, discount);
    }
    
    /**
     * 동적 알고리즘
     * https://school.programmers.co.kr/learn/courses/30/lessons/42895
     */
    public int dynamic() {
    	int n = 5;
    	int number = 12;
    	return ProgrammersAnswerLevel2.dynamic(n, number);
    }
    
    /**
     * 정수 삼각형
     * https://school.programmers.co.kr/learn/courses/30/lessons/43105
     */
    public int triangle() {
    	int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
    	return ProgrammersAnswerLevel2.triangle(triangle);
    }
    
    /**
     * 정수 삼각형 참고용
     */
    public int triangle2() {
    	int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
    	return ProgrammersAnswerLevel2.triangle2(triangle);
    }
    
    /**
     * 등굣길
     * https://school.programmers.co.kr/learn/courses/30/lessons/42898
     */
    public int goSchool() {
    	int m =3;
    	int n = 4;
		int[][] puddles = {{2,2}};
    	return ProgrammersAnswerLevel2.goSchool(m, n, puddles);
    }
    
    /**
     * 사칙연산
     * https://school.programmers.co.kr/learn/courses/30/lessons/1843
     */
    public int operations() {
    	String arr[] = {"1", "-", "2"};
    	return ProgrammersAnswerLevel2.operations(arr);
    }
    
    /**
     * 귤 고르기
     * https://school.programmers.co.kr/learn/courses/30/lessons/138476
     */
    public int selec() {
    	int k = 6; 
    	int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
    	
    	return ProgrammersAnswerLevel2.selec(k, tangerine);
    }
    
    /**
     * 게임 맵 최단거리
     * https://school.programmers.co.kr/learn/courses/30/lessons/1844
     */
    public int sortRoad() {
    	int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    	return ProgrammersAnswerLevel2.sortRoad(maps);
    }
    
    /**
     * 크기가 작은 부분 문자열
     * https://school.programmers.co.kr/learn/courses/30/lessons/147355
     */
    public int minimumWord() {
    	String t = "3141592";
    	String p = "271";
    	return ProgrammersAnswerLevel2.minimumWord(t, p);
    }
    
    /**
     * 2진수의 다음 큰수
     * https://school.programmers.co.kr/learn/courses/30/lessons/12911
     */
    public int nextNumber() {
    	int n = 78;
    	return ProgrammersAnswerLevel2.nextNumber(n);
    }
    
    /**
     * 순차적으로 끝나는 과제
     * https://school.programmers.co.kr/learn/courses/30/lessons/176962
     */
    public String[] homework() {
    	String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}};
    	return ProgrammersAnswerLevel2.homework(plans);
    }
    
    /**
     * 뒷 큰수 구하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/154539
     */
    public int[] nextMaxNumber() {
    	int[] numbers = {1,4,3};
    	return ProgrammersAnswerLevel2.nextMaxNumber(numbers);
    }
    
    /**
     * 예약 방 개수 구하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/155651
     */
    public int bookSystem() {
    	String[][] book_time = {{"aaa"}};
    	return ProgrammersAnswerLevel2.bookSystem(book_time);
    }

    /**
     * 가장 큰 수
     * https://school.programmers.co.kr/learn/courses/30/lessons/42746
     */
    public String maxNumber() {
        int[] numbers = {6,10,2};
        return ProgrammersAnswerLevel2.maxNumber(numbers);
    }

    /**
     * H-Index 찾기
     * https://school.programmers.co.kr/learn/courses/30/lessons/42747
     */
    public int hIndex() {
        int[] citations = {3,0,6,1,5};
        return ProgrammersAnswerLevel2.hIndex(citations);
    }

    /**
     * 피보나치 수열
     * https://school.programmers.co.kr/learn/courses/30/lessons/12945
     */
    public int fibo() {
        int n = 0;
        return ProgrammersAnswerLevel2.fibo(n);
    }

    /**
     * 요격하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/181188
     */
    public int defense() {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        return ProgrammersAnswerLevel2.defense(targets);
    }

    /**
     * 원 정수 찾기
     * https://school.programmers.co.kr/learn/courses/30/lessons/181187
     */
    public long circle() {
        int r1 = 2;
        int r2 = 3;
        return ProgrammersAnswerLevel2.circle(r1, r2);
    }

    /**
     * 연속된 부분 수열의 합
     * https://school.programmers.co.kr/learn/courses/30/lessons/178870
     */
    public int[] numberSum() {
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        return ProgrammersAnswerLevel2.numberSum(sequence, k);
    }

    /**
     * 마인크래프트
     * https://school.programmers.co.kr/learn/courses/30/lessons/172927
     */
    public int minecraft() {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        return ProgrammersAnswerLevel2.minecraft(picks, minerals);
    }

    /**
     * 리코쳇 로봇
     * https://school.programmers.co.kr/learn/courses/30/lessons/169199
     */
    public int robot() {
        String[] board = {"",""};
        return ProgrammersAnswerLevel2.robot(board);
    }

    /**
     * 틱택토
     * https://school.programmers.co.kr/learn/courses/30/lessons/160585
     */
    public int tictactoe() {
        String[] board = {"OOO", "XX.", "X.."};
        return ProgrammersAnswerLevel2.tictactoe(board);
    }

    /**
     * 숫자 변환
     * https://school.programmers.co.kr/learn/courses/30/lessons/154538
     */
    public int changeNumber() {
        int x = 1;
        int y = 6;
        int n = 4;
        return ProgrammersAnswerLevel2.changeNumber(x, y, n);
    }

    /**
     * 미로 찾기
     * https://school.programmers.co.kr/learn/courses/30/lessons/159993
     */
    public int maze() {
        String[] map = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        return ProgrammersAnswerLevel2.maze(map);
    }

    /**
     * 무인도 식량
     * https://school.programmers.co.kr/learn/courses/30/lessons/154540
     */
    public int[] island() {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        return ProgrammersAnswerLevel2.island(maps);
    }

    /**
     * 사전찾기 dfs
     * https://school.programmers.co.kr/learn/courses/30/lessons/84512
     */
    public int word() {
        String word = "";
        return ProgrammersAnswerLevel2.word(word);
    }

    /**
     * 행렬의 곱
     * https://school.programmers.co.kr/learn/courses/30/lessons/12949
     */
    public int[][] power() {
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr2 = {{1, 4}, {2, 5}, {3, 6}};
        return ProgrammersAnswerLevel2.power(arr1, arr2);
    }
}
