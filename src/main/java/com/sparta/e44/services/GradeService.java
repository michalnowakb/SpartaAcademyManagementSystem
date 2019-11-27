package com.sparta.e44.services;

import com.sparta.e44.entities.GradeEntity;
import com.sparta.e44.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;


    public GradeEntity getById(int gradeId) {

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
}
