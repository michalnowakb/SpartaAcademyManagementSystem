package com.sparta.e44.controllers;

import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.services.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @GetMapping("/trainee/getTrainees")
    public String getTrainees(Model model) {
        model.addAttribute("trainees", traineeService.getAll());
        return "viewTraineePage";
    }

    @GetMapping("/trainee/getTrainee/{id}")
    public String getTrainee(@PathVariable("id") int id, Model model) {
        model.addAttribute("trainee", traineeService.getById(id));
        return "updateTraineePage";
    }

    @PostMapping("/trainee/addTrainee")
    public String addTrainee(@Valid TraineeEntity newTrainee) {
        traineeService.addTrainee(newTrainee);
        return "registerTraineePage";
    }

    @GetMapping("/trainee/editTrainee/{id}")
    public String editTrainee(@Valid TraineeEntity editedTrainee, @PathVariable("id") int id, Model model) {
        traineeService.editTrainee(editedTrainee, id);
        model.addAttribute("trainees", traineeService.getAll());
        return getTrainees(model);
    }


    @GetMapping("/trainee/removeTrainee/{id}")
    public String removeCourse(@PathVariable("id") int id, Model model) {
        traineeService.removeTrainee(id);
        return getTrainees(model);
    }
}
