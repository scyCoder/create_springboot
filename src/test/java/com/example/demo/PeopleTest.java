package com.example.demo;

import com.example.demo.entity.People;
import com.example.demo.service.PeopleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/2/20 3:51 下午
 */
public class PeopleTest extends DemoApplicationTests {

    @Autowired
    private PeopleService peopleServiceImpl;

    @Autowired
    private HttpServletRequest request;

    public static int staticVar = 0;
    public int instanceVar = 0;

    @Test
    public void getPeople() {
        People people = peopleServiceImpl.queryById(1);
        System.out.println(people);

    }


    @Test
    public void updatePeople() {
        People people = new People();
        people.setId(1);
        people.setName("hello11");
        peopleServiceImpl.update(people);
        System.out.println(people);

    }

    @Test
    public void test() {
        String hello = null;
        double he = 11 >> 2;
        System.out.println(he);
    }

    @Test
    public void test1() {
        /*为什么utf-8中文为3个字节而char只能存两个字节，没有报错，因为java内部是使用的unicode编码*/
        char c = '我';
        System.out.println(c);

    }

    public void test2() {


        staticVar++;
        instanceVar++;
        System.out.println("staticVar =" + staticVar + ",instanceVar =" + instanceVar);

    }

    @Test
    public void test3() {


        new PeopleTest().test2();
        new PeopleTest().test2();
        new PeopleTest().test2();
        new PeopleTest().test2();

        /**静态变量：无论创建多少个对象，只有一个（类变量）
         * 实例变量：创建一个对象，生成一个新的对象（必须要有对象）
         * staticVar =1,instanceVar =1
         * staticVar =2,instanceVar =1
         * staticVar =3,instanceVar =1
         * staticVar =4,instanceVar =1
         */

    }

    @Test
    public void test4() {

        // 区间 -128 ~ 127
        Integer i1 = 1;
        Integer i2 = 1;

        Integer i3 = new Integer(1);
        Integer i4 = new Integer(1);

        Integer i5 = 200;
        Integer i6 = 200;
        System.out.println(i3 == i4); // false
        System.out.println(i1 == i2); // true
        System.out.println(i1.equals(i2)); // true
        System.out.println(i5 == i6); // false

        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
    }

    @Test
    public void test5() {
        int x = 1;
        x++;
        int s = 1;
        s = s + x;
        System.out.println(s);
        System.out.println(x);
    }

    @Test
    public void test6() {
        //System.out.println(this.test7());
        Set set = new HashSet<>();
        People people = new People();
        people.setName("hello");
        people.setId(1);
        People people1 = new People();
        people1.setName("hello");
        people1.setId(2);
        set.add(people);


        set.add(people1);
        System.out.println(set);
    }

    public int test7() {
        int i = 1;
        try {
            return i;
        } finally {
            i = 7;
        }
    }

}
