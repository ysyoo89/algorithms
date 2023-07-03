package com.personal.programmers.answer;

import com.personal.programmers.question.ProgrammersQuestion;
import com.personal.programmers.question.ProgrammersQuestionLevel2;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.Before;

import static org.assertj.core.api.Assertions.as;
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

    @Test
    void test() {
        ProgrammersAnswer answer = new ProgrammersAnswer();
        String[] test = {"abc", "yyy", "def", "csv"};
        assertThat(answer.solution(test)).isEqualTo(6);
    }

    @Test
    void solution() {
        ProgrammersAnswer answer = new ProgrammersAnswer();
        int[] test = {-1, -1, -1, 1,1,1,1};
        int[] test2 = {5, -2, -3, 1};
        int[] test3 = {10, -10, -1, -1, 10};
        int[] test4 = {3, -1, -1, -2, 1, 3};
        assertThat(answer.solution2(test4)).isEqualTo(1);
    }

    @Test
    void so() {
        ProgrammersAnswer answer = new ProgrammersAnswer();
        int[] test = {1,2,2,4};
        int[] test2 = {5, -2, -3, 1};
        int[] test3 = {10, -10, -1, -1, 10};
        int[] test4 = {3, -1, -1, -2, 1, 3};
        assertThat(answer.solution3(test)).isEqualTo(4);
    }
}