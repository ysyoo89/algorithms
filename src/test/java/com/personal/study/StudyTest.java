package com.personal.study;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StudyTest {

    private Study study;

    @Before
    public void init() {
        study = new Study();
    }

    @Test
    public void numberSum() {
        assertThat(study.numberSum(11, "10987654321")).isEqualTo(46);
    }

    @Test
    public void average() {
        assertThat(study.average(3, new int[] {10,20,30})).isEqualTo(66.66666666666667);
    }

    @Test
    public void particleSum() {
        assertThat(study.particleSum(5, new int[] {5,4,3,2,1}, new int[][] {{1, 3},{2, 4}, {5,5}})).isEqualTo(new long[] {12,9,1});
    }

    @Test
    public void twoPointer() {
        assertThat(study.twoPointer(15)).isEqualTo(4);
    }

    @Test
    public void armor() {
        assertThat(study.armor(6, 9, new int[] {2,3,4,1,7,5})).isEqualTo(2);
    }

    @Test
    public void dnaPassword() {
        assertThat(study.dnaPassword(2, new char[]{'G','A','T','A'}, new int[] {1,0, 0, 1})).isEqualTo(2);
    }

    @Test
    public void card() {
        assertThat(study.card(6)).isEqualTo(4);
    }

    @Test
    public void dfs() {
        assertThat(study.dfs(6, 5, new int[][] {{1,2}, {2,5}, {5,1}, {3,4}, {4,6}})).isEqualTo(2);
        assertThat(study.dfs(6, 8, new int[][] {{1,2}, {2,5}, {5,1}, {3,4}, {4,6}, {5,4}, {2,4}, {2,3}})).isEqualTo(1);
    }

    @Test
    public void bfs() {
        assertThat(study.bfs(new int[]{4, 6},new int[][] {{1,1,0,1,1,0}, {1,1,0,1,1,0}, {1,1,1,1,1,1}, {1,1,1,1,0,1}})).isEqualTo(9);
    }

    @Test
    public void binary() {
        assertThat(study.binary(new int[]{4,1,2,7,5}, new int[] {1,3,5,7,6})).isEqualTo(new int[]{1,0,1,1,0});
    }

    @Test
    public void greed2() {
        assertThat(study.greed2("100-40+50+74-30+29-45+43+11")).isEqualTo(-222);
    }

    @Test
    public void decimal() {
        assertThat(study.decimal(3, 16)).isEqualTo(new int[] {3, 5, 7, 11, 13});
    }

    @Test
    public void gcd() {
        assertThat(study.gcd(270, 192)).isEqualTo(6);
    }

    @Test
    public void union() {
        assertThat(study.union(7, new int[][] {{0,1,3}, {1,1,7}, {0,7,6}, {1,7,1}, {0,3,7},{0,4,2}, {0,1,1},{1,1,1}}))
                .isEqualTo(new String[] {"NO", "NO", "YES"});
    }

    @Test
    public void sort() {
        assertThat(study.sort(4, 2, new int[][] {{4,2}, {3,1}})).isEqualTo(new int[] {3, 4, 1, 2});
    }

    @Test
    public void dp() {
       // assertThat(study.dp(9)).isEqualTo(55L);
        assertThat(study.dp2(9)).isEqualTo(55L);
    }

    @Test
    public void tree() {
        assertThat(study.tree(7, new int[][] {{1,6},{6,3}, {3,5}, {4,1},{2,4}, {4,7}})).isEqualTo(new int[] {4,6,1,3,1,4});
    }

    @Test
    public void combination() {
        assertThat(study.combination(6, 3)).isEqualTo(20);
    }
}