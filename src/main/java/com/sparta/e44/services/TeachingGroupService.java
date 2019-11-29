package com.sparta.e44.services;

import com.sparta.e44.entities.ClassroomEntity;
import com.sparta.e44.entities.TeachingGroupEntity;
import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.entities.TrainerEntity;
import com.sparta.e44.repositories.ClassroomRepository;
import com.sparta.e44.repositories.TeachingGroupRepository;
import com.sparta.e44.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeachingGroupService {

    @Autowired
    private TeachingGroupRepository teachingGroupRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    public List<TeachingGroupEntity> getAllTeachingGroups(){
        List<TeachingGroupEntity> teachingGroups = new ArrayList<>();
        teachingGroupRepository.findAll().forEach(teachingGroup -> teachingGroups.add(teachingGroup));
        return teachingGroups;
    }

    public TeachingGroupEntity getTeachingGroup(int teachingGroupId){
        return teachingGroupRepository.findById(teachingGroupId).get();
    }

    public void addTeachingGroup (TeachingGroupEntity teachingGroupEntity){
        teachingGroupRepository.save(teachingGroupEntity);
    }

    public void removeTeachingGroup(int id){
        teachingGroupRepository.deleteById(id);
    }

    public void removeTeachingGroup(TeachingGroupEntity group){
        teachingGroupRepository.delete(group);
    }

    public TeachingGroupEntity editTeachingGroup(TeachingGroupEntity teachingGroup, int id){
        teachingGroup.setGroupId(id);
        teachingGroupRepository.save(teachingGroup);
        return teachingGroup;
    }

    public void addTrainer(int teachingGroupId, int trainerId){
        TeachingGroupEntity teachingGroup = teachingGroupRepository.findById(teachingGroupId).get();
        TrainerEntity trainer = trainerRepository.findById(trainerId).get();
        addTrainer(teachingGroup,trainer);
    }

    public void addTrainer(TeachingGroupEntity teachingGroup, TrainerEntity trainer){
        teachingGroup.addTrainer(trainer);
        teachingGroupRepository.save(teachingGroup);
    }

    public void removeTrainer(int teachingGroupId, int trainerId){
        TeachingGroupEntity teachingGroup = teachingGroupRepository.findById(teachingGroupId).get();
        TrainerEntity trainer = trainerRepository.findById(trainerId).get();
        removeTrainer(teachingGroup,trainer);
    }

    public void removeTrainer(TeachingGroupEntity teachingGroup, TrainerEntity trainer){
        teachingGroup.removeTrainer(trainer);
        teachingGroupRepository.save(teachingGroup);
    }

    public TeachingGroupEntity addClassroom(int groupId, int classroomId){
        ClassroomEntity newRoom = classroomRepository.findById(classroomId).get();
        TeachingGroupEntity group = teachingGroupRepository.findById(groupId).get();
        return addClassroom(group,newRoom);
    }

    public TeachingGroupEntity addClassroom(TeachingGroupEntity group, ClassroomEntity newRoom){
        group.setClassroomEntity(newRoom);
        teachingGroupRepository.save(group);
        return group;
    }

    public TeachingGroupEntity removeClassroom(int groupId){
        TeachingGroupEntity group = teachingGroupRepository.findById(groupId).get();
        return removeClassroom(group);
    }

    public TeachingGroupEntity removeClassroom(TeachingGroupEntity group){
        group.setClassroomEntity(null);
        teachingGroupRepository.save(group);
        return group;
    }



}
