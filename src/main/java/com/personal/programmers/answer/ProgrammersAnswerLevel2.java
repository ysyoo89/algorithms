package com.personal.programmers.answer;

import java.awt.*;
import java.rmi.MarshalledObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class ProgrammersAnswerLevel2 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static char ROBOT = 'R', DISABLE = 'D', GOAL = 'G';

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

    public static int fibo(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            result[i] = (result[i -1] + result[i - 2]) % 1234567;
        }

        return result[n];
    }

    public static int defense(int[][] targets) {
        int result = 0;

        Arrays.sort(targets, (o1, o2) -> (o1[1] - o2[1]));

        int end = targets[0][1];

        for(int[] target : targets) {
            int t_start = target[0];
            int t_end = target[1];

            if (end <= t_start) {
                end = t_end;
                result++;
            }
        }
        return result + 1;
    }

    public static long circle(int r1, int r2) {
        long answer = 0;


        long r1x = (long)Math.pow(r1,2);
        long r2x = (long)Math.pow(r2,2);

        //y^2= r^2-x^2

        long y1sum=0;
        long y2sum=0;
        long side =0;

        for(long i=0;i<=r2;i++){


            long y2 = (long)Math.sqrt(r2x-(long)Math.pow(i,2));

            long y1 = (long)Math.sqrt(r1x-(long)Math.pow(i,2));


            if(Math.sqrt((r1x-Math.pow(i,2)))%1==0){
                side++;
            }

            answer+=(y2-y1)*4;
        }

        answer+=side*4-4;

        return answer;
    }

    public static int[] numberSum(int[] sequence, int k) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            map.put(i, 0);
            for (int j = i; j < sequence.length; j++) {
                sum += sequence[j];
                if (sum == k) {
                    map.put(i, j);
                    break;
                } else if (sum > k) {
                    break;
                }
            }
            sum = 0;
        }
        int min = Integer.MAX_VALUE;

        for (int key : map.keySet()) {
            if (map.get(key) > 0 && map.get(key) - key < min) {
                answer[0] = key;
                answer[1] = map.get(key);
                min = map.get(key) - key;
            }
        }
        return answer;
    }

    public static int minecraft(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] pick = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        Map<String, Integer> work = new HashMap<>();
        work.put("diamond", 0);
        work.put("iron", 1);
        work.put("stone", 2);
        List<Mineral> list = new ArrayList<>();

        int pickSum = Arrays.stream(picks).sum();
        int count = 0;
        for(int i = 0; i < minerals.length / 5 + 1; i++) {
            // 곡괭이가 0개 이면
            if(pickSum == 0) {
                // 탈출
                break;
            }
            int diamondCount = 0;
            int ironCount = 0;
            int stoneCount = 0;
            for(int j = count; j < minerals.length; j++) {
                count++;
                String mineral = minerals[j];
                diamondCount += pick[0][work.get(mineral)];
                ironCount += pick[1][work.get(mineral)];
                stoneCount += pick[2][work.get(mineral)];

                // 5개씩 저장
                if(count % 5 == 0) {
                    // 곡괭이 1개 감소
                    pickSum--;
                    // 5개면 탈출~
                    break;
                }
            }
            list.add(new Mineral(diamondCount, ironCount, stoneCount));
        }

        Collections.sort(list, (o1, o2) -> Integer.compare(o2.getStone(), o1.getStone()));
        for (int i = 0; i < list.size(); i++) {
            if (picks[0] > 0) {
                answer += list.get(i).getDiamond();
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += list.get(i).getIron();
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += list.get(i).getStone();
                picks[2]--;
            }
        }


        return answer;
    }
    public static int robot(String[] board) {
        int n = board.length;
        int m = board[0].length();

        Moving robot = null;
        Moving goal = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = board[i].charAt(j);
                if (ch == ROBOT) {
                    robot = new Moving(i, j, 0);
                } else if (ch == GOAL) {
                    goal = new Moving(i, j, 0);
                }
            }
        }
        return robotBfs(board, robot, goal, n, m);
    }

    private static int robotBfs(String[] board, Moving robot, Moving goal, int n, int m) {
        Queue<Moving> queue = new LinkedList<>();
        queue.add(robot);
        boolean[][] visited = new boolean[n][m];
        visited[robot.x][robot.y] = true;
        while(!queue.isEmpty()) {
            Moving cn = queue.poll();

            if (cn.x == goal.x && cn.y == goal.y) {
                return cn.depth;
            }

            // 4방향으로 전부 이동 시킴
            for (int i = 0; i < 4; i++) {
                int nx = cn.x;
                int ny = cn.y;

                // 범위를 벗어나거나 장애물을 만나기 전까지 이동
                while(isRange(nx, ny, n, m) && board[nx].charAt(ny) != DISABLE) {
                    nx += dx[i];
                    ny += dy[i];
                }

                // 범위를 벗어나거나 장애물을 만나면 그 전으로 이동
                nx -= dx[i];
                ny -= dy[i];

                // 이미 방문한 곳이거나 현재와 같은 장소이면 스킵
                if (visited[nx][ny] || (cn.x == nx && cn.y == ny)) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new Moving(nx, ny, cn.depth +1));
            }
        }
        return -1;
    }

    private static boolean isRange(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public static int tictactoe(String[] board) {
        int answer = 1;
        int count = 0;
        boolean[][] markO = new boolean[board.length][board[0].length()];
        boolean[][] markX = new boolean[board.length][board[0].length()];
        char o = 'O';
        char x = 'X';
        for (int i = 0; i < board.length; i++) {
            for (int j = 0 ; j < board[0].length(); j++) {
                char mark = board[i].charAt(j);
                if (o == mark) {
                    markO[i][j] = true;
                    count++;
                } else if (x == mark) {
                    markX[i][j] = true;
                    count--;
                }
            }
        }

        if (count < 0 || count > 1) {
            answer = 0;
        } else if (count == 0 || count == 1) {
            answer = serialCheck(markO, markX);
        }

        return answer;
    }

    private static int serialCheck(boolean[][] markO, boolean[][] markX) {
        int countO = 0;
        int countX = 0;
        int totalCountO = 0;
        int totalCountX = 0;
        int[] markingO = new int[2];
        int[] markingX = new int[2];
        boolean finishO = false;
        boolean finishX = false;
        for (int i = 0; i < markO.length; i++) {
            for (int j = 0; j < markO[0].length; j++) {
                if (markO[i][j]) {
                    if (serial(markingO, i, j) || countO == 0) {
                        countO++;
                    } else {
                        countO--;
                    }
                    if (countO == 3) {
                        finishO = true;
                    }
                    markingO[0] = i;
                    markingO[1] = j;
                    totalCountO++;
                }

                if (markX[i][j]) {
                    if (serial(markingX, i, j) || countX == 0) {
                        countX++;
                    } else {
                        countX--;
                    }
                    if (countX == 3) {
                        finishX = true;
                    }
                    markingX[0] = i;
                    markingX[1] = j;
                    totalCountX++;
                }
            }
        }

        if (finishO && finishX) {
            return 0;
        } else if (finishO) {
            if (totalCountO - totalCountX != 1) {
                return 0;
            }
        } else if (finishX) {
            if (totalCountO - totalCountX != 0) {
                return 0;
            }
        }
        return 1;
    }

    private static boolean serial(int[] marking, int i, int j) {
        if (marking[0] == i && marking[1] + 1 == j) {
            return true;
        } else if (marking[0] + 1 == i && marking[1] + 1 == j) {
            return true;
        } else if (marking[0] + 1 == i && marking[1] == j) {
            return true;
        } else if ((marking[0] + 1 == i && marking[1] - 1 == j)
                && ((marking[0] == 0 && marking[1] == 2)
                    || (marking[0] == 1 && marking[1] == 1)) ) {
            return true;
        }
        return false;
    }

    public static int changeNumber(int x, int y, int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[y + 1];

        for (int i = x +1; i <= y; i++) {
            int a = i / 2 > 0 && i % 2 == 0 && x <= i / 2 ? dp[i / 2] : max;
            int b = i / 3 > 0 && i % 3 == 0 && x <= i / 3 ? dp[i / 3] : max;
            int c = i - n >= x ? dp[i-n] : max;
            int d = Math.min(c, Math.min(a, b));

            dp[i] = d < max ? d + 1: max;
        }

        return dp[y] < max ? dp[y] : -1;
    }

    public static int maze(String[] map) {
        int n = map.length;
        int m = map[0].length();
        Moving start = null;
        Moving goal = null;
        Moving lever = null;
        for (int i =0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ('S' == map[i].charAt(j)) {
                    start = new Moving(i, j, 0);
                }
                if ('L' == map[i].charAt(j)) {
                    lever = new Moving(i, j, 0);
                }
                if ('E' == map[i].charAt(j)) {
                    goal = new Moving(i, j, 0);
                }
            }
        }
        return mazeBfs(map, start, lever, goal, n, m);
    }

    private static int mazeBfs(String[] map, Moving start, Moving lever, Moving goal, int n, int m) {
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, 1, -1};
        Queue<Moving> que = new LinkedList<>();
        que.add(start);
        boolean[][] visited = new boolean[n][m];
        while (!que.isEmpty()) {
            Moving cn = que.poll();

            if (lever.x == cn.x && lever.y == cn.y) {
                que.clear();
                que.add(new Moving(cn.x, cn.y, cn.depth));
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cn.x + x[i];
                int ny = cn.y + y[i];
                if (isRange(nx, ny, n, m) && 'X' != map[nx].charAt(ny)) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        que.add(new Moving(nx, ny, cn.depth+1));
                    }
                }
            }
        }
        visited = new boolean[n][m];
        while (!que.isEmpty()) {
            Moving cn = que.poll();

            if (goal.x == cn.x && goal.y == cn.y) {
                return cn.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cn.x + x[i];
                int ny = cn.y + y[i];
                if (isRange(nx, ny, n, m) && 'X' != map[nx].charAt(ny)) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        que.add(new Moving(nx, ny, cn.depth+1));
                    }
                }
            }
        }

        return -1;
    }

    public static int[] island(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        List<Integer> list = new ArrayList<>();
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, 1, -1};
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    int result = maps[i].charAt(j) - '0';
                    Queue<Move> que = new LinkedList<>();
                    que.add(new Move(i, j));
                    while(!que.isEmpty()) {
                        Move cn = que.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cn.x + x[k];
                            int ny = cn.y + y[k];
                            if (!isRange(nx, ny, n, m) || 'X' == maps[nx].charAt(ny) || visited[nx][ny]) {
                                continue;
                            }
                            visited[nx][ny] = true;
                            que.add(new Move(nx, ny));
                            result += maps[nx].charAt(ny) - '0';
                        }
                    }
                    list.add(result);
                }
            }
        }
        if (list.isEmpty()) {
            return new int[] {-1};
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    static class Move {
        int x;
        int y;

        public Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Moving {
        int x;
        int y;
        int depth;

        public Moving(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    static class Mineral {
        int diamond;
        int iron;
        int stone;

        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }

        public int getDiamond() {
            return this.diamond;
        }

        public int getIron() {
            return this.iron;
        }

        public int getStone() {
            return this.stone;
        }

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

    public static String maxNumber(int[] numbers) {
        StringBuffer result = new StringBuffer();
        String arrayNumber[] = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            arrayNumber[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arrayNumber, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if (arrayNumber[0].equals("0")) {
            return "0";
        } else {
            for(int i = 0; i < arrayNumber.length; i++) {
                result.append(arrayNumber[i]);
            }
        }
        return result.toString();
    }

    public static int hIndex(int[] citations) {
        int result = 0;
        Arrays.sort(citations); // 정렬
        for (int i = 0; i < citations.length; i++) {
            int count = 0;
            if (citations[i] == 0) {
                continue;
            }
            for (int j = i; j < citations.length; j++) {
                if (citations[i] <= citations[j]) {
                    count++;
                }
            }
            if (count > citations[i]) {
                count = citations[i];
            }
            if (result < count) {
                result = count;
            }
        }
        return result;
    }

    public static int word(String word) {
        String[] words = {"A", "E", "I", "O", "U"};
        int answer = 0;
        List<String> elements = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            wordDfs(elements, words[i], words);
        }

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }

    private static void wordDfs(List<String> elements, String word, String[] words) {
        if (word.length() > 5) {
            return;
        }
        if (!elements.contains(word)) {
            elements.add(word);
        }
        for (int i = 0; i < words.length; i++) {
            wordDfs(elements, word + words[i], words);
        }
    }

    public static int[][] power(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }

    public static int queue(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long que1Sum = 0;
        long que2Sum = 0;
        for (int i = 0; i < queue1.length; i++) {
            que1.add(queue1[i]);
            que2.add(queue2[i]);
            que1Sum += queue1[i];
            que2Sum += queue2[i];
        }
        double standard = (que1Sum + que2Sum) / 2.0;

        if (standard != Math.floor(standard)) {
            return -1;
        }

        while(que1Sum != standard && que2Sum != standard) {
            if(que1Sum > standard) {
                int temp = que1.poll();
                que1Sum -= temp;
                que2.add(temp);
                que2Sum += temp;
                answer++;
            }

            if(que2Sum > standard) {
                int temp = que2.poll();
                que2Sum -= temp;
                que1.add(temp);
                que1Sum += temp;
                answer++;
            }

            if (que1.isEmpty() || que2.isEmpty() || answer > 2 * (queue1.length + queue2.length)) {
                answer = -1;
                break;
            }

        }
        return answer;
    }

    public static int[] codingTest(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            StringBuilder builder = new StringBuilder();
            builder.append(split[0].charAt(0));
            builder.append(split[1].charAt(0));
            builder.append(split[2].charAt(0));
            builder.append(split[3].charAt(0));
            List<Integer> score = new ArrayList<>();
            score.add(Integer.parseInt(split[4]));
            List<Integer> scoreMap = new ArrayList<>();
            scoreMap.addAll(map.getOrDefault(builder.toString(), new ArrayList<>()));
            scoreMap.addAll(score);
            map.put(builder.toString(), scoreMap);
        }

        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].split(" and ");
        }
        return answer;
    }

    public static int[] parking(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        StringTokenizer st;
        Map<String, Integer> ans = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));
        for (int i = 0; i < records.length; i++) {
            st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String number = st.nextToken();
            String type = st.nextToken();
            if ("IN".equals(type)) {
                map.put(number, time);
                continue;
            }
            int min = getMin(time, map.get(number));

            ans.put(number, ans.getOrDefault(number, 0) + min);
            map.remove(number);
        }

        if (!map.isEmpty()) {
            for (String number: map.keySet()) {
                int min = getMin("23:59", map.get(number));
                ans.put(number, ans.getOrDefault(number, 0) + min);
            }
        }
        return getAnswer(ans, fees);
    }

    private static int[] getAnswer(Map<String, Integer> ansMap, int[] fees) {
        List<Integer> ans = new ArrayList<>();
        for (String number: ansMap.keySet()) {
            int min = ansMap.get(number);
            int fee = 0;

            if (min <= fees[0]) {
                fee += fees[1];
            } else {
                fee += (((int) Math.ceil(((double) min - fees[0]) / fees[2])) * fees[3]) + fees[1];
            }
            ans.add(fee);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getMin(String outTime, String inTime) {
        StringTokenizer st = new StringTokenizer(outTime, ":");
        int o1 = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        st = new StringTokenizer(inTime, ":");
        int o2 = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        return o1 - o2;
    }

    public static int spin(String s) {
        int answer = 0;
        if (isProper(s)) {
            answer++;
        }

        for (int x = 1; x < s.length(); x++) {
            s = rotationBracket(s);
            if (isProper(s)) {
                answer++;
            }
        }

        return answer;
    }

    private static String rotationBracket(String s) {
        return s.substring(1) + s.charAt(0);
    }

    private static boolean isProper(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    switch (s.charAt(i)) {
                        case ']':
                            isProperBracket(stack, '[');
                            break;
                        case ')':
                            isProperBracket(stack, '(');
                            break;
                        case '}':
                            isProperBracket(stack, '{');
                            break;
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        return stack.isEmpty();
    }

    private static void isProperBracket(Stack<Character> stack, char bracket) {
        if (stack.peek() == bracket) {
            stack.pop();
        }
    }

}

