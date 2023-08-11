package com.personal.book;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    private Book book;
    private BookCommentary bookCommentary;
    @Before
    public void init() {
        book = new Book();
        bookCommentary = new BookCommentary();
    }
    @Test
    public void palindrome() {
        assertThat(book.palindromeNumber(123321)).isEqualTo(true);
        assertThat(bookCommentary.palindromeNumber(123321)).isEqualTo(true);
    }
}