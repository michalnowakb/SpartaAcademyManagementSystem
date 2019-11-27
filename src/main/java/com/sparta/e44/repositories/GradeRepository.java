package com.sparta.e44.repositories;

import com.sparta.e44.entities.GradeEntity;
import com.sparta.e44.entities.GradeId;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<GradeEntity, GradeId> {
}
