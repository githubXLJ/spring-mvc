package com.mengyunzhi.springmvc.repository;

import javax.persistence.*;
import com.mengyunzhi.springmvc.repository.Teacher;

/**
 * Created by xulinjie on 2017-9-28.
 */
public class Klass {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;

    @ManyToOne // 多对一关联
    private Teacher teacher;

    private String name;        // 名称

    public Klass(Teacher teacher) {
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
