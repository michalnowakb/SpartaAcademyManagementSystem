package com.sparta.e44.repositories;

import com.sparta.e44.entities.TeachingGroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingGroupRepository extends CrudRepository<TeachingGroupEntity,Integer> {
}
