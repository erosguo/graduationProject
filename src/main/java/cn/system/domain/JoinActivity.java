package cn.system.domain;

import java.io.Serializable;

/**
 * 用户与活动的关系
 */
public class JoinActivity implements Serializable {

    private int ActivityId;
    private String UserId;
    private int JoinActivityIsSuccess;

    @Override
    public String toString() {
        return "JoinActivity{" +
                "ActivityId='" + ActivityId + '\'' +
                ", UserId='" + UserId + '\'' +
                ", JoinActivityIsSuccess=" + JoinActivityIsSuccess +
                '}';
    }



    public int getJoinActivityIsSuccess() {
        return JoinActivityIsSuccess;
    }

    public void setJoinActivityIsSuccess(int joinActivityIsSuccess) {
        JoinActivityIsSuccess = joinActivityIsSuccess;
    }


    public int getActivityId() {
        return ActivityId;
    }

    public void setActivityId(int activityId) {
        ActivityId = activityId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }



}
