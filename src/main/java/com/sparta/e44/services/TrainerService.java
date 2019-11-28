package com.sparta.e44.services;


import com.sparta.e44.entities.ModuleEntity;
import com.sparta.e44.entities.TrainerEntity;
import com.sparta.e44.repositories.ModuleRepository;
import com.sparta.e44.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    public List<TrainerEntity> getAll() {
        ArrayList<TrainerEntity> trainers = new ArrayList<>();
        trainerRepository.findAll().forEach(t -> trainers.add(t));
        return trainers;
    }

    public TrainerEntity getById(int id) {
        return trainerRepository.findById(id).get();
    }

    public void addTrainer(TrainerEntity newTrainer) {
        trainerRepository.save(newTrainer);
    }

    public TrainerEntity editTrainer(TrainerEntity editedTrainer, int id) {
        editedTrainer.setTrainerId(id);
        trainerRepository.save(editedTrainer);
        return editedTrainer;
    }

    public void removeTrainer(int id) {
        TrainerEntity toBeDeleted = trainerRepository.findById(id).get();
        trainerRepository.delete(toBeDeleted);
    }

    public List<ModuleEntity> getAllQualifiedModules(int traineeId) {
        return trainerRepository.findById(traineeId).get().getQualifiedModules();
    }

    public void addQualifiedModule(int traineeId, int moduleId) {
        TrainerEntity trainer = trainerRepository.findById(traineeId).get();
        ModuleEntity module = moduleRepository.findById(moduleId).get();
        trainer.addModule(module);
       trainerRepository.save(trainer);

    }

    public void removeQualifiedModule(int courseId, int moduleId) {
        TrainerEntity trainer = trainerRepository.findById(courseId).get();
        ModuleEntity module = moduleRepository.findById(moduleId).get();
        trainer.removeModule(module);
        trainerRepository.save(trainer);
    }
}
