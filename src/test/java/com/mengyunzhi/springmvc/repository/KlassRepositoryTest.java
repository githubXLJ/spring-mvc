package com.mengyunzhi.springmvc.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.dao.DataIntegrityViolationException;

// import static :导入的类为静态类，在本测试用例中只导入一次
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xulinjie on 2017/9/28.
 */
// 使用以下两个注解来说明：本测试类基于SpringBoot。(必须)
@RunWith(SpringRunner.class) @SpringBootTest
public class KlassRepositoryTest {
    // @Autowired注解：自动加载Spring为我们自动实例化的实现了KlassRepository接口的对象
    @Autowired
    private KlassRepository klassRepository;

    // @Before注解：在执行单元测试方法 前 执行。
    @Before
    public void before() {
    }

    // @After：在执行单元测试方法 后 执行。
    @After
    public void after() {
    }

    @Test
    public void test() {
        Klass klass = new Klass();
        klass.setName("网络一班");
        assertThat(klassRepository.save(klass)).isNotNull();
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void addDataWithTeacher() {
        Teacher teacher = new Teacher("zhangsan",
                "zhangsan@yunzhiclub.com",
                "scse of hebut",
                false);
        Klass klass = new Klass(teacher, "一一班");
        klassRepository.save(klass);
    }
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void addKlassWithExistTeacher() {
        Teacher teacher = new Teacher("zhangsan",
                "zhangsan@yunzhiclub.com",
                "scse of hebut",
                false);
        teacherRepository.save(teacher);
        Klass klass = new Klass(teacher, "一一班");
        assertThat(klassRepository.save(klass)).isNotNull();
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void relationDeleteException() {
        Teacher teacher = new Teacher("zhangsan",
                "zhangsan@yunzhiclub.com",
                "scse of hebut",
                false);
        teacherRepository.save(teacher);
        Klass klass = new Klass(teacher, "一一班");
        klassRepository.save(klass);
        teacherRepository.delete(teacher);
    }
}