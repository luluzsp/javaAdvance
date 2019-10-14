package com.luluzsp.lambda;

public interface Calculation<T,R> {

    public R  calculate(T t1, T t2);
}
