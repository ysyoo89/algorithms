package com.personal.programmers.answer;

import com.personal.programmers.question.ProgrammersQuestion;
import com.personal.programmers.question.ProgrammersQuestionLevel2;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.Before;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProgrammersAnswerTest {

    @Test
    void race() {
        ProgrammersQuestion question = new ProgrammersQuestion();
        assertThat(question.race()).isEqualTo(new String[] {"mumu", "kai", "mine", "soe", "poe"});
    }

    @Test
    void defense() {
        ProgrammersQuestionLevel2 questionLevel2 = new ProgrammersQuestionLevel2();
        assertThat(questionLevel2.defense()).isEqualTo(3);
    }
}