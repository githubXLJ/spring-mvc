package com.mengyunzhi.springmvc.service;

import com.mengyunzhi.springmvc.repository.Klass;
import com.mengyunzhi.springmvc.repository.Teacher;
import com.mengyunzhi.springmvc.repository.TeacherRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xulinjie on 2017-10-11.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class KlassServiceTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private KlassService klassService;
    @Autowired
    private Klass klass;

    @Before
    public void before() {
        // 新增教师
        Teacher teacher = new Teacher(
                "zhangsan",
                "zhangsan@yunzhiclub.com",
                "scse of hebut",
                true);
        teacherRepository.save(teacher);

        // 新增班级
        klass = klassService.add("软件班", teacher.getId());
    }
    @Test
    public void add() throws Exception {
        // 新增教师
        Teacher teacher = new Teacher(
                "zhangsan",
                "zhangsan@yunzhiclub.com",
                "scse of hebut",
                true);
        teacherRepository.save(teacher);

        // 新增班级
        Klass klass = klassService.add("软件班",teacher.getId());

        // 断言返回值非NULL
        assertThat(klass).isNotNull();
    }

    @Test
    public void get() throws Exception {
        // 断言查询ID为0的结果为null
        assertThat(klassService.get(10000L)).isNull();

        // 新增教师
        Teacher teacher = new Teacher(
                "zhangsan",
                "zhangsan@yunzhiclub.com",
                "scse of hebut",
                true);
        teacherRepository.save(teacher);

        // 新增班级
        Klass klass = klassService.add("软件班", teacher.getId());

        // 断言查询到的新增的的ID不为null
        assertThat(klassService.get(klass.getId())).isNotNull();
    }

    @Test
    public void delete() throws Exception {
        // 查询实体，断言其存在
        assertThat(klass).isNotNull();

        // 将实体删除
        klassService.delete(klass.getId());

        // 查询实体，断言其不存在
        assertThat(klassService.get(klass.getId())).isNull();
    }

    @Test
    public void update() throws Exception {
        // 新建一个教师实体
        Teacher teacher = new Teacher(
                "zhangsan",
                "zhangsan@yunzhiclub.com",
                "scse of hebut",
                true);
        teacherRepository.save(teacher);

        // 更新
        String name = "软件工程";
        klassService.update(klass.getId(), name, teacher.getId());

        // 查询, 并断言
        Klass newKlass = klassService.get(klass.getId());
        assertThat(newKlass.getName()).isEqualTo(name);
        assertThat(newKlass.getTeacher().getId()).isEqualTo(teacher.getId());
    }

}