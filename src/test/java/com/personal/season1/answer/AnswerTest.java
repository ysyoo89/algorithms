package com.personal.season1.answer;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    private Answer answer;

    @Before
    public void init() {
        answer = new Answer();
    }
    @Test
    public void magicStone() {
        //assertThat(answer.magicStone(646)).isEqualTo(13);
        assertThat(answer.magicStoneEtc(646)).isEqualTo(13);
    }

}