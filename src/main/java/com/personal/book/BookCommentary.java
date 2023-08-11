package com.personal.book;

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
}
