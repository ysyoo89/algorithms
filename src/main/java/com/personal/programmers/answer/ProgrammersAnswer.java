package com.personal.programmers.answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
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

    public static int babbling(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            String tmp = babbling[i];
            int beforeIdx = -1;
            for(int j = 0; j < words.length; j++) {
                if (tmp.indexOf(words[j]) == 0) {
                    if (beforeIdx == j) break;
                    tmp = tmp.substring(tmp.indexOf(words[j]) + words[j].length());
                    beforeIdx = j;
                    j = -1;
                }
            }
            if (tmp.length() < 1) {
                answer++;
            }
        }
        return answer;
    }

    public static int cola(int a, int b, int n) {
        int answer = 0;
        int tempN = n;
        int tempRemainder = 0;
        while(tempN+tempRemainder >= a) {
            int quotient = tempN / a * b;
            int remainder = tempN % a;
            tempN = quotient;
            if (remainder > 0) {
                tempRemainder += remainder;
            }
            if (quotient < 1) {
                tempN += tempRemainder;
                tempRemainder = 0;
            } else {
                answer += quotient;
            }

        }
        return answer;
    }

    public static int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length; i++) {
            int sum = number[i];
            for (int j = i+1; j < number.length; j++) {
                if (sum < 0 && number[j] >= 0) {
                    sum += number[j];
                } else if (sum > 0 && number[i] <= 0) {
                    sum += number[j];
                }
            }
        }
        return answer;
    }

    static int answer, N;
    public static int threeMan(int[] number) {
        N = 3;
        comb(0, 0, 0, number);
        return answer;
    }

    public static void comb(int cur, int cnt, int sum, int[] number) {
        if (cnt == N) {
            if (sum == 0)
                answer++;
            return;
        }

        for (int i = cur; i < number.length; i++) {
            comb(i + 1, cnt + 1, sum + number[i], number);
        }
    }

    public static int pokemon(int[] nums) {
        int limit = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (set.size() < limit) {
                set.add(num);
            }
        }
        return set.size();
    }

    public static String calendar(int a, int b) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
        String year = "2016";
        String month = a < 10 ? "0" + a : String.valueOf(a);
        String day = b < 10 ? "0" + b : String.valueOf(b);
        String date = year + "-" + month + "-" + day;
        try {
            Date nDate = dateFormat.parse(date);
            Calendar cal = Calendar.getInstance() ;
            cal.setTime(nDate);
            return dayOfWeek(1);
        } catch (Exception e) {
            return "";
        }

    }

    private static String dayOfWeek(int day) {
        String result = "";
        switch (day) {
            case 1 : result = "SUN"; break;
            case 2 : result = "MON"; break;
            case 3 : result = "TUE"; break;
            case 4 : result = "WED"; break;
            case 5 : result = "THU"; break;
            case 6 : result = "FRI"; break;
            case 7 : result = "SAT"; break;
        }
        return result;
    }

    public static String middleWord(String s) {
        int stringLength = s.length();
        StringBuilder result = new StringBuilder();
        if (stringLength % 2 == 0) {
            result.append(s.charAt(stringLength / 2 - 1));
            result.append(s.charAt(stringLength / 2));
        } else {
            result.append(s.charAt(stringLength / 2));
        }
        return result.toString();

        // return word.substring((word.length()-1) / 2, word.length()/2 + 1);
    }

    public static int[] notDuplicationNumber(int[] arr) {
        Stack<Integer> number = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            number.push(arr[i]);
            if (number.size() > 1) {
                if (number.get(i -1) == number.get(i)) {
                    number.pop();
                }
            }
        }
        int[] result = new int[number.size()];
        for (int i = 0; i < number.size(); i++) {
            result[i] = number.get(i);
        }
        return result;
    }

    public static int[] divisionArray(int[] arr, int divisor) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            if (num % divisor == 0) {
                queue.add(num);
            }
        }
        int[] result;
        if (queue.size() != 0) {
            result = new int[queue.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = queue.poll();
            }
        } else {
            result = new int[] {-1};
        }
        return result;
    }

    public static long sumInteger(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        long result = 0L;
        for (int i = a; i <= b; i++) {
            result += i;
        }
        return result;
    }

    public static String[] stringSort(String[] strings, int n) {
        for(int i=0; i<strings.length-1; i++){
            for(int k=i+1; k<strings.length;k++){
                if(strings[i].charAt(n)>strings[k].charAt(n)){
                    String tmp = strings[i];
                    strings[i]= strings[k];
                    strings[k]=tmp;
                }
                else if(strings[i].charAt(n)==strings[k].charAt(n)){
                    if(strings[i].compareTo(strings[k]) >0){
                        String tmp = strings[i];
                        strings[i]= strings[k];
                        strings[k]=tmp;
                    }
                }
            }
        }
        return strings;
    }

    public static boolean stringCount(String s) {
        StringBuffer buffer = new StringBuffer(s);
        int count = 0;
        for (int i = 0; i < buffer.length(); i++) {
            char temp = buffer.charAt(i);
            if ('P' == temp || 'p' == temp) {
                count++;
            } else if ('Y' == temp || 'y' == temp) {
                count--;
            }
        }
        return count == 0;
    }

    public static int minimumRectangle(int[][] sizes) {
        int result = 0;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1] ) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            maxX = Math.max(maxX, sizes[i][0]);
            maxY = Math.max(maxY, sizes[i][1]);
        }
        result = maxX * maxY;
        return result;
    }

    public static int[] mockTest(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int answerFirst = 0;
        int answerSecond = 0;
        int answerThird = 0;
        for (int i = 0; i < answers.length; i++) {
            int firstIndex = i % first.length;
            int secondIndex = i % second.length;
            int thirdIndex = i % third.length;

            if (mockTestCheck(answers[i], first[firstIndex])) {
                answerFirst++;
            }
            if (mockTestCheck(answers[i], second[secondIndex])) {
                answerSecond++;
            }
            if (mockTestCheck(answers[i], third[thirdIndex])) {
                answerThird++;
            }
        }
        return mockTestResult(answerFirst, answerSecond, answerThird);
    }

    private static int[] mockTestResult(int answerFirst, int answerSecond, int answerThird) {
        List<Integer> list = new ArrayList<>();
        int maxAnswer = Math.max(answerFirst, Math.max(answerSecond, answerThird));
        if (maxAnswer == answerFirst) {
            list.add(1);
        }
        if (maxAnswer == answerSecond) {
            list.add(2);
        }
        if (maxAnswer == answerThird) {
            list.add(3);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static boolean mockTestCheck(int answer, int testAnswer) {
        return answer == testAnswer;
    }

    
    public static int fibonacci(int n) {
        int result = fibonacciDFS(n);
        return result;
    }

    private static int fibonacciDFS(int n) {
    	if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        return fibonacciDFS(n - 2) +  fibonacciDFS(n - 1);
    }

    public static int factorial(int n) {
        int result = 1;
        return factorialDFS(n, result);
    }

    private static int factorialDFS(int n, int result) {
        if (n <= 1) return 1 * result;
        result = n * result;
        return factorialDFS(n - 1, result);
    }
    
    
    public static int recursion(String s, int l, int r, int count){
    	count++;
        if(l >= r) {
        	System.out.print("1 ");
        	return count;
        }
        else if(s.charAt(l) != s.charAt(r)) {
        	System.out.print("0 ");
        	return count;
        }
        else return recursion(s, l+1, r-1, count);
    }
    
    public static int isPalindrome(String s, int count){
        return recursion(s, 0, s.length()-1, count);
    }


    /**
     * 참고 블로그 (완벽히 이해하자)
     * https://st-lab.tistory.com/95
     */
    static StringBuilder[] sb;
	public static void star(int n) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(br.readLine());
        } catch (Exception ex) {
            ex.getMessage();
        }

        String s = String.format("%" + N + "s", ' ').replace(' ', '*');
        sb = new StringBuilder[N];
        
        for (int i = 0; i < N; i++) {
            sb[i] = new StringBuilder(s);
        }
        star(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            System.out.println(sb[i]);
        }
	}

    public static void star(int x, int y, int N, boolean blank) {
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    sb[i].setCharAt(j, ' ');
                }
            }
        }

        if (N == 1) {
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x+N; i += size) {
            for (int j = y; j < y+N; j += size) {
                count++;
                if (count == 5) {
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
    }
    
    
	public static void hanoiTower(int n) {
		hanoi(1, 2, 3, n);
	}
	
	/**
	 * 하노이 탑 참고 블로그
	 * https://st-lab.tistory.com/96
	 */
	public static void hanoi(int start, int middle, int to, int n) {
		if (n == 1) {
			System.out.println(start + " " + to);
			return;
		} else {
			hanoi(start, to, middle, n -1);
			
			System.out.println(start + " " + to);
			
			hanoi(middle, start, to, n -1);
		}
	}

    public static int[] keymap(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];
        Map<Character, Integer> move = new HashMap<>();
        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                char sign = key.charAt(i);
                int step = move.getOrDefault(sign, i+1);
                move.put(sign, Math.min(step, i+1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            for(int j = 0; j < targets[i].length(); j++) {
                char temp = targets[i].charAt(j);
                if (move.containsKey(temp)) {
                    result[i] += move.get(temp);
                } else {
                    result[i] = -1;
                    break;
                }
            }
        }
        return result;
    }

    public static int paint(int n, int m, int[] section) {
        int result = 0;
        int max = 0;
        for (int i = 0; i < section.length; i++) {
            if (section[i] > max) {
                result++;
                max = section[i] + m - 1; // 칠한 공간
            }
        }
        return result;
    }

    public static String[] race(String[] players, String[] callings) {
//        String[] result = players;
//        List<String> list = Arrays.asList(players);
//
//        for(int i = 0; i < callings.length; i++) {
//            String temp = callings[i];
//            int size = list.indexOf(temp);
//            result[size] = result[size - 1];
//            result[size - 1] = temp;
//        }
//        return result;
        String[] result = players.clone();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int rank = map.get(callings[i]);
            map.put(result[rank], rank -1);
            map.put(result[rank - 1], rank);
            String name = callings[i];
            result[rank] = result[rank -1];
            result[rank -1] = name;
        }

        return result;
    }

    public static int[] findNumber(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            list.clear();
            for(int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(commands[i][2] - 1);
        }
        return answer;
    }

    public static boolean checkStr(String s) {
        boolean result = false;
        char[] temp = s.toCharArray();
        if (temp.length == 4 || temp.length == 6) {
            result = true;
        }
        for(int i = 0; i < temp.length; i++) {
            if (temp[i] > 57 || temp[i] < 48) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static String stringChange(String s) {
        String[] splitStr = s.split(" ", -1);
        String[] result = new String[splitStr.length];
        int count = 0;
        for (String str : splitStr) {
            String temp = "";
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (i % 2 == 0) {
                    ch = Character.toUpperCase(ch);
                } else {
                    ch = Character.toLowerCase(ch);
                }
                temp += ch;
            }
            result[count] = temp;
            count++;
        }
        return String.join(" ", result);
    }

    public static int[] memory(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> score = new HashMap<>();
        int[] result = new int[photo.length];
        for (int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }
        for (int i = 0; i < photo.length; i++) {
            int totalScore = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (score.containsKey(photo[i][j])) {
                    totalScore += score.get(photo[i][j]);
                }
            }
            result[i] = totalScore;
        }
        return result;
    }

    public static int[] robot(String[] park, String[] routes) {
        int[] result = new int[2];
        int w = park[0].length() - 1;
        int h = park.length - 1;
        int[][] arrays = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                result[0] = i;
                result[1] = park[i].indexOf("S");
                break;
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] temp = routes[i].split(" ");
            int distance = Integer.parseInt(temp[1]);
            int index = getDirectionIndex(temp[0]);

            if (isWalk(park, result, arrays[index], distance)) {
                result[0] += distance*arrays[index][0];
                result[1] += distance*arrays[index][1];
            }
        }
        return result;
    }

    private static boolean isWalk(String[] park, int[] result, int[] arrays, int move) {
        int x = result[0];
        int y = result[1];
        for(int i = 0; i< move; i++){
            x+= arrays[0];
            y+= arrays[1];

            if(isRange(park[0].length()-1, y) || isRange(park.length-1, x) || park[x].charAt(y)=='X'){
                return false;
            }
        }
        return true;
    }

    private static boolean isRange(int basic, int movePoint) {
        if (movePoint < 0 || basic < movePoint) {
            return false;
        }
        return true;
    }

    private static int getDirectionIndex(String direction) {
        int index = 0;
        switch (direction){
            case "N":
                break;
            case "S":
                index = 1;
                break;
            case "W":
                index = 2;
                break;
            case "E":
                index = 3;
                break;
        }
        return index;
    }

    public static int[] wallpaper(String[] wallpaper) {
        int[] result = new int[4];
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MAX_VALUE;
        result[2] = Integer.MIN_VALUE;
        result[3] = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                result[0] = Math.min(result[0], i);
                result[1] = Math.min(result[1], wallpaper[i].indexOf("#"));
                result[2] = Math.max(result[2], i + 1);
                result[3] = Math.max(result[3], wallpaper[i].lastIndexOf("#") + 1);
            }
        }
        return result;
    }

    public static String chooseWords(String[] cards1, String[] cards2, String[] goal) {
        String result = "Yes";
        List<String> card1 = new ArrayList<>(Arrays.asList(cards1));
        List<String> card2 = new ArrayList<>(Arrays.asList(cards2));
        for (String str : goal) {
            if (card1.size() > 0 && card1.get(0).equals(str)) {
                card1.remove(0);
            } else if (card2.size() > 0 && card2.get(0).equals(str)) {
                card2.remove(0);
            } else {
                return "No";
            }
        }
        return result;
    }

    public static String decoder(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }

    public static int[] findWord(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            answer[i] = i-map.getOrDefault(ch,i+1);
            map.put(ch,i);
        }
        return answer;
    }

    public static int straightWords(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int mainCount = 1;
        int subCount = 0;

        for (int i = 1; i < s.length(); i++) {
            if (x == ' ') {
                x = s.charAt(i);
                continue;
            }
            if (x == s.charAt(i)) {
                mainCount++;
            }else{
                subCount++;
            }
            if (mainCount == subCount) {
                answer++;
                x = ' ';
                mainCount = 1;
                subCount = 0;
            }
        }
        if (x != ' ') {
            answer++;
        }

        return answer;
    }

    public static String numberPartner(String x, String y) {
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();
        StringBuilder tempStr = new StringBuilder();

        for (char chr : x.toCharArray()) {
            xMap.put(chr, xMap.getOrDefault(chr, 0) + 1);
        }

        for (char chr : y.toCharArray()) {
            yMap.put(chr, yMap.getOrDefault(chr, 0) + 1);
        }

        for (int i = 0; i < x.length(); i++) {
            char temp = x.charAt(i);
            int min = 0;
            if (yMap.containsKey(temp)) {
                min = Math.min(xMap.get(temp), yMap.get(temp));
                xMap.put(temp, 0);
                yMap.put(temp, 0);
            }
            for (int j = 0; j < min; j++) {
                tempStr.append(temp);
            }
        }
        char[] sortChar = tempStr.toString().toCharArray();
        Arrays.sort(sortChar);
        String result = new StringBuilder(new String(sortChar)).reverse().toString();
        if (result.equals("")) {
            result = "-1";
        }
        if (result.charAt(0) == '0') {
            result = "0";
        }

        return result;
    }

    public static int smallNumber(int n) {
        int stan = n - 1;
        int result = stan;
        for (int i = 2; i <= (int)Math.sqrt(stan); i++) {
            if (stan % i == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static int plusNumber(int[] numbers) {
        int stan = 45;
        for (int number : numbers) {
            stan -= number;
        }
        return stan;
    }

    public static long rides(int price, int money, int count) {
        long ridesPrice = 0L;
        for (int i = 1; i <= count; i++) {
            ridesPrice += price * i;
        }
        long result = ridesPrice - money;

        return result < 0 ? 0 : result;
    }

    /**
     * 중복된 문자열이 없도록 할 때 배열의 문자열 중 가장 긴 문자열을 찾아라
     */
    public static int solution(String[] A) {
        int result = 0;
        boolean isDuplicate = false;
        for (int i = 0; i < A.length; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(A[i]);
            for (int j = i + 1; j < A.length; j++) {
                builder.append(A[j]);
                for (int k = 0; k < builder.length(); k++) {
                    if (builder.toString().indexOf(builder.toString().charAt(k)) != k ) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (isDuplicate) {
                    builder.delete(builder.length() - A[j].length(), builder.length());
                } else {
                    result = Math.max(result, builder.length());
                }
                isDuplicate = false;
            }
        }

        return result;
    }

    /**
     * 음수가 되지 않도록 유지하는 방법을 찾아라
     * 배열의 수들을 합할 때 음수를 유지하지 않도록 배열속의 숫자를 움직일 때 몇번 움직이면 음수로 되지 않는가
     */
    public static int solution2(int[] A) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            sum += A[i];
            if ((sum == 0 && A[i + 1] < 0) || (sum < 0 && A[i] < 0) ) {
                answer++;
                sum += A[i] * -1;
            }
        }

        return answer;
    }

    /**
     * 가장 적게 움직여서 모두 같은 수를 만드는 것
     * 다른 수로 움직이는건 하나로 처리
     */
    public static int solution3(int[] A) {
        int answer = 0;
        long sum = 0;
        for (int a : A) {
            sum += a;
        }
        double t = (double)sum / A.length;
        double average = Math.ceil(t);

        for (int a : A) {
            if (a < average) {
                answer += average - a;
            } else if (a > average) {
                answer -= a - average;
            }
        }
        return answer;
    }
}
