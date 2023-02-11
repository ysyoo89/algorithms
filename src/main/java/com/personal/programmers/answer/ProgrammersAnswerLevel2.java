package com.personal.programmers.answer;

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
}

