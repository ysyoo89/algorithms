package com.study;

public class ProductLineTestReport {
    long correctCounter;
    long checkExcCounter;
    long uncheckedExcCounter;
    long otherExcCounter;

    ProductLineTestReport(long correctCounter, long checkExcCounter, long uncheckedExcCounter, long otherExcCounter) {
        this.correctCounter = correctCounter;
        this.checkExcCounter = checkExcCounter;
        this.uncheckedExcCounter = uncheckedExcCounter;
        this.otherExcCounter = otherExcCounter;
    }
}
