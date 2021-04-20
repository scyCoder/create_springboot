package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Student)表控制层
 *
 * @author sunchuanyin
 * @since 2021-02-25 11:48:45
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Student selectOne(Integer id) {
        return this.studentServiceImpl.queryById(id);
    }

}