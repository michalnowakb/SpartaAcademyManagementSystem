package com.sparta.e44.repositories;

import com.sparta.e44.entities.TimeslotEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeslotRepository extends CrudRepository<TimeslotEntity,Integer> {
}
