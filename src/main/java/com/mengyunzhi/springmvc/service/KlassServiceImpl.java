package com.mengyunzhi.springmvc.service;

import com.mengyunzhi.springmvc.repository.Klass;
import com.mengyunzhi.springmvc.repository.KlassRepository;
import com.mengyunzhi.springmvc.repository.Teacher;
import com.mengyunzhi.springmvc.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xulinjie on 2017-10-11.
 */
@Service
public class KlassServiceImpl implements KlassService {

    @Autowired
    private KlassRepository klassRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Klass add(String name, Long teacherId) {
        Teacher teacher = teacherRepository.findOne(teacherId);

        Klass klass = new Klass(teacher,name);
        return klassRepository.save(klass);
    }

    @Override
    public Klass get(Long id) {
        Klass klass = klassRepository.findOne(id);
        return klass;
    }

    @Override
    public void delete(Long id) {
        klassRepository.delete(id);
    }

    @Override
    public Klass update(Long id, String name, Long teacherId) {
        //
        Teacher teacher = teacherRepository.findOne(teacherId);
        Klass klass = klassRepository.findOne(id);
        klass.setTeacher(teacher);
        klass.setName(name);
        klassRepository.save(klass);
        return klass;
    }
}
