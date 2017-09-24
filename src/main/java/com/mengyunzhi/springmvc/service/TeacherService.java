package com.mengyunzhi.springmvc.service;

import com.mengyunzhi.springmvc.repository.Teacher;
import javax.persistence.EntityNotFoundException;
/**
 * Created by xulinjie on 2017/9/24.
 */
public interface TeacherService {

    /**
     * 保存
     * @param id 关键字
     * @param teacher 教师
     * @return 保存后的教师
     */
    Teacher saveTeacher(Long id, Teacher teacher) throws EntityNotFoundException;
}
