package com.example.demo;

import com.example.demo.conf.TestAnnotaionConditionalOnProperties;
import com.example.demo.controller.abstra.TestAbstractController;
import com.example.demo.entity.Apps;
import com.example.demo.entity.People;
import com.example.demo.jpa.JpaTeacherEntity;
import com.example.demo.jpa.JpaTeacherRepository;
import com.example.demo.service.PeopleService;
import com.example.demo.service.impl.thread.ThreadServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutionException;

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
    private ThreadServiceTest threadServiceTest;

    @Autowired
    private JpaTeacherRepository jpaTeacherRepository;


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

    @Test
    public void test8() {
//        People people = new People();
//        System.out.println(peopleServiceImpl.insert(people));
        double a = 25 / 2;
        System.out.println(a);

        File file = new File(".");
        File[] files = file.listFiles(File::isHidden);

    }


    @Test
    public void test9() {
        Apps apps = new Apps();
        if (1 == apps.getHello()) {
            System.out.println("相等");
        } else {
            System.out.println("不相等");
        }
    }

    @Test
    public void test10() {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("hello", "1");
        map.add("hello", 1);
        System.out.println(map);
    }

    @Test
    public void test11() {
        try {
            threadServiceTest.threadServiceTest();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test12() {
        Map<String, TestAbstractController> beansOfType = applicationContext.getBeansOfType(TestAbstractController.class);
        System.out.printf(beansOfType.toString());
    }


    @Test
    public void test13() {
        String hello = null;
        Assert.notNull(hello,"hello不能为空");
        System.out.println("helloo-------");
    }

    @Test
    public void test14() {
        BigDecimal hello = new BigDecimal(1);
        System.out.println(hello.toPlainString());
    }

    @Autowired
    private TestAnnotaionConditionalOnProperties conditionalOnProperties;

    @Test
    public void test15() {
        if (conditionalOnProperties == null) {
            System.out.println("conditionalOnProperties为空");
            return;
        }
        System.out.printf(conditionalOnProperties.hello());
    }


    @Test
    public void test16() {
        List<Integer > ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        Pageable pageable = PageRequest.of(0, 1);
        List<JpaTeacherEntity> teacherEntity = jpaTeacherRepository.getOneTeachey(ids, "王二",pageable);
        System.out.println(teacherEntity);

    }

    @Test
    public void test17() {
        List<JpaTeacherEntity > ids = new ArrayList<>();
        JpaTeacherEntity teacherEntity1 = new JpaTeacherEntity();
        teacherEntity1.setId(1);
        teacherEntity1.setName("小红");
        ids.add(teacherEntity1);

        JpaTeacherEntity teacherEntity2 = new JpaTeacherEntity();
        teacherEntity2.setId(2);
        teacherEntity2.setName("小红2");
        ids.add(teacherEntity2);

//        for (int i = 0; i < ids.size(); i++) {
//            if (ids.get(i).getId() == 2) {
//                JpaTeacherEntity teacherEntity3 = new JpaTeacherEntity();
//                teacherEntity3.setId(3);
//                teacherEntity3.setName("小红3");
//                ids.set(i,teacherEntity3);
//            }
//        }

        for (JpaTeacherEntity id : ids) {
            if (id.getId() == 2) {
                JpaTeacherEntity teacherEntity3 = new JpaTeacherEntity();
                teacherEntity3.setId(3);
                teacherEntity3.setName("小红3");
                ids.add(teacherEntity3);
            }
        }
        System.out.println(ids);

    }
}
