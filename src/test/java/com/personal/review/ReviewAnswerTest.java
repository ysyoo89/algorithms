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

}