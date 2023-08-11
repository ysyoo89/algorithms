package com.personal.book;

public class Book {

    public boolean palindromeNumber(int number) {
        if (number < 0) {
            return false;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(number);

        return builder.equals(builder.reverse()) ? true : false;
    }
}
