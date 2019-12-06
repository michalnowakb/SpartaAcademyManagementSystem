package com.sparta.e44.repositories;

import com.sparta.e44.entities.CourseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {

    @Query("SELECT a FROM CourseEntity a WHERE a.courseName LIKE CONCAT('%',:name,'%')")
    public List<CourseEntity> getCourseEntitiesByName(@Param("name") String name);

}
