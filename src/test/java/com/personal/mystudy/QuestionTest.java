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

    @Test
    public void capet() {
        assertThat(question.capet()).isEqualTo(new int[] {24, 3});
    }

    @Test
    public void electronic() {
        assertThat(question.electronic()).isEqualTo(0);
    }

    @Test
    public void openChat() {
        assertThat(question.openChat()).isEqualTo(new String[] {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."});
    }
}