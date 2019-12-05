package com.sparta.e44.repositories;

import com.sparta.e44.entities.TeachingGroupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachingGroupRepository extends CrudRepository<TeachingGroupEntity,Integer> {
    @Query("SELECT g FROM TeachingGroupEntity g WHERE (g.groupName) LIKE CONCAT('%',:groupName,'%')")
    public List<TeachingGroupEntity> getTeachingGroupEntityByGroupName(@Param("groupName") String groupName);

    @Query("SELECT g FROM TeachingGroupEntity g WHERE g.groupName LIKE :groupName")
    public List<TeachingGroupEntity> getTeachingGroupByName(@Param("groupName") String groupName);
}
