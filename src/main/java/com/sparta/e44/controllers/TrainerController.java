package com.sparta.e44.controllers;

import com.sparta.e44.entities.ModuleEntity;
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

    @DeleteMapping("trainer/removeTrainer/{id}")
    public void removeTrainer(@PathVariable int id) {
        trainerService.removeTrainer(id);
    }

    @GetMapping("trainer/addQualifiedModule/{trainerId},{moduleId}")
    public TrainerEntity addQualifiedModule(@PathVariable int trainerId,@PathVariable int moduleId ){
        trainerService.addQualifiedModule(trainerId,moduleId);
        return trainerService.getById(trainerId);
    }

    @DeleteMapping("trainer/removeQualifiedModule/{trainerId},{moduleId}")
    public TrainerEntity removeQualifiedModule(@PathVariable int trainerId,@PathVariable int moduleId ){
        trainerService.removeQualifiedModule(trainerId,moduleId);
        return trainerService.getById(trainerId);
    }

    @GetMapping("trainer/getAllQualifiedModules/{trainerId}")
    public List<ModuleEntity> getAllQualifiedModules(@PathVariable int trainerId){
       return trainerService.getAllQualifiedModules(trainerId);
    }
}
