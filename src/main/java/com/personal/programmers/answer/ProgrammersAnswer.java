package com.personal.programmers.answer;

import java.util.*;

public class ProgrammersAnswer {

    public static int cardDivide(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int gdcA = cardDivideMethod(arrayA);
        int gdcB = cardDivideMethod(arrayB);

        if (gdcA == gdcB) return answer;

        answer = cardDivideCheck(gdcA, arrayB, answer);
        answer = cardDivideCheck(gdcB, arrayA, answer);

        return answer;
    }
    private static int cardDivideCheck(int divide, int[] arrays, int answer) {
        for (int num : arrays) {
            if (num % divide == 0) {
                return Math.max(answer, 0);
            }
        }
        return Math.max(answer, divide);
    }

    private static int cardDivideMethod(int[] arrays) {
        int gdc = 1;

        for (int i = 2; i <= arrays[0]; i++) {
            if (isGcd(arrays, i)) {
                gdc = i;
            }
        }

        return gdc;
    }

    private static boolean isGcd(int[] array, int i) {
        for (int num : array) {
            if (num % i != 0) {
                return false;
            }
        }
        return true;
    }

    public static int divisionSum(int number, int limit, int power) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            result += divisionNumber(i, limit, power);
        }
        return result;
    }

    private static int divisionNumber(int number, int limit, int power) {
        int result = 0;
        if (number == 1) return 1;
        else {
            for (int i = 1; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    result++;
                    if (number / i != i) {
                        result++;
                    }
                }
            }
        }
        if (limit < result) {
            result = power;
        }
        return result;
    }

    public static int appleBox(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }

        return answer;
    }

    public static int[] gloryScore(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num=0; num<score.length;num++) {
            queue.add(score[num]);
            if(queue.size()<=k) {
                answer[num]=queue.peek();
            } else {
                queue.remove();
                answer[num]=queue.peek();
            }
        }

        return answer;
    }

    public static String foodFighter(int[] food) {
        String answer = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int cnt = food[i] / 2;
            for (int j = 0; j < cnt; j++) {
                builder.append(String.valueOf(i));
            }
        }
        String origin = builder.toString();
        answer = origin + "0" + builder.reverse().toString();

        return answer;
    }

    public static int hamburger(int[] ingredient) {
        Stack<Integer> burgerStack = new Stack<>();
        int answer = 0;
        for(int i = 0; i < ingredient.length; i++) {
            burgerStack.push(ingredient[i]);
            if(burgerStack.peek()==1&&burgerStack.size()>3) {
                if(burgerStack.get(burgerStack.size()-2)==3&&
                        burgerStack.get(burgerStack.size()-3)==2&&
                        burgerStack.get(burgerStack.size()-4)==1) {
                    answer++;
                    for(int j = 0; j < 4; j++) {
                        burgerStack.remove(burgerStack.size()-1);
                    }
                }
            }
        }
        return answer;
    }
}
