package cn.system.domain;

import java.io.Serializable;

/**
 * 用户创建活动关系
 */
public class PersonHold implements Serializable {
    private String UserId;
    private int ActivityId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public int getActivityId() {
        return ActivityId;
    }

    public void setActivityId(int activityId) {
        ActivityId = activityId;
    }

    @Override
    public String toString() {
        return "PersonHold{" +
                "UserId='" + UserId + '\'' +
                ", ActivityId='" + ActivityId + '\'' +
                '}';
    }
}
