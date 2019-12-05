package com.sparta.e44.repositories;

import com.sparta.e44.entities.AttendanceEntity;
import com.sparta.e44.entities.AttendanceId;
import com.sparta.e44.entities.TraineeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends CrudRepository<AttendanceEntity, AttendanceId> {

   @Query("SELECT a FROM AttendanceEntity a WHERE a.attendanceId.trainee = :trainee ORDER BY a.attendanceId.date ASC")
    public List<AttendanceEntity> findAttendanceEntitiesByTrainee(@Param("trainee")TraineeEntity traineeEntity);

}
