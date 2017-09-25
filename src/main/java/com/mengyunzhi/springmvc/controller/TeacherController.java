package com.mengyunzhi.springmvc.controller;

import com.mengyunzhi.springmvc.repository.Teacher;
import com.mengyunzhi.springmvc.repository.TeacherRepository;
import com.mengyunzhi.springmvc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.persistence.EntityNotFoundException;

// 声明为Rest控制器（支持前后台分离）
@RestController
@RequestMapping("/teacher")

public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherService teacherService;

    // 设置路由
    @PostMapping("/save")
    // 使用@RequestBody注解，将请求的`json`数据，直接加载至teacher对象
    public Teacher saveTeacher(@Valid @RequestBody Teacher teacher) {
        // 打印加载的数据
        System.out.println(teacher);

        // 调用保存操作
        return teacherRepository.save(teacher);
    }

    // @GetMapping 表明该方法只接收 get 请求.
    // {id}即为url中传入教师关键字
    @GetMapping("/{id}")
    // @PathVariable 获取路由中的id值
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherRepository.findOne(id);
    }

    // @PutMapping 表明该方法只接收 put 请求.
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) throws EntityNotFoundException {
        //代码逻辑整体整体迁移到service层
//        // 判断是否存在该实体，如果不存在，则报错
//        if (teacherRepository.findOne(id) == null) {
//            throw new EntityNotFoundException("传入的ID值：" + id.toString() + "有误。未找到对应的实体");
//        }
//
//        // 对实体ID赋值, 并执行更新操作
//        teacher.setId(id);
//        return teacherRepository.save(teacher);

        //数据转发
        return teacherService.saveTeacher(id, teacher);

    }
}
