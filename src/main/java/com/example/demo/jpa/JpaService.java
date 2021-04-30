package com.example.demo.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/30 1:47 下午
 */
@Service
public class JpaService {

    @Autowired
    private JpaTeacherRepository jpaTeacherRepository;

    public JpaTeacherEntity findById(int id) {
        return jpaTeacherRepository.findById(id);
    }

    public JpaTeacherEntity findTeacherById(int id) {
        return jpaTeacherRepository.findTeacherById(id);
    }
}
