package com.personal.mystudy;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionTest {

    private Question question;

    @Before
    public void init() {
        question = new Question();
    }

    @Test
    public void game() {
        assertThat(question.game()).isEqualTo("0111");
    }
}