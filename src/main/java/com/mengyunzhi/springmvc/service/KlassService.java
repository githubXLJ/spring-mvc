package com.mengyunzhi.springmvc.service;

import com.mengyunzhi.springmvc.repository.Klass;
/**
 * Created by xulinjie on 2017-10-11.
 */
public interface KlassService {

    Klass add(String name, Long teacherId);
    Klass get(Long id);
    void  delete(Long id);
    Klass update(Long id, String name, Long teacherId);
    Klass getNewKlass();    // 获取一个新的教师实例
}
