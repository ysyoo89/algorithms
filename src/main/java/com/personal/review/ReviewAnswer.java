package com.personal.review;

import java.util.ArrayList;
import java.util.List;

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
}
