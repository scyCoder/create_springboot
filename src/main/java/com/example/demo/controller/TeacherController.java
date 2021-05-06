package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Teacher)表控制层
 *
 * @author sunchuanyin
 * @since 2021-02-25 11:51:00
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Teacher selectOne(Integer id) throws Exception {
        try {
            int i = 1 / 0;
            return this.teacherServiceImpl.queryById(id);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            throw new ArithmeticException("ArithmeticException查询报错");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception("查询报错");
        }
    }

}