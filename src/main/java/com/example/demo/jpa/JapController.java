package com.example.demo.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/30 1:31 下午
 */
@RestController
@RequestMapping("/jpa")
public class JapController {

    @Autowired
    private JpaService jpaService;

    @GetMapping("/findById")
    public JpaTeacherEntity findById(int id) {
        // return jpaService.findById(id);
        return jpaService.findTeacherById(id);
    }
}
