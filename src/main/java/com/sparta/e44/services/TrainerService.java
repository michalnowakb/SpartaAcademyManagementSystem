package com.sparta.e44.services;

import com.sparta.e44.entities.TrainerEntity;
import com.sparta.e44.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

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
}
