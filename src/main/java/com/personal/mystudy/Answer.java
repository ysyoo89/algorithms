package com.personal.mystudy;

import java.util.*;

public class Answer {
    static List<Map<Integer, Integer>> HANOI_LIST = new ArrayList<>();
    public static int[][] hanoi(int n) {
        hanoiTower(1, 2, 3, n);
        int[][] answer = new int[HANOI_LIST.size()][2];
        for (int i= 0; i < HANOI_LIST.size(); i++) {
            int[] val = new int[2];
            for (int key : HANOI_LIST.get(i).keySet()) {
                val[0] = key;
                val[1] = HANOI_LIST.get(i).get(key);
            }
            answer[i] = val;
        }
        return answer;
    }

    private static void hanoiTower(int start, int middle, int to, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if (n == 1) {
            // 배열의 이동 정보 저장
            map.put(start, to);
            HANOI_LIST.add(map);
            return;
        } else {
            hanoiTower(start, to, middle, n - 1);
            // 배열의 이동 정보 저장
            map.put(start, to);
            HANOI_LIST.add(map);
            hanoiTower(middle, start, to, n - 1);
        }
    }

    public static int[] triangle(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                matrix[x][y] = num++;
            }
        }

        int k = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }

    public static String game(int n, int t, int m, int p) {
        StringBuilder binary = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int number = 0;
        while(m * t > binary.length()) {
            binary.append(Integer.toString(number, n));
            number++;
        }

        char[] temp = binary.toString().toCharArray();

        for (int i = p - 1; i < m * t; i = i + m) {
            answer.append(temp[i]);
        }

        return answer.toString().toUpperCase();
    }

    public static int[] quad(int[][] arr) {
        return quadDfs(arr, 0, 0, arr.length, new int[2]);
    }

    private static int[] quadDfs(int[][] arr, int row, int col, int length, int[] count) {
        int value = arr[row][col];
        boolean match = true;

        for (int i = row; match && i < row + length; i++) {
            for (int j = col; match && j < col + length; j++) {
                match &= value == arr[i][j];
            }
        }

        if (match) {
            count[value]++;
        } else {
            length /= 2;

            quadDfs(arr, row, col, length, count);
            quadDfs(arr, row + length, col, length, count);
            quadDfs(arr, row, col + length, length, count);
            quadDfs(arr, row + length, col + length, length, count);
        }
        return count;
    }

    public static int[] capet(int brown, int yellow) {
        int sum = brown + yellow;
        int y = 0, x = 0;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                y = Math.min(i, yellow / i);
                x = Math.max(i, yellow / i);
                if ((y + 2) * (x + 2) == sum) {
                    break;
                }
            }
        }

        return new int[] {x + 2, y + 2};
    }

    public static int minimumNumber(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[a.length - 1 - i];
        }
        return answer;
    }

    public static int lcm(int[] arr) {
        int gcd = getGcd(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;

        for (int i = 2; i < arr.length; i++) {
            gcd = getGcd(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        return lcm;
    }

    private static int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGcd(b, a % b);
    }

    static Map<Integer, Set<Integer>> ELEC_MAP = new HashMap<>();
    static Set<Integer> ELEC_VISIT = new HashSet<>();
    static int ALL_TREE_COUNT;
    static int ELEC_MIN;
    public static int electronic(int n, int[][] wires) {
        elecInit(wires);
        ELEC_MIN = n;
        ALL_TREE_COUNT = n;

        int count = treeCount(wires[0][0]);
        if (ALL_TREE_COUNT != count) {
            return 0;
        }
        return ELEC_MIN;
    }

    private static int treeCount(int root) {
        ELEC_VISIT.add(root);
        int count = 1;
        for (Integer childNode : ELEC_MAP.get(root)) {
            if (ELEC_VISIT.contains(childNode)) {
                continue;
            }
            count += treeCount(childNode);
        }
        int otherTreeCount = ALL_TREE_COUNT - count;
        ELEC_MIN = Math.min(ELEC_MIN, Math.abs(count - otherTreeCount));

        return count;
    }

    private static void elecInit(int[][] wires) {
        for (int[] wire : wires) {
            ELEC_MAP.putIfAbsent(wire[0], new HashSet<>());
            ELEC_MAP.putIfAbsent(wire[1], new HashSet<>());
            ELEC_MAP.get(wire[0]).add(wire[1]);
            ELEC_MAP.get(wire[1]).add(wire[0]);
        }
    }

    public static long maxRole(String expression) {
        long answer = 0;
        List<Long> num = new ArrayList<>();
        List<String> cal = new ArrayList<>();

        int numIndex = 0;
        for (int i = 0; i < expression.length(); i++) {
            char temp = expression.charAt(i);
            if (temp == '*' || temp == '+' || temp == '-') {
                cal.add(String.valueOf(expression.charAt(i)));
                num.add(Long.parseLong(expression.substring(numIndex, i)));
                numIndex = i + 1;
            }
        }
        num.add(Long.parseLong(expression.substring(numIndex, expression.length())));

        answer = calculator(num, cal, "*", "+", "-", answer);
        answer = calculator(num, cal, "*", "-", "+", answer);
        answer = calculator(num, cal, "+", "*", "-", answer);
        answer = calculator(num, cal, "+", "-", "*", answer);
        answer = calculator(num, cal, "-", "+", "*", answer);
        answer = calculator(num, cal, "-", "*", "+", answer);
        return answer;
    }



    private static long calculator(List<Long> num, List<String> cal, String first, String second, String third, long answer) {
        long result = 0;

        int idx = 0;
        List<Long> tempNum = new ArrayList<>(num);
        List<String> tempCal = new ArrayList<>(cal);
        while(!tempCal.isEmpty()) {
            if (tempCal.indexOf(first) != -1) {
                idx = tempCal.indexOf(first);
            } else if (tempCal.indexOf(second) != -1) {
                idx = tempCal.indexOf(second);
            } else if (tempCal.indexOf(third) != -1) {
                idx = tempCal.indexOf(third);
            }

            if (idx == -1) break;

            long f = tempNum.remove(idx);
            long e = tempNum.remove(idx);
            String c = tempCal.remove(idx);

            switch (c) {
                case "*":
                    result = f * e;
                    break;
                case "+":
                    result = f + e;
                    break;
                case "-":
                    result = f - e;
                    break;
            }
            tempNum.add(idx, result);
        }

        result = Math.max(answer, Math.abs(result));
        return result;
    }

    public static String[] openChat(String[] record) {
        Map<String, String> map = new LinkedHashMap<>();
        List<String> answer = new ArrayList<>();
        for (String action : record) {
            String[] temp = action.split(" ");
            if (temp[0].equals("Enter")) {
                map.put(temp[1], temp[2]);
            } else if (temp[0].equals("Change")) {
                map.put(temp[1], temp[2]);
            }
        }

        for (String action : record) {
            StringBuilder builder = new StringBuilder();
            String[] temp = action.split(" ");
            if (temp[0].equals("Enter")) {
                builder.append(map.get(temp[1]));
                builder.append("님이 들어왔습니다.");
                answer.add(builder.toString());
            } else if (temp[0].equals("Leave")) {
                builder.append(map.get(temp[1]));
                builder.append("님이 나갔습니다.");
                answer.add(builder.toString());
            }
        }
        String[] result = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    static int WORD_ANSWER = Integer.MAX_VALUE;
    public static int wordChange(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfsWordChange(0, 0, begin, target, words, visited);

        return WORD_ANSWER == Integer.MAX_VALUE ? 0 : WORD_ANSWER;
    }

    private static void dfsWordChange(int idx, int count, String begin, String target, String[] words, boolean[] visited) {
        if (idx >= words.length) {
            return;
        }

        if (begin.equals(target)) {
            WORD_ANSWER = Math.min(WORD_ANSWER, count);
            return;
        }


        for (int i = 0; i < words.length; i++) {
            if (visited[i] || WORD_ANSWER <= count || !checkWord(begin, words[i])) {
                continue;
            }

            visited[i] = true;
            dfsWordChange(i, count + 1, words[i], target, words, visited);
            visited[i] = false;
        }
    }

    private static boolean checkWord(String begin, String target) {
        int differentCount = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                differentCount++;

                if (differentCount >= 2) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[] arrQueue(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int maxAnswer = Integer.MIN_VALUE;
        int minAnswer = Integer.MAX_VALUE;

        for (int i = 0; i < operations.length; i++) {
            String[] tempStr = operations[i].split(" ");
            int temp = Integer.valueOf(tempStr[1]);
            if ("I".equals(tempStr[0])) {
                minQueue.add(temp);
                maxQueue.add(temp);
                queue.add(temp);
            } else {
                if (queue.isEmpty()) {
                    continue;
                }

                if (temp == 1) {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                    queue.remove(max);
                } else {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                    queue.remove(min);
                }
            }
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            maxAnswer = Math.max(maxAnswer, temp);
            minAnswer = Math.min(minAnswer, temp);
        }
        return new int[] {maxAnswer == Integer.MIN_VALUE ? 0 : maxAnswer, minAnswer == Integer.MAX_VALUE ? 0 : minAnswer};
    }

    public static int test1(String s) {
        int answer = 0;
        int[] temp = new int[128];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i)]++;
        }

        for (int val : temp) {
            if (val % 2 == 1) {
                answer++;
            }
        }
        return answer;
    }

    public static int test2(String p, String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char pNum = p.charAt(i);
            char sNum = s.charAt(i);

            int cal = Math.abs(pNum - sNum);
            if (cal > 5) {
                answer += 10 - cal;
            } else {
                answer += cal;
            }
        }
        return answer;
    }

    public static int test3(int[][] atmos) {
        int[] dust = {81, 151};
        int[] ultraDust = {36, 76};
        boolean useMask = false;
        int useDay = 0;
        int answer = 0;
        for (int i = 0; i < atmos.length; i++) {

            if (useDay >= 3) {
                useMask = false;
                useDay = 0;
            } else if (useMask) {
                useDay++;
            }

            if (!useMask && (atmos[i][0] >= dust[0] || atmos[i][1] >= ultraDust[0])) {
                useMask = true;
                useDay++;
                answer++;
            }

            if (atmos[i][0] >= dust[1] && atmos[i][1] >= ultraDust[1]) {
                useMask = false;
                useDay = 0;
            }
        }
        return answer;
    }

    public static int test4(String[] ip_addrs, String[] langs, int[] scores) {
        int answer = 0;
        Map<String, Integer> people = new LinkedHashMap<>();
        Map<String, List<String>> lang = new LinkedHashMap<>();
        Map<String, List<Integer>> score = new LinkedHashMap<>();

        for (int i = 0; i < ip_addrs.length; i++) {
            String ip = ip_addrs[i];
            people.put(ip, people.getOrDefault(ip, 0) + 1);

            List<String> langList = lang.getOrDefault(ip, new ArrayList<>());
            langList.add(langs[i]);
            lang.put(ip, langList);

            List<Integer> scoreList = score.getOrDefault(ip, new ArrayList<>());
            scoreList.add(scores[i]);
            score.put(ip, scoreList);
        }

        for (String ip : people.keySet()) {
            int peopleCount = people.get(ip);
            
            if (peopleCount >= 4) {
                peopleCount = 0;
            } else if (peopleCount == 3) {
                List<String> tempLang = lang.get(ip);
                if (condition2(tempLang, 3)) {
                    peopleCount = 0;
                }
            } else if (peopleCount == 2) {
                List<String> tempLang = lang.get(ip);
                List<Integer> tempScore = score.get(ip);
                if (condition2(tempLang, 2) && condition3(tempScore, 2)) {
                    peopleCount = 0;
                }
            }
            answer += peopleCount;
        }
        return answer;
    }

    private static boolean condition3(List<Integer> tempScore, int standard) {
        int result = 1;
        for (int i = 1; i < tempScore.size(); i++) {
            if (tempScore.get(0).equals(tempScore.get(i))) {
                result++;
            }
        }
        return result == standard;
    }

    private static boolean condition2(List<String> tempLang, int standard) {
        int result = 1;
        for (int i = 1; i < tempLang.size(); i++) {
            if ('C' == tempLang.get(0).charAt(0)) {
                if (tempLang.get(0).charAt(0) == tempLang.get(i).charAt(0)) {
                    result++;
                }
            } else {
                if (tempLang.get(0).equals(tempLang.get(i))) {
                    result++;
                }
            }
        }
        return result == standard;
    }

    public static int test5(int n, int[][] battery) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < battery.length; i++) {
            answer = Math.min(answer, getCase(battery, n, 0, i));
        }

        return answer;
    }

    private static int getCase(int[][] battery, int n, int money, int idx) {
        if (n <= 0 || idx >= battery.length) {
            return Integer.MAX_VALUE;
        }

        if (n / battery[idx][0] == 0) {
            money += battery[idx][1];
            return money;
        } else {
            money += (n / battery[idx][0]) * battery[idx][1];
            n = n % battery[idx][0];
        }

        if (n > 0) {
            int temp = Integer.MAX_VALUE;
            for (int i = 1; i < battery.length; i++) {
                temp = Math.min(temp, getCase(battery, n, money, idx + i));
            }
            money = temp;
        }

        return money;
    }

    public static int network(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < computers.length; i++) {
            if (visited[i]) {
                continue;
            }

            que.offer(i);
            answer++;

            while (!que.isEmpty()) {
                int cur = que.poll();

                if (visited[cur]) {
                    continue;
                }

                visited[cur] = true;
                int[] computer = computers[i];

                for (int j = 0; j < computer.length; j++) {
                    if (visited[j] || computer[j] == 0) {
                        continue;
                    }
                    que.offer(j);
                }
            }
        }
        return answer;
    }

    public static int money(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                dp[j] += dp[j - money[i]];
            }
        }

        return dp[n] % 1000000007;
    }

    public static int rank(int n, int[][] results) {
        boolean[][] wins = new boolean[n+1][n+1];
        boolean[][] loses = new boolean[n+1][n+1];
        int answer = 0;
        for (int[] result : results) {
            wins[result[0]][result[1]] = true;
            loses[result[1]][result[0]] = true;
        }

        for (int i = 1; i < n+1; i++ ) {
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k < n+1; k++) {
                    if (wins[i][k] && wins[k][j]) {
                        wins[i][j] = true;
                        loses[j][i] = true;
                    }
                    if (loses[i][k] && loses[k][j]) {
                        wins[j][i] = true;
                        loses[i][j] = true;
                    }
                }
            }
        }

        for (int i =1; i < n+1; i++) {
            int number = 0;
            for (int j = 1; j < n+1; j++) {
                if (loses[i][j] || wins[i][j]) {
                    number++;
                }
            }
            if (number == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    public static String exam(int n, int k) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        char lastWord = 'a';
        for (int i = 0; i < n / 2; i++) {
            char word = 'a';
            if (count < k) {
                word = (char) (word + count);
                count++;
                lastWord = word;
            }
            builder.append(word);
        }
        if (count != k) {
            lastWord = (char) (lastWord + (k - count));
        }

        StringBuilder reverse = new StringBuilder(builder);
        if (n % 2 == 1) {
            builder.append(lastWord);
            builder.append(reverse.reverse());
        } else {
            builder.append(reverse.reverse());
        }

        return builder.toString();
    }

    public static int bracketCount(int n) {
        return bracketCountDfs(n, 0, 0);
    }

    private static int bracketCountDfs(int n, int l, int count) {
        if (l < 0 || n < l) {
            return 0;
        }

        if (n * 2 <= count) {
            return l == 0 ? 1 : 0;
        }
        int result = 0;
        result += bracketCountDfs(n, l + 1, count + 1) + bracketCountDfs(n , l -1, count+1);

        return result;
    }

    static List<List<String>> USER_IDS = new ArrayList<>();
    public static int badUser(String[] user_id, String[] banned_id) {
        Boolean[] visited = new Boolean[user_id.length];
        Arrays.fill(visited, false);
        badUserDfs(user_id, banned_id, visited, 0, 0);
        return USER_IDS.size();
    }

    private static void badUserDfs(String[] userId, String[] bannedId, Boolean[] visited, int start, int count) {
        if (count == userId.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    list.add(userId[i]);
                }
            }
            if (!USER_IDS.contains(list)) {
                USER_IDS.add(list);
            }
            return;
        }

        for (int i = start; i < bannedId.length; i++) {
            for (int j = 0; j < userId.length; j++) {
                String banned = bannedId[i];
                String user = userId[j];
                boolean checked = true;
                if (banned.length() != user.length()) {
                    checked = false;
                } else {
                    for (int k = 0; k < banned.length(); k++) {
                        if (banned.charAt(k) == '*') continue;
                        if (banned.charAt(k) != user.charAt(k)) {
                            checked = false;
                            break;
                        }
                    }
                }

                if (checked && !visited[j]) {
                    visited[j] = true;
                    badUserDfs(userId, bannedId, visited, i + 1, count + 1);
                    visited[j] = false;
                }
            }
        }
    }
}
