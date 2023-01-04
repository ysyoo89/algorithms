package com.personal.programmers.answer;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
}
