package com.luluzsp.functionalInterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/10/9 8:49
 * @description：Java内置四大内置函数式接口
 * @modified By：
 * @version:
 */
public class FunctionDemo {

    /**
     * @Author: luluzsp
     * @Description: Function函数式接口
     * @Date: 8:53 2019/10/9
     * @param str
     * @param func
     * @return: int
     * @Version: 1.0
     */
    public int  handleString(String str, Function<String,Integer> func){

        int length =  func.apply(str);
        System.out.println(length);
        return length;
    }


    /**
     * @Author: luluzsp
     * @Description: 通过function函数式接口,获取字符串的长度
     * @Date: 8:56 2019/10/9
     * @return: void
     * @Version: 1.0
     */

    @Test
    public  void functionTest(){
        this.handleString("luluzsp",e->e.length());

    }


    /**
     * @Author: luluzsp
     * @Description:根据传入的规则产生数字
     * @Date: 9:42 2019/10/9
     * @param num
     * @param sup
     * @return: java.util.List<java.lang.Integer>
     * @Version: 1.0
     */
    public ArrayList<Integer> CreateNumber(int num, Supplier<Integer> sup){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int number = sup.get();
            list.add(number);
        }
        return list;
    }


    /**
     * @Author: luluzsp
     * @Description: 测试CreateNumber方法,传入生成随机数的方法.
     * @Date: 9:50 2019/10/9
     * @return: void
     * @Version: 1.0
     */
    @Test
    public void  CreateRandomNumber(){
       ArrayList<Integer> list =  this.CreateNumber(10,()->(int)(Math.random()*100));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * @Author: luluzsp
     * @Description: Consumer接口
     * @Date: 9:56 2019/10/9
     * @param str
     * @param consumer
     * @return: void
     * @Version: 1.0
     */
    public void printNumber(String str, Consumer<String> consumer){
        consumer.accept(str);
    }


    @Test
    public  void  testPrintNumber(){
        this.printNumber("张向静",e -> System.out.println("我爱"+e));
    }


    /**
     * @Author: luluzsp
     * @Description: 练习Predicate接口
     * @Date: 10:15 2019/10/9
     * @param list
     * @param predicate
     * @return: java.lang.Integer
     * @Version: 1.0
     */
    public Integer  calculate(List<Integer> list, Predicate<Integer> predicate){
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
             if(predicate.test(temp)){
                 sum = sum+temp;
             }
        }

        return sum;
    }

    @Test
    public  void  testCalculate(){

        List<Integer> list = Arrays.asList(1,3,4,5,8,23,34,79);
        int sum = this.calculate(list,x -> x%2==0?true:false);
        System.out.println("总和为:"+sum);
    }


}
