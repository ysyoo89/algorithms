package com.personal.season1.answer;

import org.springframework.stereotype.Service;

import java.util.*;

public class Answer {
    // 동전 찾기와 같은 문제는 그리디로 풀며, 아래에서부터 적은 조건 찾으면서 조건을 해결하는 것이다.
    // 이 문제는 그리디로 푸는 것처럼 최소한으로 거스르는 것과 같이 문제를 푸는 것이다.
    //https://school.programmers.co.kr/learn/courses/30/lessons/148653
    public int magicStone(int storey) {
        int answer = 0;

        for (int i = 8; i >= 0; i--) {
            double pow = Math.pow(10, i);
            if (pow == 1) {
                answer += storey;
                break;
            }

            if (storey > pow) {
                int value = (int) (storey / pow);

                int temp1 = (int) Math.abs(pow * value - storey);
                int temp2 = (int) Math.abs(pow * (value + 1) - storey);
                if (temp1 < temp2) {
                    answer += value;
                    storey = temp1;
                } else if (temp2 < temp1) {
                    answer += value + 1;
                    storey = temp2;
                }

            }
        }

        return answer;
    }

    // 그리디 문제 방법 풀이1
    public int magicStoneEtc(int storey) {
        int answer = 0;
        while(storey > 0) {
            int value = storey % 10;
            storey = storey / 10;

            if (value > 5 ) {
                answer += 10 - value;
                storey++;
            } else if (value < 5) {
                answer += value;
            } else if (storey % 10 >= 5) {
                answer += 5;
                storey++;
            } else {
                answer += 5;
            }

        }
        return answer;
    }

    // dp 방식의 풀이
    // 실제 풀이는 저 안에서 같은 1의 개수를 패턴대로 찾아서 수학적 공식으로 만드는 것.
    public int canto(int n, long l, long r) {
        int answer = 0;
        StringBuilder[] bit = new StringBuilder[n + 1];
        for (int i = 0; i <= n; i++) {
            bit[i] = new StringBuilder();
        }
        bit[0].append("1");
        bit[1].append("11011");
        for (int i = 2; i <= n; i++) {
            bit[i].append(bit[i-1]);
            bit[i].append(bit[i-1]);
            for (double j = 0; j < Math.pow(5, i-1); j++) {
                bit[i].append("0");
            }
            bit[i].append(bit[i-1]);
            bit[i].append(bit[i-1]);
        }

        for (long i = l-1; i < r; i++) {
            if (bit[n].charAt(Math.toIntExact(i)) == '1') {
                answer++;
            }
        }
        return answer;
    }

    public int xor(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int[][] temp = data;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j= 0; j < data.length - 1 - i; j++) {
                if (temp[j][col - 1] > temp[j+1][col - 1]) {
                    int[] arr = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j +1] = arr;
                } else if (temp[j][col - 1] == temp[j+1][col - 1]) {
                    if (temp[j][0] < temp[j+1][0]) {
                        int[] arr = temp[j];
                        temp[j] = temp[j + 1];
                        temp[j +1] = arr;
                    }
                }
            }
        }

        for (int i = row_begin - 1; i < row_end; i++) {
            int mod = 0;
            for (int j= 0; j < temp[i].length; j++) {
                mod += temp[i][j] % (i + 1);
            }
            answer = answer ^ mod;
        }
        return answer;
    }

    public int defence(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i= 0; i < enemy.length; i++) {
            queue.add(enemy[i] * -1);
        }
        while(!queue.isEmpty()) {
            int cn = queue.poll();
            if (k > 0) {
                k--;
                answer++;
                continue;
            }
            if (n > (cn * -1)) {
                n += cn;
                answer++;
            } else {
                queue.clear();
            }

        }
        return answer;
    }

    public int defence2(int n, int k, int[] enemy) {
        // queue에 담긴 숫자는 무적권으로 방어할 라운드의 적의 수
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int round = 0; round < enemy.length; round++) {
            // 각 라운드의 적의 수를 queue에 담는다
            queue.add(enemy[round]);
            // 무적권의 수 보다 방어할 라운드가 많은 경우, 적의 수가 가장 적은 라운드 전투하여 병력감소
            if (queue.size() > k)
                n -= queue.poll();
            // 병력이 0보다 적어지면 게임이 종료되며 해당 라운드 수를 반환한다(라운드는 0-index 이므로 -1 하지 않아도 된다)
            if (n < 0)
                return round;
        }
        // 게임 클리어 한 경우, 총 라운드 수 반환
        return enemy.length;
    }

    public long point(int k , int d) {
        // 피타고라스를 이용하여 문제를 풀어야함.
        // x² + y² <= d²
        // 해당 공식을 통해 y의 최대값을 구한 뒤 그 사이에 있는 모든 정수를 찾아주면 된다.
        // 마지막에 y+1을 해주는 것은 0의 값을 추가해주기 위한 처리이다.
        // k로 나눠주는 것은 간격이 k를 기준으로 하기 때문에 최대값에서 k값을 나눠주면
        // 해당 값을 그렇게 만들어 줄 수 있다.
        long answer = 0;
        for (int i = 0; i <= d; i += k) {
            long y = (long) (Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2))) / k;
            answer += y + 1;
        }
        return answer;
    }

    public int delivery(int[] order) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            list.add(i);
        }

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (order[cnt] == list.get(i)) {
                answer++;
                cnt++;

                while(!stack.isEmpty() && stack.peek() == order[cnt]) {
                    stack.pop();
                    cnt++;
                    answer++;
                }
            } else {
                stack.push(list.get(i));
            }
        }
        return answer;
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/131701
     */
    public int partNumber(int[] elements) {
        HashSet<Integer> result = new HashSet<>();
        int size = elements.length;
        for (int i = 1; i <= elements.length; i++) {
            HashSet<Integer> temp = new HashSet<>();
            int val = 0;
            for (int j = 0; j < i; j++) {
                val += elements[j % size];
            }
            temp.add(val);
            for (int j = 0; j < elements.length; j++) {
                val -= elements[j % size];
                val += elements[(j + i) % size];
                temp.add(val);
            }
            result.addAll(temp);
        }
        return result.size();
    }

}
