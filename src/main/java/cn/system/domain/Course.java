package cn.system.domain;

import java.io.Serializable;

/**
 * 课程
 */
public class Course implements Serializable {
    private String CourseId;
    private String CourseTeachId;
    private int CourseWeek;
    private int CourseWeekDay;
    private int CourseTeach;
    private String CoursePlace;


    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public String getCourseTeachId() {
        return CourseTeachId;
    }

    public void setCourseTeachId(String courseTeachId) {
        CourseTeachId = courseTeachId;
    }

    public int getCourseWeek() {
        return CourseWeek;
    }

    public void setCourseWeek(int courseWeek) {
        CourseWeek = courseWeek;
    }

    public int getCourseWeekDay() {
        return CourseWeekDay;
    }

    public void setCourseWeekDay(int courseWeekDay) {
        CourseWeekDay = courseWeekDay;
    }

    public int getCourseTeach() {
        return CourseTeach;
    }

    public void setCourseTeach(int courseTeach) {
        CourseTeach = courseTeach;
    }

    public String getCoursePlace() {
        return CoursePlace;
    }

    public void setCoursePlace(String coursePlace) {
        CoursePlace = coursePlace;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CourseId='" + CourseId + '\'' +
                ", CourseTeachId='" + CourseTeachId + '\'' +
                ", CourseWeek=" + CourseWeek +
                ", CourseWeekDay=" + CourseWeekDay +
                ", CourseTeach=" + CourseTeach +
                ", CoursePlace='" + CoursePlace + '\'' +
                '}';
    }

}
