package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description mybatis的延迟加载
 * 说明:
 * 在写延迟加载的时候，对于student 和teacher 的两个mapper.xml文件中，不能同时出现<association></association>
 * 和<collection></collection>,否则会出现StackOverflowError（因为出现了来回调用）
 * @date 2021/2/25 11:51 上午
 */
public class MybatisLazyTest extends DemoApplicationTests {

    @Autowired
    private StudentService studentServiceImpl;

    @Autowired
    private TeacherService teacherServiceImpl;

    /**
     * 一对一
     */
    @Test
    public void test() {

        Student student = studentServiceImpl.queryById(1);
        System.out.println(student);
    }

    /**
     * 一对多
     */
    @Test
    public void test1() {

        Teacher teacher = teacherServiceImpl.queryById(2);
        System.out.println(teacher); // 如果打印了，说明使用到了teacher中的studentList属性，那么将不是延迟加载，如果不打印将会是延迟加载
    }
}
