package com.personal.book;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.as;
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

    @Test
    public void test1() {
        assertThat(book.a(new String[] {"abcd", "abcde", "bgtrfd"})).isEqualTo("ABCDE");
        assertThat(book.a(new String[] {"abcd", "abcd", "rfd"})).isEqualTo("없음");
    }

    @Test
    public void test2() {
        assertThat(book.b(new String[] {"a", "b", "c"}, new String[] {"b", "c", "d"})).isEqualTo("b,c");
        assertThat(book.b(new String[] {"a", "b", "b"}, new String[] {"b", "c", "d"})).isEqualTo("b");
    }

    @Test
    public void test3() {
        assertThat(book.c(new String[] {"123456789,유기농,50000", "234578882,숟가락,3000"}, new String[]{"20220810,123456789,5", "20220810,234578882,30"}))
                .isEqualTo(new String[] {"20220810,123456789,유기농,250000", "20220810,234578882,숟가락,90000"});
    }

    @Test
    public void test4() {
        assertThat(book.d(new int[]{1,3,2,5,3,1})).isEqualTo(new int[]{2,5});
    }

    @Test
    public void test5() {
        assertThat(book.e("/payment/1234/cancel")).isEqualTo("/payment/cancel?paymentId=1234");
        assertThat(book.e("/payment/1234")).isEqualTo("ERROR");
//        assertThat(book.e("/payment")).isEqualTo("/payment/cancel?paymentId=1234");
    }
}