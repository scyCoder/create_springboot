package com.example.demo.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/30 1:40 下午
 */
@Data
@Entity
@Table(name = "teacher",schema = "test-demo")
public class JpaTeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String sex;

    private Date createdAt;

    private Date updatedAt;

    public JpaTeacherEntity() {
    }

    public JpaTeacherEntity(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
}
