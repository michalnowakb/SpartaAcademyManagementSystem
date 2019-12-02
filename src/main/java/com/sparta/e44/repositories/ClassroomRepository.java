package com.sparta.e44.repositories;

import com.sparta.e44.entities.ClassroomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends CrudRepository<ClassroomEntity, Integer> {
}
