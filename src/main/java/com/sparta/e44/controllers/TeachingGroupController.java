package com.sparta.e44.controllers;

import com.sparta.e44.entities.TeachingGroupEntity;
import com.sparta.e44.services.TeachingGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeachingGroupController {

    @Autowired
    private TeachingGroupService teachingGroupService;

    @GetMapping("/teachingGroups/getTeachingGroups")
    public List<TeachingGroupEntity> getTeachingGroups(){
        return teachingGroupService.getAllTeachingGroups();
    }

    @GetMapping("/teachingGroups/getTeachingGroup/{id}")
    public TeachingGroupEntity getTeachingGroup(@PathVariable int id){
        return teachingGroupService.getTeachingGroup(id);
    }

    @PostMapping("/teachingGroup/addTeachingGroup")
    public String addTeachingGroup(@RequestBody TeachingGroupEntity teachingGroup){
        teachingGroupService.addTeachingGroup(teachingGroup);
        return "Added module";
    }

    @PutMapping("/teachingGroup/editTeachingGroup/{id}")
    public TeachingGroupEntity editTeachingGroup(@RequestBody TeachingGroupEntity teachingGroup, @PathVariable int id){
        teachingGroupService.editTeachingGroup(teachingGroup,id);
        return teachingGroupService.getTeachingGroup(id);
    }

    @DeleteMapping("/teachingGroup/removeTeachingGroup/{id}")
    public void removeTeachingGroup(@PathVariable int id){
        teachingGroupService.removeTeachingGroup(id);
    }
}
