package com.sparta.e44.repositories;

import com.sparta.e44.entities.TraineeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends CrudRepository<TraineeEntity, Integer> {
}
