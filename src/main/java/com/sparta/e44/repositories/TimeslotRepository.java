package com.sparta.e44.repositories;

import com.sparta.e44.entities.CourseEntity;
import com.sparta.e44.entities.TimeslotEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeslotRepository extends CrudRepository<TimeslotEntity,Integer> {

    @Query("SELECT a.capacity FROM classroom_entity a WHERE a.classroom_name = :classroomName")
    public int getCapacityByName(@Param("classroomName") String classroomName);

}
