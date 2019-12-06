package com.sparta.e44.services;

import com.sparta.e44.entities.ClassroomEntity;
import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public List<ClassroomEntity> getAll(){
        ArrayList<ClassroomEntity>  classrooms = new ArrayList<>();
        classroomRepository.findAll().forEach(c->classrooms.add(c));
        return classrooms;
    }

    public ClassroomEntity getById(int id) {
        return classroomRepository.findById(id).get();
    }

    public void addClassroom (ClassroomEntity newClassroom){
        classroomRepository.save(newClassroom);
    }


    public void removeClassroom(int id){
        classroomRepository.deleteById(id);
    }

    public void removeClassroom(ClassroomEntity classroom){
        classroomRepository.delete(classroom);
    }

    public ClassroomEntity editClassroom(ClassroomEntity editClassroom, int id){
        editClassroom.setClassroomId(id);
        classroomRepository.save(editClassroom);
        return editClassroom;
    }

    public List<ClassroomEntity> getByName(String searchQuery) {
        return classroomRepository.getClassroomEntitiesByName(searchQuery);
    }
}
