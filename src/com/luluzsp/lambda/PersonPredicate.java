package com.luluzsp.lambda;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/10/8 14:56
 * @description：筛选Person的策略模式
 * @modified By：
 * @version:
 */
public class PersonPredicate implements MyPredicate<Person> {
    @Override
    public boolean check(Person person) {
        return false;
    }
}
