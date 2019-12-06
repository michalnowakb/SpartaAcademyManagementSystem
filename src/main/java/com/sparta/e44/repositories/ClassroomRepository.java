package com.sparta.e44.repositories;

import com.sparta.e44.entities.ClassroomEntity;
import com.sparta.e44.entities.ModuleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends CrudRepository<ClassroomEntity, Integer> {

    @Query("SELECT a FROM ClassroomEntity a WHERE a.classroomName LIKE CONCAT('%',:name,'%')")
    public List<ClassroomEntity> getClassroomEntitiesByName(@Param("name") String name);
}
