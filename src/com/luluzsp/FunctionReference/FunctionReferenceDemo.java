package com.luluzsp.FunctionReference;

import com.luluzsp.lambda.Person;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/10/9 11:16
 * @description：Lambda表达式的方法引用
 * @modified By：
 * @version:
 */
public class FunctionReferenceDemo {

    /**
     * @Author: luluzsp
     * @Description: lambda表达式引用静态方法
     * @Date: 11:24 2019/10/9
     * @return: void
     * @Version: 1.0
     */
    public void  test(){
        Function <String,Integer> func = Integer::parseInt;
        Integer num = func.apply("123");
        System.out.println(num);
    }


    /**
     * @Author: luluzsp
     * @Description: lambda表达式引用实例方法
     * @Date: 11:27 2019/10/9
     * @return: void
     * @Version: 1.0
     */
    @Test
    public void test2(){
        Person person = new Person("张向静",27,8888);
        Supplier<String> supplier = person::getName;
        String name = supplier.get();
        System.out.println(name);
    }


    /**
     * @Author: luluzsp
     * @Description: lambda表达式引用内的构造方法
     * @Date: 11:37 2019/10/9
     * @return: void
     * @Version: 1.0
     */
    public void test3(){
        Supplier<Person> supplier = Person::new;
        Person person = supplier.get();
    }

    @Test
    public  void test4(){
        Function<Integer,String[]> func = String[]::new;
       String[] strs =  func.apply(10);
        System.out.println(strs.length);
    }
}
