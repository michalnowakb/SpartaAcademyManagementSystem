package com.sparta.e44.services;

import com.sparta.e44.entities.GradeEntity;
import com.sparta.e44.entities.GradeId;
import com.sparta.e44.entities.ModuleEntity;
import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.entities.holders.GradeHolder;
import com.sparta.e44.repositories.GradeRepository;
import com.sparta.e44.repositories.ModuleRepository;
import com.sparta.e44.repositories.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private TraineeRepository traineeRepository;
    @Autowired
    private ModuleRepository moduleRepository;

    public GradeEntity getById(int traineeId, int moduleId) {
        TraineeEntity trainee = traineeRepository.findById(traineeId).get();
        ModuleEntity module = moduleRepository.findById(moduleId).get();
        GradeId gradeId = new GradeId(trainee,module);
        return gradeRepository.findById(gradeId).get();
    }

    public void addGrade(GradeEntity newGrade){
        gradeRepository.save(newGrade);
    }


    public List<GradeEntity> getAllGrades() {
        ArrayList<GradeEntity> grades = new ArrayList<>();
        gradeRepository.findAll().forEach(g->grades.add(g));
        return grades;
    }

    public void addGrade(GradeHolder gradeHolder){
        int traineeId = gradeHolder.getTraineeId();
        int moduleId = gradeHolder.getModuleId();
        String grade = gradeHolder.getGrade();
        GradeEntity newGrade = getGrade(grade,traineeId,moduleId);
        gradeRepository.save(newGrade);
    }

    public void removeGrade(int traineeId, int moduleId) {
        TraineeEntity trainee = traineeRepository.findById(traineeId).get();
        ModuleEntity module = moduleRepository.findById(moduleId).get();
        GradeId gradeId = new GradeId(trainee,module);
        gradeRepository.deleteById(gradeId);
    }
    public void removeGrade(GradeEntity toRemove){
        gradeRepository.delete(toRemove);
    }

    public GradeEntity editGrade(String grade, int traineeId, int moduleId) {
        GradeEntity newGrade = getGrade(grade,traineeId,moduleId);
        gradeRepository.save(newGrade);
        return newGrade;
    }

    public void addGrade(String grade, int traineeId, int moduleId){
        GradeEntity newGrade = getGrade(grade,traineeId,moduleId);
        gradeRepository.save(newGrade);
    }


    private GradeEntity getGrade(String grade, int traineeId, int moduleId){
        TraineeEntity trainee = traineeRepository.findById(traineeId).get();
        ModuleEntity module = moduleRepository.findById(moduleId).get();
        GradeId gradeId = new GradeId(trainee,module);
        GradeEntity newGrade = new GradeEntity(gradeId,grade);
        return newGrade;
    }
}
