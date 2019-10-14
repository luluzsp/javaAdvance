package com.luluzsp.lambda;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/10/8 12:00
 * @description：DemoTest
 * @modified By：
 * @version:
 */
public class DemoTest {

    /**
     * @Author: luluzsp
     * @Description:  匿名内部类实现comparator接口
     * @Date: 12:17 2019/10/8
     * @return: void
     * @Version: 1.0
     */
    public  void test(){
        Comparator <String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        TreeSet<String> treeSet = new TreeSet<String>(comparator);
    }


    /**
     * @Author: luluzsp
     * @Description: lambda表达式实现comparator接口
     * @Date: 13:54 2019/10/8
     * @return: void
     * @Version: 1.0
     */
    public  void  test2(){
        Comparator<String> comparator = (x,y) -> Integer.compare(x.length(),y.length());
        TreeSet<String>    treeSet = new TreeSet<String>(comparator);
    }
}
