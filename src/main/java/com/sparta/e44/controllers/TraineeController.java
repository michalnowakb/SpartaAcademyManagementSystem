package com.sparta.e44.controllers;

import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.services.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @GetMapping("/trainee/getTrainees")
    public String getTrainees(Model model) {

        model.addAttribute("trainees", traineeService.getAll());
        return "";
    }

    @GetMapping("/trainee/getTrainee/{id}")
    public String getTrainee(@PathVariable("id") int id, Model model) {
        model.addAttribute("trainee", traineeService.getById(id));
        return "";
    }

    @PostMapping("/trainee/addTrainee")
    public String addTrainee(@Valid TraineeEntity newTrainee) {
        traineeService.addTrainee(newTrainee);
        return "";
    }

    @GetMapping("/trainee/editTrainee/{id}")
    public String editTrainee(@RequestBody TraineeEntity editedTrainee, @PathVariable("id") int id) {
        traineeService.editTrainee(editedTrainee, id);
        return "";
    }

    @GetMapping("/trainee/removeTrainee/{id}")
    public String removeCourse(@PathVariable("id") int id) {
        traineeService.removeTrainee(id);
        return "";
    }
}
