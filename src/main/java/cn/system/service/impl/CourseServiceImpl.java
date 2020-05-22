package cn.system.service.impl;

import cn.system.dao.CourseDao;
import cn.system.domain.Course;
import cn.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> findCourseAll() {
        return courseDao.findCourseAll();
    }

    @Override
    public Course findCourseById(String CourseId, String CourseTeachId) {
        return courseDao.findCourseById(CourseId,CourseTeachId);
    }
}
