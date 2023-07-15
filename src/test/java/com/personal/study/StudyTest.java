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

}