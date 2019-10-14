package com.luluzsp.Stream;

import com.luluzsp.lambda.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/10/9 13:11
 * @description：Stream学习
 * @modified By：
 * @version:
 */
public class StreamOperation {

    List<Person> personList = Arrays.asList(new Person("张三",24,5000),
            new Person("李四",24,5200),
            new Person("王五",22,5000),
            new Person("张柳",25,6000),
            new Person("奇八",28,7000),
            new Person("Tony",26,8200),
            new Person("jackie",27,7300),
            new Person("duke",28,8800),
            new Person("flight",30,7800)
    );


    /**
     * @Author: luluzsp
     * @Description: 输出年龄大于25的人的工资
     * @Date: 16:08 2019/10/9
     * @return: void
     * @Version: 1.0
     */
    @Test
    public  void  StreamHandle(){
        personList.stream().filter(person ->person.getAge()>25).map(Person::getSalary).forEach(System.out::println);
    }

    /**
     * @Author: luluzsp
     * @Description: 输出年龄大于25的人的名字,按照年龄排序,年龄相同按照工资
     * @Date: 16:31 2019/10/9
     * @return: void
     * @Version: 1.0
     */
    @Test
    public  void SortStream(){
        personList.stream().filter(person -> person.getAge()>25).sorted((p1,p2)->{
            if(p1.getAge()==p2.getAge()){
                return (int)(p1.getSalary()-p2.getSalary());
            }else{
                return p1.getAge()-p2.getAge();
            }
        }).map(Person::getName).forEach(System.out::println);
    }

    /**
     * @Author: luluzsp
     * @Description:将流重新汇集成另外一个集合
     * @Date: 18:55 2019/10/9
     * @return: void
     * @Version: 1.0
     */
    public  void CollectStream(){
        List<Double> list=personList.stream().filter(person ->person.getAge()>25).map(Person::getSalary).collect(Collectors.toList());
        personList.stream().filter(person ->person.getAge()>25).map(Person::getSalary).collect(Collectors.toCollection(TreeSet::new));
    }

    /**
     * @Author: luluzsp
     * @Description:
     * @Date: 19:25 2019/10/9
     * @return: void
     * @Version: 1.0
     */
    public  void  CountStream(){
        Stream<Person> stream = personList.stream().filter(person ->person.getAge()>25);
        long count = stream.collect(Collectors.counting());
        double SalarySum = stream.collect(Collectors.averagingDouble(Person::getSalary));
        DoubleSummaryStatistics statistics = stream.collect(Collectors.summarizingDouble(Person::getSalary));
        statistics.getAverage();
        statistics.getMax();
        statistics.getSum();

    }
}
