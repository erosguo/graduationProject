package cn.system.domain;

import java.io.Serializable;

/**
 * 用户与课程的选择关系
 */
public class Select implements Serializable {
    private String CourseId;
    private String CourseTeachId;
    private String UserId;

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

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    @Override
    public String toString() {
        return "Select{" +
                "CourseId='" + CourseId + '\'' +
                ", CourseTeachId='" + CourseTeachId + '\'' +
                ", UserId='" + UserId + '\'' +
                '}';
    }
}
