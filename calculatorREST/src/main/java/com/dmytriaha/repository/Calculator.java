package com.dmytriaha.repository;

import com.dmytriaha.model.Calculation;

public interface Calculator {
    Calculation add(Integer a, Integer b, Integer c);
    Calculation add(Integer a, Integer b);

    Calculation subtract(Integer a, Integer b, Integer c);
    Calculation subtract(Integer a, Integer b);

    Calculation multiply(Integer a, Integer b, Integer c);
    Calculation multiply(Integer a, Integer b);

    Calculation divide(Integer a, Integer b, Integer c);
    Calculation divide(Integer a, Integer b);
}
