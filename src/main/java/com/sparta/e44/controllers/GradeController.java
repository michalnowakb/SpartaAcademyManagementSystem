package com.sparta.e44.controllers;

import com.sparta.e44.entities.GradeEntity;
import com.sparta.e44.entities.ModuleEntity;
import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.entities.holders.GradeHolder;
import com.sparta.e44.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/grade/getGrades")
    public String getGrades(Model model){
        model.addAttribute("grades",gradeService.getAllGrades());
        return "";
    }

    @GetMapping("/grade/getGrade/{traineeId}/{moduleId}")
    public String getGrade(@PathVariable("traineeId") int traineeId, @PathVariable("moduleId") int moduleId) {
        gradeService.getById(traineeId,moduleId);
        return "";
    }



    @PostMapping("/grade/addGrade")
    public String addGrade(@Valid GradeEntity newGrade){
        gradeService.addGrade(newGrade);
        return "";
    }

    @PostMapping("/grade/addGrade/alt")
    public String addGrade(@Valid GradeHolder gradeHolder){
        gradeService.addGrade(gradeHolder);
        return "";
    }

    @GetMapping("/grade/removeGrade/{traineeId}/{moduleId}")
    public String removeGrade(@PathVariable("traineeId") int traineeId, @PathVariable("moduleId") int moduleId){
        gradeService.removeGrade(traineeId,moduleId);
        return "";
    }

    @GetMapping("/grade/editGrade/alt/{traineeId}/{moduleId}")
    public String editGrade(@Valid GradeHolder grade, @PathVariable("traineeId") int traineeId, @PathVariable("moduleId") int moduleId){
        gradeService.editGrade(grade.getGrade(),traineeId,moduleId);
        return "";
    }

    @GetMapping("/grade/editGrade/{traineeId}/{moduleId}")
    public String editGrade(@Valid GradeEntity grade, @PathVariable("traineeId") int traineeId, @PathVariable("moduleId") int moduleId){
        gradeService.editGrade(grade,traineeId,moduleId);
        return "";
    }

    @GetMapping("/grade/editGrade")
    public String editGrade(@Valid GradeEntity grade, @Valid TraineeEntity trainee, @Valid ModuleEntity module){
        gradeService.editGrade(grade,trainee,module);
        return "";
    }
}
