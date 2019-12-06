package com.sparta.e44.repositories;

import com.sparta.e44.entities.CourseEntity;
import com.sparta.e44.entities.ModuleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends CrudRepository<ModuleEntity,Integer> {

    @Query("SELECT a FROM ModuleEntity a WHERE a.moduleName LIKE CONCAT('%',:name,'%')")
    public List<ModuleEntity> getModuleEntitiesByName(@Param("name") String name);

}
