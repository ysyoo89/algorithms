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
        for (int i = 0; i < A.size(); i++) {
            // 사이클을 순회하면서 i가 최소 원소인지 확인한다.
            boolean isMin = true;
            int j = perm.get(i);
            while(j != i) {
                if (j < i) {
                    isMin = false;
                    break;
                }
                j = perm.get(j);
            }

            if (isMin) {
                cyclicPermutation(i, perm, A);
            }
        }
    }

    private void cyclicPermutation(int start, List<Integer> perm, List<Integer> A) {
        int i = start;
        int temp = A.get(start);
        do {
            int nextI = perm.get(i);
            int nextTemp = A.get(nextI);
            A.set(nextI, temp);
            i = nextI;
            temp = nextTemp;
        } while (i != start);
    }

    public List<Integer> plusOne(List<Integer> A) {
        List<Integer> answer = A;
        int n = answer.size() -1;
        answer.set(n, answer.get(n) + 1);
        for (int i = n; i > 0 && answer.get(i) == 10; --i) {
            answer.set(i, 0);
            answer.set(i - 1, answer.get(i - 1) + 1);
        }
        if (answer.get(0) == 10) {
            // 최상위 숫자에 올림수가 존재하므로, 결과 저장을 위해 한 자리가 더 필요하다.
            // 깔끔한 방법은 첫 번째 항목을 1로 업데이트하고 배열 끝에는 0을 추가해 주는 것이다.
            answer.set(0, 1);
            answer.add(0);
        }
        return answer;
    }

    public void example() {

    }

}
