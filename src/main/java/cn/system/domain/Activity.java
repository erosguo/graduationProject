package cn.system.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 活动
 */
public class Activity implements Serializable {



    private int ActivityId;
    private String ActivityName;
    private String ActivityIntroduction;
    private String ActivityContent;
    private String ActivityPlace;
    private String ActivityJoinBeginTime;
    private String ActivityJoinEndTime;
    private int ActivityState;
    private int ActivityJoinWay;
    private int ActivityPersonCount;
    private int ActivityPersonMethod;
    private String ActivityType;
    private String ActivityBeginTime;
    private String ActivityEndTime;

    //与参与的学生的多对多关系
    private List<JoinActivity> joinActivityList;

    public List<JoinActivity> getJoinActivityList() {
        return joinActivityList;
    }

    public void setJoinActivityList(List<JoinActivity> joinActivityList) {
        this.joinActivityList = joinActivityList;
    }



    public int getActivityId() {
        return ActivityId;
    }

    public void setActivityId(int activityId) {
        ActivityId = activityId;
    }

    public String getActivityJoinBeginTime() {
        return ActivityJoinBeginTime;
    }

    public void setActivityJoinBeginTime(String activityJoinBeginTime) {
        ActivityJoinBeginTime = activityJoinBeginTime;
    }

    public String getActivityJoinEndTime() {
        return ActivityJoinEndTime;
    }

    public void setActivityJoinEndTime(String activityJoinEndTime) {
        ActivityJoinEndTime = activityJoinEndTime;
    }

    public String getActivityName() {
        return ActivityName;
    }

    public void setActivityName(String activityName) {
        ActivityName = activityName;
    }

    public String getActivityIntroduction() {
        return ActivityIntroduction;
    }

    public void setActivityIntroduction(String activityIntroduction) {
        ActivityIntroduction = activityIntroduction;
    }

    public String getActivityContent() {
        return ActivityContent;
    }

    public void setActivityContent(String activityContent) {
        ActivityContent = activityContent;
    }

    public String getActivityPlace() {
        return ActivityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        ActivityPlace = activityPlace;
    }

    public String getActivityBeginTime() {
        return ActivityBeginTime;
    }

    public void setActivityBeginTime(String activityBeginTime) {
        ActivityBeginTime = activityBeginTime;
    }

    public String getActivityEndTime() {
        return ActivityEndTime;
    }

    public void setActivityEndTime(String activityEndTime) {
        ActivityEndTime = activityEndTime;
    }

    public int getActivityState() {
        return ActivityState;
    }

    public void setActivityState(int activityState) {
        ActivityState = activityState;
    }

    public int getActivityJoinWay() {
        return ActivityJoinWay;
    }

    public void setActivityJoinWay(int activityJoinWay) {
        ActivityJoinWay = activityJoinWay;
    }

    public int getActivityPersonCount() {
        return ActivityPersonCount;
    }

    public void setActivityPersonCount(int activityPersonCount) {
        ActivityPersonCount = activityPersonCount;
    }

    public int getActivityPersonMethod() {
        return ActivityPersonMethod;
    }

    public void setActivityPersonMethod(int activityPersonMethod) {
        ActivityPersonMethod = activityPersonMethod;
    }

    public String getActivityType() {
        return ActivityType;
    }

    public void setActivityType(String activityType) {
        ActivityType = activityType;
    }


    @Override
    public String toString() {
        return "Activity{" +
                "ActivityId=" + ActivityId +
                ", ActivityName='" + ActivityName + '\'' +
                ", ActivityIntroduction='" + ActivityIntroduction + '\'' +
                ", ActivityContent='" + ActivityContent + '\'' +
                ", ActivityPlace='" + ActivityPlace + '\'' +
                ", ActivityJoinBeginTime='" + ActivityJoinBeginTime + '\'' +
                ", ActivityJoinEndTime='" + ActivityJoinEndTime + '\'' +
                ", ActivityState=" + ActivityState +
                ", ActivityJoinWay=" + ActivityJoinWay +
                ", ActivityPersonCount=" + ActivityPersonCount +
                ", ActivityPersonMethod=" + ActivityPersonMethod +
                ", ActivityType='" + ActivityType + '\'' +
                ", ActivityBeginTime='" + ActivityBeginTime + '\'' +
                ", ActivityEndTime='" + ActivityEndTime + '\'' +
                ", joinActivityList=" + joinActivityList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return ActivityId == activity.ActivityId &&
                ActivityState == activity.ActivityState &&
                ActivityJoinWay == activity.ActivityJoinWay &&
                ActivityPersonCount == activity.ActivityPersonCount &&
                ActivityPersonMethod == activity.ActivityPersonMethod &&
                Objects.equals(ActivityName, activity.ActivityName) &&
                Objects.equals(ActivityIntroduction, activity.ActivityIntroduction) &&
                Objects.equals(ActivityContent, activity.ActivityContent) &&
                Objects.equals(ActivityPlace, activity.ActivityPlace) &&
                Objects.equals(ActivityJoinBeginTime, activity.ActivityJoinBeginTime) &&
                Objects.equals(ActivityJoinEndTime, activity.ActivityJoinEndTime) &&
                Objects.equals(ActivityType, activity.ActivityType) &&
                Objects.equals(ActivityBeginTime, activity.ActivityBeginTime) &&
                Objects.equals(ActivityEndTime, activity.ActivityEndTime) &&
                Objects.equals(joinActivityList, activity.joinActivityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ActivityId, ActivityName, ActivityIntroduction, ActivityContent, ActivityPlace, ActivityJoinBeginTime, ActivityJoinEndTime, ActivityState, ActivityJoinWay, ActivityPersonCount, ActivityPersonMethod, ActivityType, ActivityBeginTime, ActivityEndTime, joinActivityList);
    }
}
