package com.personal.kakao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    public static int[] kakaoQuestion2(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate time = LocalDate.from(LocalDate.parse(today, formatter).atStartOfDay());
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] temp = term.split(" ");
            termMap.put(temp[0], Integer.parseInt(temp[1]));
        }

        int count = 1;
        for (String privacy: privacies) {
            String[] temp = privacy.split(" ");
            LocalDate privacyTime = LocalDate.from(LocalDate.parse(temp[0], formatter).atStartOfDay());
            LocalDate tempToday = privacyTime.plusMonths(termMap.get(temp[1]));
            if (time.isAfter(tempToday) || time.isEqual(tempToday)) {
                list.add(count);
            }
            count++;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
