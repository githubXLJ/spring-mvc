package com.mengyunzhi.springmvc.controller;

import com.mengyunzhi.springmvc.repository.Klass;
import com.mengyunzhi.springmvc.service.KlassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Created by xulinjie on 2017-10-11.
 */
public class KlassController {
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
