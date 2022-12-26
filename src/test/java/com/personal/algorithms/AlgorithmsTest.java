package com.personal.algorithms;

import com.personal.programmers.answer.ProgrammersAnswerLevel2;
import com.personal.programmers.question.ProgrammersQuestionLevel2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AlgorithmsTest {

    @Test
    void answer() {
        ProgrammersQuestionLevel2 question = new ProgrammersQuestionLevel2();
        assertEquals(question.changeNumberLevel2(), "41") ;
    }

    @Test
    void lineSort() {
        ProgrammersQuestionLevel2 question = new ProgrammersQuestionLevel2();
        int[] n = {3, 1, 2};
        assertEquals(question.lineSort()[0], 3) ;
        assertEquals(question.lineSort()[1], 1) ;
        assertEquals(question.lineSort()[2], 2) ;
    }

    @Test
    void solution() {
        ProgrammersAnswerLevel2 answerLevel2 = new ProgrammersAnswerLevel2();
        int n = 6;
        assertEquals(answerLevel2.solution(n), 13);
    }

    @Test
    void test() {
        ProgrammersAnswerLevel2 answerLevel2 = new ProgrammersAnswerLevel2();
        int[][] office = {{1,0,0,0}, {0,0,0,1}, {0,0,1,0}, {0,1,1,0}};
        int k = 2;
        assertEquals(answerLevel2.solve(office, k), 3);
    }
}
