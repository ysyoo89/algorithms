package com.personal.kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KakaoAnswer {
    public static int kakaoQuestion1(int n, int k) {
        StringTokenizer nums = init(n, k);
        int result = 0;

        while (nums.hasMoreTokens()) {
            if (isPrime(Long.parseLong(nums.nextToken()))) {
                result++;
            }
        }
        return result;
    }

    private static boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static StringTokenizer init(int n, int k) {
        //StringTokenizer tokenizer = new StringTokenizer(binary(n, k), "0");
        StringTokenizer tokenizer = new StringTokenizer(Integer.toString(n, k), "0");
//        List<String> nums = new ArrayList<>();
//        while (tokenizer.hasMoreTokens()) {
//            nums.add(tokenizer.nextToken());
//        }
        return tokenizer;
    }

    private static String binary(int n, int k) {
        StringBuilder builder = new StringBuilder();
        while(n > 0) {
            builder.append(n % k);
            n = n / k;
        }
        return builder.reverse().toString();
    }
}
