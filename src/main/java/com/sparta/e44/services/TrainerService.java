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
        trainerRepository.deleteById(id);
    }

    public void removeTrainer(TrainerEntity trainer){
        trainerRepository.delete(trainer);
    }

    public List<ModuleEntity> getAllQualifiedModules(int traineeId) {
        return trainerRepository.findById(traineeId).get().getQualifiedModules();
    }


    public void addQualifiedModule(int trainerId, int moduleId) {
        TrainerEntity trainer = trainerRepository.findById(trainerId).get();
        ModuleEntity module = moduleRepository.findById(moduleId).get();
        addQualifiedModule(trainer,module);

    }

    public void addQualifiedModule(TrainerEntity trainer, ModuleEntity module){
        trainer.addModule(module);
        trainerRepository.save(trainer);
    }


    public void removeQualifiedModule(int trainerId, int moduleId) {
        TrainerEntity trainer = trainerRepository.findById(trainerId).get();
        ModuleEntity module = moduleRepository.findById(moduleId).get();
        removeQualifiedModule(trainer,module);
    }

    public void removeQualifiedModule(TrainerEntity trainer, ModuleEntity module){
        trainer.removeModule(module);
        trainerRepository.save(trainer);
    }

    public List<TrainerEntity> getByName(String searchQuery) {
        return trainerRepository.getTrainerEntitiesByName(searchQuery);
    }
}
