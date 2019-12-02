package com.sparta.e44.repositories;

import com.sparta.e44.entities.TrainerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends CrudRepository<TrainerEntity, Integer> {
}
