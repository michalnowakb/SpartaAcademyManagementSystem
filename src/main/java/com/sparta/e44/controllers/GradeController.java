package com.sparta.e44.controllers;

import com.sparta.e44.entities.GradeEntity;
import com.sparta.e44.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class GradeController {
    @Autowired
    private GradeService gradeService;
    @GetMapping("/grade/{id}")
    public GradeEntity getGrade(@PathVariable int id) {
        return gradeService.getById(id);
    }

    @PostMapping("/grade/newGrade")
    public String addGrade(@RequestBody GradeEntity newGrade){
        gradeService.addGrade(newGrade);
        return "New grade added";
    }

    @PutMapping("/course/updateCourse/{id}")
    public void setEditGrade(@PathVariable int id, @RequestBody GradeEntity editGrade) {

    }
}
