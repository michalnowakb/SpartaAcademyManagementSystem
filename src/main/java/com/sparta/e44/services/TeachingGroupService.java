package com.sparta.e44.services;

import com.sparta.e44.controllers.CourseController;
import com.sparta.e44.entities.*;
import com.sparta.e44.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeachingGroupService {

    @Autowired
    private TeachingGroupRepository teachingGroupRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<TeachingGroupEntity> getAllTeachingGroups(){
        List<TeachingGroupEntity> teachingGroups = new ArrayList<>();
        teachingGroupRepository.findAll().forEach(teachingGroup -> teachingGroups.add(teachingGroup));
        return teachingGroups;
    }

    public TeachingGroupEntity getTeachingGroup(int teachingGroupId){
        return teachingGroupRepository.findById(teachingGroupId).get();
    }

    public void addTeachingGroup (TeachingGroupEntity teachingGroupEntity){
        teachingGroupRepository.save(teachingGroupEntity);
    }

    public void removeTeachingGroup(int id){
        teachingGroupRepository.deleteById(id);
    }

    public TeachingGroupEntity editTeachingGroup(TeachingGroupEntity teachingGroup, int id){
        teachingGroup.setGroupId(id);
        teachingGroupRepository.save(teachingGroup);
        return teachingGroup;
    }

//    public void removeTeachingGroup(TeachingGroupEntity group){
//        teachingGroupRepository.delete(group);
//    }


    //---addTrainerAction/removeTrainerAction---//

    public void addTrainer(int teachingGroupId, int trainerId){
        TeachingGroupEntity teachingGroup = teachingGroupRepository.findById(teachingGroupId).get();
        TrainerEntity trainer = trainerRepository.findById(trainerId).get();
        addTrainerAction(teachingGroup,trainer);
    }

    public void addTrainerAction(TeachingGroupEntity teachingGroup, TrainerEntity trainer){
        teachingGroup.addTrainer(trainer);
        teachingGroupRepository.save(teachingGroup);
    }

    public void removeTrainer(int teachingGroupId, int trainerId){
        TeachingGroupEntity teachingGroup = teachingGroupRepository.findById(teachingGroupId).get();
        TrainerEntity trainer = trainerRepository.findById(trainerId).get();
        removeTrainerAction(teachingGroup,trainer);
    }

    public void removeTrainerAction(TeachingGroupEntity teachingGroup, TrainerEntity trainer){
        teachingGroup.removeTrainer(trainer);
        teachingGroupRepository.save(teachingGroup);
    }


    //--- addClassroomAction/removeClassroomAction---//

    public TeachingGroupEntity removeClassroom(int groupId){
        TeachingGroupEntity group = teachingGroupRepository.findById(groupId).get();
        return removeClassroomAction(group);
    }

    public TeachingGroupEntity removeClassroomAction(TeachingGroupEntity group){
        group.setClassroomEntity(null);
        teachingGroupRepository.save(group);
        return group;
    }

    public TeachingGroupEntity addClassroom(int groupId, int classroomId){
        ClassroomEntity newRoom = classroomRepository.findById(classroomId).get();
        TeachingGroupEntity group = teachingGroupRepository.findById(groupId).get();
        return addClassroomAction(group,newRoom);
    }

    public TeachingGroupEntity addClassroomAction(TeachingGroupEntity group, ClassroomEntity newRoom){
        group.setClassroomEntity(newRoom);
        teachingGroupRepository.save(group);
        return group;
    }

    //---addTrainee/removeTrainee---//

    public TeachingGroupEntity addTrainee (int groupId, int traineeId){
        TraineeEntity newTrainee = traineeRepository.findById(traineeId).get();
        TeachingGroupEntity group = teachingGroupRepository.findById(groupId).get();
        return addTraineeAction(group,newTrainee);

    }
    public TeachingGroupEntity addTraineeAction(TeachingGroupEntity group, TraineeEntity newTrainee){
        group.addTrainee(newTrainee);
        teachingGroupRepository.save(group);
        return group;
    }

    public TeachingGroupEntity removeTrainee(int groupId, int traineeId){
        TeachingGroupEntity group = teachingGroupRepository.findById(groupId).get();
        TraineeEntity trainee = traineeRepository.findById(traineeId).get();
        return removeTraineeAction(group, trainee);
    }

    public TeachingGroupEntity removeTraineeAction(TeachingGroupEntity group, TraineeEntity trainee){
        group.removeTrainee(trainee);
        teachingGroupRepository.save(group);
        return group;
    }

    //---addCourse/removeCourse---//
   public TeachingGroupEntity addCourse(int groupId, int courseId){
       CourseEntity newCourse = courseRepository.findById(courseId).get();
       TeachingGroupEntity group=teachingGroupRepository.findById(groupId).get();
       return addCourseAction(group,newCourse);
   }

   public TeachingGroupEntity addCourseAction(TeachingGroupEntity group, CourseEntity newCourse){
        group.setCourse(newCourse);
        teachingGroupRepository.save(group);
        return group;
   }

    public TeachingGroupEntity removeCourse(int groupId){
        TeachingGroupEntity group = teachingGroupRepository.findById(groupId).get();
        return removeCourseAction(group);
    }

    public TeachingGroupEntity removeCourseAction(TeachingGroupEntity group){
        group.setCourse(null);
        teachingGroupRepository.save(group);
        return group;
    }
}
