package cn.system.utils;

import cn.system.domain.User;

public class UserApplyActivityUtil {
    public User user;
    public int activityState;
    public int activityPersonCount;
    public int activityCurrentCount;
    public int activityId;
    public String activityName;
    public  int joinState;
    public int getJoinState() {
        return joinState;
    }

    public void setJoinState(int joinState) {
        this.joinState = joinState;
    }


    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getActivityState() {
        return activityState;
    }

    public void setActivityState(int activityState) {
        this.activityState = activityState;
    }

    public int getActivityPersonCount() {
        return activityPersonCount;
    }

    public void setActivityPersonCount(int activityPersonCount) {
        this.activityPersonCount = activityPersonCount;
    }

    public int getActivityCurrentCount() {
        return activityCurrentCount;
    }

    public void setActivityCurrentCount(int activityCurrentCount) {
        this.activityCurrentCount = activityCurrentCount;
    }







}
