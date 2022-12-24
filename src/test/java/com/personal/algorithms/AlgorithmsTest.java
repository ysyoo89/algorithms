package com.personal.algorithms;

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
}
