package com.personal.programmers.answer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProgrammersAnswerLevel2 {

    public static String numberChange(int n) {
        char[] numberChar = {'4', '1', '2'};
        StringBuffer buffer = new StringBuffer();
        int val = n;
        int division = 0;
        while(val != 0) {
            division = val % 3;
            val = val / 3;
            if (division == 0) {
                val--;
            }
            buffer.append(numberChar[division]);
        }
        return buffer.reverse().toString();
    }

    public static int[] lineSort(int n, long k) {
        int[] answer = new int[n];
        long temp = k - 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (temp == 0) {
                answer[i] = list.get(0);
                list.remove(0);
                continue;
            }
            long num = temp / factorial(n - i - 1);
            answer[i] = list.get((int)num);
            list.remove((int)num);
            temp = temp % factorial(n - i - 1);
        }

        return answer;
    }

    private static long factorial(int num) {
        long result = 1;
        for (long i = num; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    /**
     * 사람찾기
     * @param office
     * @param k
     * @return
     */
    public static int solve(int[][] office, int k) {
        int result = -1;
        int count = 0;

        for (int y = 0; y < office.length; y++) {
            if (y + k > office.length) {
                break;
            }
            for (int x = 0; x < office.length; x++) {
                count = 0;
                if (x + k > office.length) {
                    break;
                }
                for (int i = y; i < y + k; i++) {
                    for (int j = x; j < x + k; j++) {
                        count += office[i][j];
                        result = Math.max(result, count);
                    }
                }
            }
        }

        return result;
    }

    /**
     * 피보나치수열
     */
    public static int solution(int n) {
        int x = 1, y = 1;
        for (int i = 2; i <= n; i++) {
            int temp = x;
            x = x + y;
            y = temp;
        }
        return x;
    }

    /**
     * 3의 배수 구하기
     * @param n
     * @return
     */
    static long totalCnt = 0;
    static long result = 0;
    public static long power(long n) {
        powerDfs(n, 0L, 0L,false);
        return result;
    }

    private static void powerDfs(long n, long pow, long stepPow, boolean init) {        
        if (totalCnt == n) {
        	return;
        }       
        
        if (init) {
        	stepPow = 0L;
        	powerDfs(n, pow, stepPow, false);
        }
        
        totalCnt++;
        
        long power = (long) Math.pow(3, pow);
        
        result = result + power;
        
        if (pow == stepPow) {
        	powerDfs(n, pow +1, stepPow, true);
        } else if (pow > stepPow) {
        	powerDfs(n, pow, stepPow +1, false);
        }
        	
    }


    public static String minAndMax(String s) {
        String[] temp = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.length; i++) {
            int num = Integer.valueOf(temp[i]);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(min));
        builder.append(" ");
        builder.append(String.valueOf(max));
        return builder.toString();
    }

    public static int aloneGame(int[] cards) {
        int card = 1;
        List<Integer> numbers = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < cards.length; ) {
            if (cards[i] != 0) {
                int count = 0;
                card = i + 1;
                while(card != 0) {
                    int index = card - 1;
                    if (cards[index] != 0) {
                        card = cards[index];
                        cards[index] = 0;
                        count++;
                    } else {
                        card = cards[index];
                    }
                }
                numbers.add(count);
            } else {
                i++;
            }
        }
        if (numbers.size() > 1) {
            Collections.sort(numbers, Collections.reverseOrder());
            result = numbers.get(0) * numbers.get(1);
        }

        return result;
    }

    public static int rollCake(int[] topping) {
        int answer = 0;
        int[] left = new int[10001], right = new int[10001];
        int ls = 0, rs = 0;
        for(var i : topping) right[i]++;
        for(var i : right) rs += i > 0 ? 1 : 0;
        for(var i : topping) {
            right[i]--;
            if (right[i] == 0) rs--;
            if (left[i] == 0) ls++;
            left[i]++;
            if (rs == ls) answer++;
        }
        return answer;
    }

    public static int fatigue(int k, int[][] dungeons) {
        return dfs(k, dungeons);
    }

    private static int dfs(int k, int[][] dungeons) {
        int cnt = 0;
        for(int[] d: dungeons) {
            int a = d[0];
            int b = d[1];
            if (a <= k) {
                d[0] = 9999;
                cnt = Math.max(1 + dfs(k - b, dungeons), cnt);
                d[0] = a;
            }
        }
        return cnt;
    }

	public static int electronic(int n, int[][] wires) {
		int result = 1;
		return result;
	}

	public static long seesaw(int[] weights) {
		long answer = 0;

        int[] weightCounter = new int[1001];

        for (int weight : weights)
            weightCounter[weight]++;

        for (int weight = 100; weight <= 1000; weight++) {

            long cnt = weightCounter[weight];

            if (cnt == 0)
                continue;

            answer += cnt * (cnt - 1) / 2;

            if (weight * 3 % 2 == 0 && weight * 3 / 2 <= 1000) {
                answer += cnt * weightCounter[weight * 3 / 2];
            }

            if (weight * 4 % 2 == 0 && weight * 4 / 2 <= 1000) {
                answer += cnt * weightCounter[weight * 4 / 2];
            }

            if (weight * 4 % 3 == 0 && weight * 4 / 3 <= 1000) {
                answer += cnt * weightCounter[weight * 4 / 3];
            }

        }

        return answer;
	}

	public static int discount(String[] want, int[] number, String[] discount) {
		int init = 10;
		int discountCnt = discount.length;
		int result = 0;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < want.length; i++) {
			map.put(want[i], number[i]);
		}
		
		for (int i = 0; i <= discountCnt - init; i++) {
			Map<String, Integer> tempMap = new HashMap<>();
			tempMap.putAll(map);
			for (int j = i; j < i + init; j++) {
				if (tempMap.containsKey(discount[j])) {
					tempMap.put(discount[j], tempMap.get(discount[j]) - 1);
				} else {
					break;
				}
			}
			
			int valueCount = tempMap.values().stream().filter(m -> m > 0).findAny().orElse(0); 
			if (valueCount == 0) {
				result++;
			}
		}
		
		return result;
	}

	public static int dynamic(int N, int number) {
		int answer = -1;
		// 최대 8개까지만 구함
        Set<Integer>[] setArr = new Set[9];
        int t = N;
        // 초기값 설정
        for(int i = 1; i < 9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t);
            t = t * 10 + N;
        }
        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
            	// 각 자리수 마다 가능한 조합 저장
                for(Integer a : setArr[j]) {
                    for(Integer b : setArr[i - j]) {
                        setArr[i].add(a + b);
                        setArr[i].add(a - b);
                        setArr[i].add(b - a);
                        setArr[i].add(a * b);
                        if(b != 0) {
                            setArr[i].add(a / b);
                        }
                        if(a != 0) {
                            setArr[i].add(b / a);
                        }
                    }
                }
            }
        }
        for(int i = 1; i < 9; i++) {
        	// 최소 사용 개수 찾기
            if(setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
	}

	public static int triangle(int[][] triangle) {
		int result = 0;
        int fullSize = triangle.length;
        int[][] temp = new int[fullSize][fullSize];
        temp[0][0] = triangle[0][0];
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length -1; j++) {
                temp[i][j] = Math.max(temp[i][j] ,temp[i -1][j] + triangle[i][j]);
                temp[i][j+1] = temp[i-1][j] + triangle[i][j +1];
            }
        }

        for (int i = 0; i < fullSize; i++) {
            result = Math.max(result, temp[fullSize - 1][i]);
        }

        return result;
	}

	public static int triangle2(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++) 
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
	}

	/**
	 * https://0713k.tistory.com/35
	 */
	public static int goSchool(int m, int n, int[][] puddles) {
		int def = 1000000007;
		int result = 0;
		int[][] road = new int[n+1][m+1];
		
		for (int[] x : puddles) {
			road[x[1]][x[0]] = -1;
		}
		
		for (int i = 2; i <= n; i++) {
			road[i][1] = ( road[i][1] == -1 || road[i -1][1] == -1 ) ? -1 : 1;
		}
		
		for (int i = 2; i <= m; i++) {
			road[1][i] = (road[1][i] == -1 || road[1][i -1] == -1) ? -1 : 1;
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= m; j++) {
				if (road[i][j] != -1) {
					int top = road[i -1][j] == -1 ? 0 : road[i -1][j];
					int left = road[i][j -1] == -1 ? 0 : road[i][j -1];
					road[i][j] = (top + left) == 0 ? -1 : (top + left) % def;
				}
			}
		}
		
		result = road[n][m] == -1 ? 0 : road[n][m];
		
		return result;
	}

	public static int operations(String[] arr) {
		int n = (arr.length / 2) + 1;
	    int[][][] DP = new int[n][n][2];

	    for(int i = 0; i < n; i++) {
	        DP[i][i][0] = Integer.parseInt(arr[2 * i]);
	        DP[i][i][1] = Integer.parseInt(arr[2 * i]);
	    }

	    for(int gap = 1; gap < n; gap++) {
	        for(int start = 0; start < n - gap; start++) {
	            int end = start + gap;
	            int maxValue = Integer.MIN_VALUE;
	            int minValue = Integer.MAX_VALUE;
	            for(int mid = start; mid < end; mid++) {
	                String op = arr[2 * mid + 1];
	                if(op.equals("+")) {
	                    maxValue = Math.max(maxValue, DP[start][mid][0] + DP[mid + 1][end][0]);
	                    minValue = Math.min(minValue, DP[start][mid][1] + DP[mid + 1][end][1]);                     
	                } else {
	                    maxValue = Math.max(maxValue, DP[start][mid][0] - DP[mid + 1][end][1]);
	                    minValue = Math.min(minValue, DP[start][mid][1] - DP[mid + 1][end][0]);
	                }
	            }
	            DP[start][end][0] = maxValue;
	            DP[start][end][1] = minValue;
	        }
	    }

	    return DP[0][n - 1][0];
	}

	public static int selec(int k, int[] tangerine) {
		int result = 0;
		int selecCount = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int tan : tangerine) {
			map.put(tan, map.getOrDefault(tan, 0) + 1);
		}
		List<Integer> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
		for(Integer key : keySetList) {
			if (selecCount < k) {
				selecCount += map.get(key);
				result++;
			} else {
				break;
			}
		}
		
		return result;
	}

	public static int sortRoad(int[][] maps) {
		int[][] check = new int[maps.length][maps[0].length];
		//하나씩 체크할 것 구현예정
		return check.length;
	}

	public static int minimumWord(String t, String p) {
		long def = Long.parseLong(p);
		int defLength = p.length();
		int result = 0;
		
		for (int i = 0; i <= t.length() - defLength; i++) {
			if (Long.parseLong(t.substring(i, i + defLength)) <= def) {
				result++;
			}
		}
		
		return result;
	}

	public static int nextNumber(int n) {
		int result = n;
		int binaryCount = changeBinary(n);
		int maxCount = 0;
		while(binaryCount != maxCount) {
			result++;
			maxCount = changeBinary(result);
		}
		return result;
	}

	private static int changeBinary(int n) {
		int temp = n;
		int result = 0;
		while(temp > 1) {
			int division = temp % 2;
			temp = temp / 2;
			if (division == 1) {
				result++;
			}
		}
		return result;
	}

	// 참고 https://www.buggybread.com/2015/03/error-javatimeformatdatetimeparseexcept.html
	// 스택으로 풀기 https://school.programmers.co.kr/questions/46633
	public static String[] homework(String[][] plans) {
		String[] result = new String[plans.length];
		Map<String, LocalDateTime> map = new HashMap<>();
		for (int i = 0; i < plans.length; i++) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
			LocalDateTime time = LocalDateTime.parse(plans[i][1], format);
			time.plusMinutes(Long.parseLong(plans[i][2]));
			map.put(plans[i][0], time);
		}
		List<String> listKey = new ArrayList<>(map.keySet());
		Collections.sort(listKey, (val1, val2) -> map.get(val1).compareTo(map.get(val2)));
		int cnt = 0;
		for (String key : listKey) {
			result[cnt] = key;
			cnt++;
		}
		return result;
	}
	
	// 해설
	class Homework {
        String name;
        int start, playtime;
        public Homework(String name, String start, String playtime){
            this.name = name;
            this.start = parseTime(start);
            this.playtime = Integer.parseInt(playtime);
        }
        // 시간을 분으로 변경
        private int parseTime(String time){
            String[] t = time.split(":");
            return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }
    }
	public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Queue<Homework> remain = new PriorityQueue<>((h1, h2) -> h1.start - h2.start);
        Deque<Homework> task = new ArrayDeque<>();
        for(String[] plan : plans){
            remain.offer(new Homework(plan[0], plan[1], plan[2]));
        }
        int currTime = remain.peek().start;
        task.add(remain.poll());
        while(!remain.isEmpty()){
            Homework next;
            if(remain.peek().start < currTime+task.peekLast().playtime){
                // 새 과제 시작전에 진행중인 작업을 끝내지 못함
                next = remain.poll();
                task.peekLast().playtime -= next.start - currTime;
                currTime = next.start;
                task.add(next);
            }
            else{
                // 진행중인 작업 끝
                currTime += task.peekLast().playtime;
                answer.add(task.pollLast().name);
            }
            if(task.isEmpty()) {
                currTime = remain.peek().start;
                task.add(remain.poll());
            }
        }
        while(!task.isEmpty()){
            answer.add(task.pollLast().name);
        }
        return answer.toArray(String[]::new);
    }

	public static int[] nextMaxNumber(int[] numbers) {
		int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i = 1; i < numbers.length; i++){
            while(!s.isEmpty()){
                int idx = s.pop();
                if(numbers[i] > numbers[idx]){ // 뒤가 더 클때
                    answer[idx] = numbers[i];
                } else { // 앞이 더 크거나 같을 때 큰 값이 있는 값은 스택에 계속 담아서 이동
                    s.push(idx);
                    break;
                } 
            }
            s.push(i);
        }

        return answer;
	}

	public static int bookSystem(String[][] book_time) {
        // [입실시간, 정리완료시간] 을 넣을 int 2차배열 생성 및 값 주입
        int[][] bookTime = new int[book_time.length][];
        for (int i = 0; i < book_time.length; i++) {
            bookTime[i] = new int[] { parseTime(book_time[i][0]), parseTime(book_time[i][1]) + 10 };
        }

        // 입실시간 오름차순 정렬
        Arrays.sort(bookTime, (a, b) -> a[0] - b[0]);

        // 현재 이용중인 방의 퇴실시간정보 사용을 위해 퇴실시간 min-heap 선언
        PriorityQueue<int[]> inUse = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int ans = 0;

        for (int i = 0; i < bookTime.length; i++) {

            // 다음입실시간 까지 정리가 완료되는방 poll처리
            while (!inUse.isEmpty() && inUse.peek()[1] <= bookTime[i][0]) {
                inUse.poll();
            }
            inUse.add(bookTime[i]);
            ans = Math.max(ans, inUse.size());
        }
        return ans;
    }

    // time String을 int값으로 변환
    public static int parseTime(String time) {
        String[] hhmm = time.split(":");
        int hour = Integer.parseInt(hhmm[0]), min = Integer.parseInt(hhmm[1]);
        return hour * 60 + min;
    }
}

