package com.study;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductTester {
    ProductLineTestReport test(Stream<Product> products) {
        Stream<Product> temp = products.skip(10).filter(p -> !(p == null && p.getStatus().equals("invalid"))).limit(20);
        long cor = temp.filter(p -> p.getStatus().equals("1")).count();
        return null;
    }
}
