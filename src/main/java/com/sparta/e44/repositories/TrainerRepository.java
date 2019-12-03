package com.sparta.e44.repositories;

import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.entities.TrainerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends CrudRepository<TrainerEntity, Integer> {

    @Query("SELECT a FROM TrainerEntity a WHERE CONCAT(a.firstName,' ',a.lastName) LIKE CONCAT('%',:name,'%')")
    public List<TrainerEntity> getTrainerEntitiesByName(@Param("name") String name);
}
