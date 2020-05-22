package cn.system.dao;

import cn.system.domain.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface CourseDao {
    @Select("select * from SYSTEM_COURSE")
    @Results(id="Course",value = {
            @Result(id = true,column="CourseId",property="CourseId"),
            @Result(id = true,column = "CourseTeachId",property = "CourseTeachId"),
            @Result(column = "CourseWeek",property = "CourseWeek"),
            @Result(column = "CourseWeekDay",property = "CourseWeekDay"),
            @Result(column = "CourseTeach",property = "CourseTeach"),
            @Result(column = "CoursePlace",property = "CoursePlace")
    })
    public List<Course> findCourseAll();

    @Select("select * from SYSTEM_COURSE where CourseId=#{CourseId} and CourseTeachId=#{CourseTeachId}")
    @ResultMap("Course")
    public Course findCourseById(@Param("CourseId")String CourseId,@Param("CourseTeachId")String CourseTeachId);


}
