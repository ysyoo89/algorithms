package com.personal.algorithms;

import com.personal.programmers.question.ProgrammersQuestion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AlgorithmsTest {

    @Test
    void answer() {
        ProgrammersQuestion question = new ProgrammersQuestion();
        assertEquals(question.changeNumberLevel2(), "41") ;
    }
}
