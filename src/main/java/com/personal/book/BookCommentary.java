package com.personal.book;

import java.util.Collections;
import java.util.List;

public class BookCommentary {
    public boolean palindromeNumber(int number) {
        if (number < 0) {
            return false;
        }

        int numDigits = (int)(Math.floor(Math.log10(number))) + 1; // 최대 자리수 구하기
        int msdMask = (int)Math.pow(10, numDigits - 1); // 최대 자리수
        for (int i = 0; i < numDigits / 2; i++) {
            if (number / msdMask != number % 10) {
                return false;
            }
            number %= msdMask; // number의 최상위 숫자를 삭제한다.
            number /= 10; // number의 최하위 숫자를 삭제한다.
            msdMask /= 100;
        }
        return true;

    }

    public void dutchFlagPartition(int pivotIndex, List<Color> A) {
        Color pivot = A.get(pivotIndex);
        /**
         * 분류할 때마다 다음 불변식을 만족해야 한다.
         * 피벗보다 작은 원소 그룹 : A.subList(0, smaller)
         * 피벗과 같은 원소 그룹: A.subList(smaller, equal)
         * 미분류 원소 그룹: A.subList(equal, larger)
         * 피벗보다 큰 원소 그룹: A.subList(larger, A.size())
         */
        int smaller = 0, equal = 0, larger = A.size();
        // 분류되지 않은 원소가 있는 동안 계속 순회한다.
        while(equal < larger) {
            //A.get(equal)는 분류되지 않은 원소를 가리킨다.
            if (A.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(A, smaller++, equal++);
            } else if (A.get(equal).ordinal() == pivot.ordinal()) {
                ++equal;
            } else { // A.get(equal) > pivot
                Collections.swap(A, equal, --larger);
            }
        }

    }
}
