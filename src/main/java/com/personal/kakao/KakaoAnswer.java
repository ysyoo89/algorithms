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

    public static String kakaoQuestion3(String[] survey, int[] choices) {
        int[] point = {0, 3, 2, 1, 0, 1, 2, 3};
        Map<Character, Integer> totalMbti = new HashMap<>();
        totalMbti.put('R', 0);
        totalMbti.put('T', 0);
        totalMbti.put('C', 0);
        totalMbti.put('F', 0);
        totalMbti.put('J', 0);
        totalMbti.put('M', 0);
        totalMbti.put('A', 0);
        totalMbti.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {
                totalMbti.put(survey[i].charAt(0), totalMbti.get(survey[i].charAt(0)) + point[choices[i]]);
            } else if (choices[i] > 4) {
                totalMbti.put(survey[i].charAt(1), totalMbti.get(survey[i].charAt(1)) + point[choices[i]]);
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(totalMbti.get('R') >= totalMbti.get('T') ? 'R' : 'T');
        builder.append(totalMbti.get('C') >= totalMbti.get('F') ? 'C' : 'F');
        builder.append(totalMbti.get('J') >= totalMbti.get('M') ? 'J' : 'M');
        builder.append(totalMbti.get('A') >= totalMbti.get('N') ? 'A' : 'N');

        return builder.toString();
    }

    public static int[] kakaoQuestion4(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, HashSet<String>> reportHistory = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            reportCount.put(id_list[i], i);
        }

        for (String reportId : report) {
            String[] temp = reportId.split(" ");
            HashSet<String> set = reportHistory.getOrDefault(temp[1], new HashSet<>());
            set.add(temp[0]);
            reportHistory.put(temp[1], set);
        }

        for (Map.Entry<String, HashSet<String>> entry : reportHistory.entrySet()) {
            HashSet<String> reportIds = entry.getValue();
            if (reportIds.size() >= k) {
                Iterator<String> iterator = reportIds.iterator();
                while (iterator.hasNext()) {
                    String id = iterator.next();
                    result[reportCount.get(id)]++;
                }
            }
        }

        return result;
    }

    public static int kakaoQuestion5(String s) {
        String[] array = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < array.length; i++) {
            s = s.replaceAll(array[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }

    public static long delivery(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        boolean loop = true;
        while(loop) {
            int delivery = 0;
            int pick = 0;
            int count = 0;

            for (int i = n - 1; i >= 0; i--) {
                int min = cap - delivery;
                if (min == 0) {
                    break;
                }
                if (deliveries[i] > 0) {
                    if (deliveries[i] <= min) {
                        delivery += deliveries[i];
                        deliveries[i] = 0;
                    } else {
                        deliveries[i] -= min;
                        delivery += deliveries[i];
                    }
                    count = Math.max(i + 1, count);
                }
            }
            answer += count;

            for (int i = n - 1; i >= 0; i--) {
                int max = cap - pick;
                if (max == 0) {
                    break;
                }
                if (pickups[i] > 0) {
                    if (pickups[i] < max) {
                        pick += pickups[i];
                        pickups[i] = 0;
                    } else {
                        pickups[i] -= max;
                        pick = 0;
                    }
                    count = Math.max(i + 1, count);
                }
            }
            answer += count;
            if (count == 0) {
                loop = false;
            }
        }

        return answer;
    }

    public static int[] emotion(int[][] users, int[] emoticons) {
        int[] discount = {10, 20, 30, 40};
        int emoticonLength = emoticons.length;
        ArrayList<int[]> answer = new ArrayList<>();
        answer.add(new int[]{0,0});

        emotionDfs(users, emoticons, new int[emoticonLength], 0, discount, answer);

        Collections.sort(answer, (a, b) -> b[0] - a[0] == 0 ? b[1]-a[1] : b[0]-a[0]);
        return answer.get(0);
    }

    private static void emotionDfs(int[][] users, int[] emoticons, int[] discountInfo, int level, int[] discount, ArrayList<int[]> answer) {
        if (level == emoticons.length) {
            int buyCount = 0;
            int buySum = 0;

            for (int i = 0; i < users.length; i++) {
                int sum = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    if (discountInfo[j] >= users[i][0]) {
                        sum += emoticons[j] / 100 * (100 - discountInfo[j]);
                    }
                }
                if (sum >= users[i][1]) {
                    buyCount++;
                } else {
                    buySum += sum;
                }
            }
            answer.add(new int[] {buyCount, buySum});
        } else {
            for (int i = 0; i< 4; i++) {
                discountInfo[level] = discount[i];
                emotionDfs(users, emoticons, discountInfo, level+1, discount, answer);
            }
        }
    }
}
