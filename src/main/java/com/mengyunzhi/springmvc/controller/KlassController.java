package com.mengyunzhi.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mengyunzhi.springmvc.repository.Klass;
import com.mengyunzhi.springmvc.service.KlassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Created by xulinjie on 2017-10-11.
 */
@RestController
@RequestMapping("/klass")
public class KlassController {

    // 引入日志类的固有写法
    private final static Logger logger = LoggerFactory.getLogger(KlassController.class);

    @RequestMapping("/test/")
    public void test( @RequestBody JsonInput jsonInput) {
        logger.info("获取到的RequestBody为:" + jsonInput.toString());
    }

    private static class JsonInput {

        private String name;
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "JsonInput{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }

        public JsonInput() {
        }

        public JsonInput(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }
    }

    @Autowired
    private KlassService klassService;

    @PostMapping("/")
    public Klass save(@RequestParam String name, @RequestParam Long teacherId) {
        return klassService.add(name, teacherId);
    }

    @GetMapping("/{id}")
    public Klass get(@PathVariable Long id) {
        return klassService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        klassService.delete(id);
        return;
    }

    @PutMapping("/{id}")
    public Klass update(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam Long teacherId) {
        return klassService.update(id, name, teacherId);
    }
}
