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

    @Test
    public void canto() {
        assertThat(answer.canto(4, 30, 118)).isEqualTo(39);
    }

    @Test
    public void defence() {
        //assertThat(answer.defence(7, 3, new int[] {4, 2, 4, 5, 3, 3, 1})).isEqualTo(5);
        assertThat(answer.defence2(7, 3, new int[] {4, 2, 4, 5, 3, 3, 1})).isEqualTo(5);

    }

    @Test
    public void delivery() {
        assertThat(answer.delivery(new int[] {4, 3, 1, 2, 5})).isEqualTo(2);
    }

}