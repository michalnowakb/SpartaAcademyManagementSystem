package com.sparta.e44.controllers;

import com.sparta.e44.entities.ModuleEntity;
import com.sparta.e44.entities.TrainerEntity;
import com.sparta.e44.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class TrainerController {

    @Autowired
    private TrainerService trainerService;


    @GetMapping("/trainer/getTrainers")
    public String getTrainers(Model model) {
        model.addAttribute("trainers", trainerService.getAll());
        return "";
    }

    @GetMapping("/trainer/getTrainer/{id}")
    public String getTrainer(@PathVariable("id") int id, Model model) {

        model.addAttribute("trainer", trainerService.getById(id));
        return "";
    }

    @PostMapping("/trainer/addTrainer")
    public String addTrainer(@Valid TrainerEntity trainer) {
        trainerService.addTrainer(trainer);
        return "";
    }

    @GetMapping("/trainer/editTrainer/{id}")
    public String editTrainee(@PathVariable("id") int id, @Valid TrainerEntity trainer) {
        trainerService.editTrainer(trainer, id);
        return "";
    }

    @GetMapping("trainer/removeTrainer/{id}")
    public String removeTrainer(@PathVariable("id") int id) {
        trainerService.removeTrainer(id);
        return "";
    }

    @PutMapping("/trainer/addQualifiedModule/{trainerId},{moduleId}")
    public TrainerEntity addQualifiedModule(@PathVariable("trainerId") int trainerId, @PathVariable("moduleId") int moduleId) {
        trainerService.addQualifiedModule(trainerId, moduleId);
        return trainerService.getById(trainerId);
    }

    @PutMapping("/trainer/removeQualifiedModule/{trainerId},{moduleId}")
    public TrainerEntity removeQualifiedModule(@PathVariable("trainerId") int trainerId, @PathVariable("moduleId") int moduleId) {
        trainerService.removeQualifiedModule(trainerId, moduleId);
        return trainerService.getById(trainerId);
    }


}
