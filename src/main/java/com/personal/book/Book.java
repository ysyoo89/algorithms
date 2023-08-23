package com.personal.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Book {

    public boolean palindromeNumber(int number) {
        if (number < 0) {
            return false;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(number);

        return builder.equals(builder.reverse()) ? true : false;
    }

    public List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        List<Integer> answer = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
        for (int i = num1.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {
                answer.set(i + j + 1, answer.get(i + j + 1) + num1.get(i) * num2.get(j));
                answer.set(i + j, answer.get(i + j) + answer.get(i + j + 1) / 10);
                answer.set(i + j + 1, answer.get(i + j + 1) % 10);
            }
        }

        // 0으로 시작되는 부분 삭제
        // 곱한 값의 최대 값 중 앞에 빈 부분을 삭제하기 위한 로직
        int first_not_zero = 0;
        while (first_not_zero < answer.size() && answer.get(first_not_zero) == 0) {
            ++first_not_zero;
        }
        answer = answer.subList(first_not_zero, answer.size());
        if (answer.isEmpty()) {
            return Arrays.asList(0);
        }
        answer.set(0, answer.get(0) * sign);
        return answer;
    }

    public double computeMaxProfit(List<Double> prices) {
        double base = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < prices.size(); i++) {
            max = Math.max(max, prices.get(i) - base);
            base = Math.min(base, prices.get(i));
        }
        return max;
    }

    public void applyPermutaion(List<Integer> perm, List<Integer> A) {
        for (int i = 0; i < perm.size(); i++) {

        }
    }
}
