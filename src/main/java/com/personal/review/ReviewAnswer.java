package com.personal.review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReviewAnswer {
    public int[] repeatNumber(int[] sequence, int k) {
        int x = 0;
        int y = 0;
        List<Number> list = new ArrayList<>();
        int sum = sequence[x];
        int size = sequence.length;
        while(true) {
            if (sum == k) {
                list.add(new Number(x, y));
            }

            if (x == size && y == size) {
                break;
            }

            if (sum < k && y < size) {
                y++;
                if (y < size) {
                    sum += sequence[y];
                }
            } else {
                if (x < size) {
                    sum -= sequence[x];
                }
                x++;
            }
        }
        list.sort(Number::compareTo);
        return new int[] {list.get(0).x, list.get(0).y};
    }
    class Number implements Comparable<Number>{
        int x;
        int y;
        int size;
        public Number(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = y - x;
        }

        @Override
        public int compareTo(Number o) {
            if (this.size == o.size) {
                return this.x - o.x;
            }
            return this.size - o.size;
        }
    }

    public int robot(String[] board) {
        int n = board.length;
        int m = board[0].length();
        Moving start = null;
        Moving goal = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ('R' == board[i].charAt(j)) {
                    start = new Moving(i, j, 0);
                }else if ('G' == board[i].charAt(j)) {
                    goal = new Moving(i, j, 0);
                }
            }
        }

        return robotBfs(board, start, goal, n, m);
    }

    private int robotBfs(String[] board, Moving start, Moving goal, int n, int m) {
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, 1, -1};
        Queue<Moving> que = new LinkedList<>();
        que.add(start);
        boolean[][] visited = new boolean[n][m];

        while (!que.isEmpty()) {
            Moving cn = que.poll();

            if (cn.x == goal.x && cn.y == goal.y) {
                return cn.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cn.x;
                int ny = cn.y;

                while(isRange(nx, ny, n, m) && 'D' != board[nx].charAt(ny)) {
                    nx += x[i];
                    ny += y[i];
                }

                nx -= x[i];
                ny -= y[i];
                if (visited[nx][ny] || (cn.x == nx && cn.y == ny)) {
                    continue;
                }

                visited[nx][ny] = true;
                que.add(new Moving(nx, ny, cn.depth + 1));
            }
        }

        return -1;
    }

    private boolean isRange(int x, int y, int n, int m) {
        return x >= 0 && y >=0 && x < n && y < m;
    }

    class Moving {
        int x;
        int y;
        int depth;
        public Moving(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int tictactoe(String[] board) {
        int o = 0;
        int x = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                char temp = board[i].charAt(j);
                if ('O' == temp) {
                    o++;
                } else if ('X' == temp) {
                    x++;
                }
            }
        }

        if (o - x < 0 || o - x > 1) {
            return 0;
        }

        if (o >= 3) {
            if (isEnd(board, 'O')) {
                if (isEnd(board, 'X')) {
                    return 0;
                }
                if (o - x == 1) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        if (x >= 3) {
            if (isEnd(board, 'X')) {
                if (o - x == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        return 1;
    }

    private boolean isEnd(String[] board, char x) {
        for (int i= 0; i < board.length; i++) {
            boolean width = true;
            boolean length = true;
            for (int j = 0; j < board[0].length(); j++) {
                if (x != board[i].charAt(j)) {
                    width = false;
                }
                if (x != board[j].charAt(i)) {
                    length = false;
                }
            }
            if (width) {
                return true;
            }
            if (length) {
                return true;
            }
        }

        if (x == board[0].charAt(0) && x == board[1].charAt(1) && x == board[2].charAt(2)) {
            return true;
        } else if (x == board[0].charAt(2) && x == board[1].charAt(1) && x == board[2].charAt(0)) {
            return true;
        }

        return false;
    }
}
