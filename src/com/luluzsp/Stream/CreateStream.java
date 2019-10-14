package com.luluzsp.Stream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/10/9 14:51
 * @description：创建Stream的方法
 * @modified By：
 * @version:
 */
public class CreateStream {

    /**
     * @Author: luluzsp
     * @Description:通过Stream的静态方法创建
     * @Date: 15:23 2019/10/9
     * @return: void
     * @Version: 1.0
     */
    @Test
    public void BuildStream(){
        Stream stream = Stream.builder().add(1).add(2).build();
        Stream stream1 = Stream.of(1,2,3,4,5);
        stream.forEach(System.out::println);
        stream1.forEach(System.out::println);
    }



}
