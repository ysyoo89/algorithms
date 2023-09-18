package com.personal.book;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public int romaNumber(String s) {
        Map<Character, Integer> map = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        if (!romaNumberValidation(s, map)) {
            return 0;
        }
        int sum = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; --i) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }

        return sum;
    }

    private boolean romaNumberValidation(String s, Map<Character, Integer> map) {
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == 'I') {
                if (s.charAt(i + 1) != 'V' && s.charAt(i) != 'X') {
                    return false;
                }
            } else if (s.charAt(i) == 'X') {
                if (s.charAt(i + 1) != 'L' && s.charAt(i + 1) != 'C') {
                    return false;
                }
            } else if (s.charAt(i) == 'C') {
                if (s.charAt(i + 1) != 'D' && s.charAt(i + 1) != 'M') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 문자열을 뱀 모양의 형태로 바꿨을 때 문자열이 어떻게 변화할 수 있는지를 보는 코드이다.
     * 문자열이 뱀 모양으로 변하게 했을 때 어떻게 변화가 진행될 때 어떤 패턴으로 변경할 수 있는지
     * 패턴을 찾은 뒤에 문제를 풀면 된다.
     */

    public String snakeString(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < s.length(); i+=4) {
            builder.append(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i += 2) {
            builder.append(s.charAt(i));
        }

        for (int i = 3; i < s.length(); i += 4) {
            builder.append(s.charAt(i));
        }

        return builder.toString();
    }

    public long jump(int n) {
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }

    public String a(String[] params) {
        String answer = Arrays.stream(params).map(s -> s.toUpperCase()).filter(s -> s.length() >= 5 && s.length() <= 10).findFirst().orElse("없음");
        return answer;
    }

    public String b(String[] leftArray, String[] rightArray) {
        String answer = "";
        HashSet<String> left = new HashSet<>();
        HashSet<String> temp = new HashSet<>();
        for (int i = 0; i < leftArray.length; i++) {
            left.add(leftArray[i]);
        }

        for (int i = 0; i < rightArray.length; i++) {
            if (left.contains(rightArray[i])) {
                temp.add(rightArray[i]);
            }
        }

        ArrayList<String> list = new ArrayList<>(temp);
        Collections.sort(list);
        answer = String.join(",", list);
        return answer;
    }

    public String[] c (String[] productInfo, String[] dailyProductSales) {
        String[] answer = new String[dailyProductSales.length];
        Map<String, String[]> map = new HashMap<>();
        for (int i = 0; i < productInfo.length; i++) {
            String[] temp = productInfo[i].split(",");
            map.put(temp[0], temp);
        }

        for (int i = 0; i < dailyProductSales.length; i++) {
            String[] temp = dailyProductSales[i].split(",");
            StringBuilder builder = new StringBuilder();
            builder.append(temp[0]);
            builder.append(",");
            builder.append(temp[1]);
            builder.append(",");
            builder.append(map.get(temp[1])[1]);
            builder.append(",");
            long cost = Long.parseLong(map.get(temp[1])[2]) * Long.parseLong(temp[2]);
            builder.append(String.valueOf(cost));
            answer[i] = builder.toString();
        }
        return answer;
    }

    public int[] d(int[] card) {
        int answer[] = new int[2];
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < card.length; i++) {
            map.put(card[i], map.getOrDefault(card[i], 0) + 1);
        }

        for (int val : map.keySet()) {
            if (map.get(val) == 1) {
                list.add(val);
            }
        }

        Collections.sort(list);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public String e(String pathVariableUrl) {
        Pattern pattern = Pattern.compile("^/payment/(\\d*)/(\\w*)$");
        Matcher matcher = pattern.matcher(pathVariableUrl);
        StringBuilder builder = new StringBuilder();
        if (matcher.find()) {
            builder.append("/payment/");
            builder.append(matcher.group(2));
            builder.append("?paymentId=");
            builder.append(matcher.group(1));
        } else {
            return "ERROR";
        }
        return builder.toString();
    }

}
