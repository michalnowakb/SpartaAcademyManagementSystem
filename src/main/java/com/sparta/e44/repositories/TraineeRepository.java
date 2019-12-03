package com.sparta.e44.repositories;

import com.sparta.e44.entities.TraineeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository extends CrudRepository<TraineeEntity, Integer> {

    @Query("SELECT a FROM TraineeEntity a WHERE CONCAT(a.firstName,' ',a.lastName) LIKE CONCAT('%',:name,'%')")
    public List<TraineeEntity> getTraineeEntitiesByName(@Param("name") String name);

}
