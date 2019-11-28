package com.sparta.e44.services;

import com.sparta.e44.entities.TeachingGroupEntity;
import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.repositories.TeachingGroupRepository;
import com.sparta.e44.repositories.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TraineeService {

    @Autowired
    private TraineeRepository traineeRepository;
    @Autowired
    private TeachingGroupRepository teachingGroupRepository;

    public List<TraineeEntity> getAll(){
        ArrayList<TraineeEntity> trainees = new ArrayList<>();
        traineeRepository.findAll().forEach(t->trainees.add(t));
        return trainees;
    }

    public TraineeEntity getById(int id){
        return traineeRepository.findById(id).get();
    }

    public void addTrainee(TraineeEntity newTrainee){
        traineeRepository.save(newTrainee);
    }

    public void removeTrainee(int id){
        traineeRepository.deleteById(id);
    }

    public TraineeEntity editTrainee(TraineeEntity editedTrainee, int id){
        editedTrainee.setTraineeId(id);
        traineeRepository.save(editedTrainee);
        return editedTrainee;
    }

    public TraineeEntity addGroup(int traineeId, int groupId){
        TeachingGroupEntity group = teachingGroupRepository.findById(groupId).get();
        TraineeEntity trainee = traineeRepository.findById(traineeId).get();
        trainee.setTeachingGroup(group);
        traineeRepository.save(trainee);
        return trainee;
    }

    public TraineeEntity removeGroup(int traineeId){
        TraineeEntity trainee = traineeRepository.findById(traineeId).get();
        trainee.setTeachingGroup(null);
        traineeRepository.save(trainee);
        return trainee;
    }
}
