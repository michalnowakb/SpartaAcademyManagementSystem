package com.sparta.e44.controllers;

import com.sparta.e44.entities.TeachingGroupEntity;
import com.sparta.e44.services.TeachingGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
public class TeachingGroupController {

    @Autowired
    private TeachingGroupService teachingGroupService;

    @GetMapping("/teachingGroups/getTeachingGroups")
    public String getTeachingGroups(Model model){
       model.addAttribute("teachingGroups" ,teachingGroupService.getAllTeachingGroups());
        return "";
    }

    @GetMapping("/teachingGroup/getTeachingGroup/{id}")
    public String getTeachingGroup(@PathVariable("id") int id, Model model){
        model.addAttribute("teachingGroup",teachingGroupService.getTeachingGroup(id));
        return "";
    }

    @PostMapping("/teachingGroup/addTeachingGroup")
    public String addTeachingGroup(@Valid TeachingGroupEntity teachingGroup){
        teachingGroupService.addTeachingGroup(teachingGroup);
        return "";
    }

    @GetMapping("/teachingGroup/editTeachingGroup/{id}")
    public String editTeachingGroup(@PathVariable("id") int id, @Valid TeachingGroupEntity teachingGroup){
        teachingGroupService.editTeachingGroup(teachingGroup,id);
        return "";
    }

    @GetMapping("/teachingGroup/removeTeachingGroup/{id}")
    public String removeTeachingGroup(@PathVariable("id") int id){
        teachingGroupService.removeTeachingGroup(id);
        return "";
    }


    //---addClassroom/removeClassroom---//
    @PutMapping("/teachingGroup/addClassroom/{groupId}/{classroomId}")
    public String addClassroom(@PathVariable("groupId") int groupId, @PathVariable("classroomId") int classroomId){
        teachingGroupService.addClassroom(groupId,classroomId);
        return "";
    }

    @PutMapping("/teachingGroup/removeClassroom/{id}")
    public String removeClassroom(@PathVariable("id") int id){
        teachingGroupService.removeClassroom(id);
        return "";
    }

    //---addTrainee/removeTrainee---//
    @PutMapping("/teachingGroup/addTrainee/{groupId}/{traineeId}")
    public String addTrainee(@PathVariable("groupId") int groupId, @PathVariable("traineeId") int traineeId){
        teachingGroupService.addTrainee(groupId,traineeId);
        return "";
    }

    @GetMapping("/teachingGroup/removeTrainee/{groupId}/{traineeId}")
    public String removeTrainee(@PathVariable("groupId") int groupId, @PathVariable("traineeId") int traineeId){
        teachingGroupService.removeTrainee(groupId,traineeId);
        return "";
    }

    //---addCourse/removeCourse---//
    @PutMapping("/teachingGroup/addCourse/{groupId}/{courseId}")
    public String addCourse(@PathVariable("groupId") int groupId, @PathVariable("courseId") int courseId){
        teachingGroupService.addCourse(groupId,courseId);
        return "";
    }

    @GetMapping("/teachingGroup/removeCourse/{groupId}")
    public String removeCourse(@PathVariable("groupId") int groupId){
        teachingGroupService.removeCourse(groupId);
        return "";
    }
}
