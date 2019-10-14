package com.luluzsp.lambda;

import java.util.*;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/10/8 14:29
 * @description：Lambda引入案例
 * @modified By：
 * @version:
 */
public class LambdaIntroduction {

    List<Person> personList = Arrays.asList(new Person("张三",24,5000),
            new Person("李四",24,5200),
            new Person("王五",22,5000),
            new Person("张柳",25,6000),
            new Person("奇八",29,7000)
            );

    /**
     * @Author: luluzsp
     * @Description: 筛选薪资大于5000的人
     * @Date: 14:34 2019/10/8
     * @param personList
     * @return: void
     * @Version: 1.0
     */
    public  void filterPersonBySalary(List<Person> personList ){
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Person person : personList) {
            if(person.getSalary()>5000){
                arrayList.add(person.getName());
                System.out.println(person.getName());
            }
        }
    }

    /**
     * @Author: luluzsp
     * @Description:
     * @Date: 14:48 2019/10/8
     * @param personList
     * @return: void
     * @Version: 1.0
     */
    public  void filterPersonByAge(List<Person> personList ){
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Person person : personList) {
            if(person.getAge()>22){
                arrayList.add(person.getName());
                System.out.println(person.getName());
            }
        }
    }

    /**
     * @Author: luluzsp
     * @Description:  优化1 使用策略模式
     * @Date: 15:09 2019/10/8
     * @param persons
     * @param predicate
     * @return: void
     * @Version: 1.0
     */
    public void filterPersonByPredicate(List<Person> persons, MyPredicate<Person> predicate){
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Person person : persons) {
            if (predicate.check(person)){
                arrayList.add(person.getName());
                System.out.println(person.getName());
            }
        }

    }

    /**
     * @Author: luluzsp
     * @Description: 调用策略模式的方法( 匿名内部类的方式)
     * @Date: 15:11 2019/10/8
     * @param persons
     * @return: void
     * @Version: 1.0
     */
    public  void testFilterPersonByPredicate(List<Person> persons){

        this.filterPersonByPredicate(persons, new MyPredicate<Person>() {
            @Override
            public boolean check(Person person) {
                return  person.getAge()>22? true: false;
            }
        });
    }

    /**
     * @Author: luluzsp
     * @Description: 调用策略模式(通过lambda的方式)
     * @Date: 15:19 2019/10/8
     * @param persons
     * @return: void
     * @Version: 1.0
     */
    public  void lambdaFilterPersonByPredicate(List<Person> persons){

        this.filterPersonByPredicate(persons, (Person p ) ->{
            return p.getAge()>22? true:false;
        });
    }

    /**
     * @Author: luluzsp
     * @Description: person集合自定义排序(lambda表达式实现)
     * @Date: 17:20 2019/10/8
     * @return: void
     * @Version: 1.0
     */
    public  void SortList(){
        Collections.sort(personList,(p1,p2)->{
           int age1 = p1.getAge();
           int age2 = p2.getAge();
           if (age1!=age2){
               return p1.getSalary()>p2.getSalary()?1:-1;
           }else{
               return age1>age2?1:-1;
           }
        });
    }

    /**
     * @Author: luluzsp
     * @Description: 定义 操作两个类型的计算方法, Calculation接口定义操作两个接口的方法.
     * @Date: 19:59 2019/10/8
     * @param a
     * @param b
     * @param cal
     * @return: void
     * @Version: 1.0
     */
    public  void calculate(long a, long b, Calculation<Long,String> cal){

        String  str = cal.calculate(a,b);
        System.out.println(str);
    }


    /**
     * @Author: luluzsp
     * @Description: 调用calculation方法,传入操作两个数的策略.
     * @Date: 20:02 2019/10/8
     * @return: void
     * @Version: 1.0
     */
    public  void testcalculate(){
        long a = 20L;
        long b = 30L;
        this.calculate(a,b,(x,y)-> x.toString()+y.toString() );
    }
}
