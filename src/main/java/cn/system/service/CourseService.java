package cn.system.service;

import cn.system.domain.Course;

import java.util.List;

public interface CourseService {
    public List<Course> findCourseAll();
    public Course findCourseById(String CourseId,String CourseTeachId);

}
