package com.sparta.e44.controllers;

import com.sparta.e44.entities.TrainerEntity;
import com.sparta.e44.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainerController {

    @Autowired
    private TrainerService trainerService;


    @GetMapping("trainer/getTrainers")
    public List<TrainerEntity> getTrainers() {
        return trainerService.getAll();
    }

    @GetMapping("trainer/getTrainer/{id}")
    public TrainerEntity getTrainer(@PathVariable int id) {
        return trainerService.getById(id);
    }


    @PostMapping("trainer/addTrainer")
    public void addTrainer(@RequestBody TrainerEntity newTrainer) {
        trainerService.addTrainer(newTrainer);
    }

    @PutMapping("/trainer/editTrainer/{id}")
    public TrainerEntity editTrainee(@RequestBody TrainerEntity editedTrainer, @PathVariable int id) {
        trainerService.editTrainer(editedTrainer, id);
        return trainerService.getById(id);
    }

    @DeleteMapping("trainer/deleteTrainer/{id}")
    public void removeTrainer(@PathVariable int id) {
        trainerService.removeTrainer(id);
    }
}
