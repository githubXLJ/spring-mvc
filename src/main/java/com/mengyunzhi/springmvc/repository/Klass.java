package com.mengyunzhi.springmvc.repository;

import org.springframework.stereotype.Service;

import javax.persistence.*;

/**
 * Created by xulinjie on 2017-9-28.
 */
// 使用@Entity 来说明该类对应一个数据表
@Entity
@Service
public class Klass {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;

    @ManyToOne // 多对一关联
    private Teacher teacher;

    private String name;        // 名称


    public Klass(Teacher teacher, String name) {
        this.teacher = teacher;
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Klass() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
