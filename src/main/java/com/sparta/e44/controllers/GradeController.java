package com.sparta.e44.controllers;

import com.sparta.e44.entities.GradeEntity;
import com.sparta.e44.entities.holders.GradeHolder;
import com.sparta.e44.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/grade/allGrades")
    public List<GradeEntity> getAllGrades(){
        return gradeService.getAllGrades();
    }

    @GetMapping("/grade/{traineeId}/{moduleId}")
    public GradeEntity getGrade(@PathVariable int traineeId, @PathVariable int moduleId) {
        return gradeService.getById(traineeId,moduleId);
    }



    @PostMapping("/grade/newGrade")
    public String addGrade(@RequestBody GradeEntity newGrade){
        gradeService.addGrade(newGrade);
        return "New grade added";
    }

    @PostMapping("/grade/newGrade/alt")
    public String addGrade(@RequestBody GradeHolder gradeHolder){
        gradeService.addGrade(gradeHolder);
        return "added Grade";
    }

    @DeleteMapping("/grade/removeGrade/{traineeId}/{moduleId}")
    public String removeGrade(@PathVariable int traineeId, @PathVariable int moduleId){
        gradeService.removeGrade(traineeId,moduleId);
        return "removed Grade";
    }
}
