package com.personal.review;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReviewAnswerTest {

    @Test
    void reviewNumber() {
        ReviewAnswer answer = new ReviewAnswer();
        assertThat(answer.repeatNumber(new int[] {1, 2, 3, 4, 5}, 7)).isEqualTo(new int[] {2, 3});
    }

    @Test
    void number() {
        ReviewAnswer answer = new ReviewAnswer();
        assertThat(answer.number(10, 40, 5)).isEqualTo(2);
    }

    @Test
    void island() {
        ReviewAnswer answer = new ReviewAnswer();
        assertThat(answer.island(new String[] {"X591X","X1X5X","X231X", "1XXX1"})).isEqualTo(new int[] {1, 1, 27});
    }

}