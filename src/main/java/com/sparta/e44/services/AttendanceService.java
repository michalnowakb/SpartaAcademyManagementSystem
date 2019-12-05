package com.sparta.e44.services;

import com.sparta.e44.entities.AttendanceEntity;
import com.sparta.e44.entities.AttendanceId;
import com.sparta.e44.entities.GradeId;
import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.repositories.AttendanceRepository;
import com.sparta.e44.repositories.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private TraineeRepository traineeRepository;

    public List<AttendanceEntity> getAll(){
        List<AttendanceEntity> attendances = new ArrayList<>();
        attendanceRepository.findAll().forEach(attendance -> attendances.add(attendance));
        return attendances;
    }

    public AttendanceEntity getById(AttendanceId id){
        return attendanceRepository.findById(id).get();
    }

    public void addAttendance(int traineeId, LocalDate date, boolean isPresent){
        AttendanceId newAttendanceId = new AttendanceId(traineeRepository.findById(traineeId).get(),date);
        AttendanceEntity newAttendance = new AttendanceEntity(isPresent,newAttendanceId);
        attendanceRepository.save(newAttendance);
    }

    public List<AttendanceEntity> getAttendances(TraineeEntity trainee){
        return attendanceRepository.findAttendanceEntitiesByTrainee(trainee);
    }

    public void addAttendance(Collection<AttendanceEntity> attendance) {
        attendanceRepository.saveAll(attendance);
    }
}
