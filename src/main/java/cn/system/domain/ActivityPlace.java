package cn.system.domain;

/**
 * 活动地点
 */
public class ActivityPlace {

    private String ActivityPlaceId;
    private String ActivityPlaceName;
    private int ActivityPlaceWeek;
    private int ActivityPlaceWeekDay;
    private int ActivityPlaceTeach;
    private int ActivityPlaceIsEnable;

    public String getActivityPlaceId() {
        return ActivityPlaceId;
    }

    public void setActivityPlaceId(String activityPlaceId) {
        ActivityPlaceId = activityPlaceId;
    }

    public String getActivityPlaceName() {
        return ActivityPlaceName;
    }

    public void setActivityPlaceName(String activityPlaceName) {
        ActivityPlaceName = activityPlaceName;
    }

    public int getActivityPlaceWeek() {
        return ActivityPlaceWeek;
    }

    public void setActivityPlaceWeek(int activityPlaceWeek) {
        ActivityPlaceWeek = activityPlaceWeek;
    }

    public int getActivityPlaceWeekDay() {
        return ActivityPlaceWeekDay;
    }

    public void setActivityPlaceWeekDay(int activityPlaceWeekDay) {
        ActivityPlaceWeekDay = activityPlaceWeekDay;
    }

    public int getActivityPlaceTeach() {
        return ActivityPlaceTeach;
    }

    public void setActivityPlaceTeach(int activityPlaceTeach) {
        ActivityPlaceTeach = activityPlaceTeach;
    }

    public int getActivityPlaceIsEnable() {
        return ActivityPlaceIsEnable;
    }

    public void setActivityPlaceIsEnable(int activityPlaceIsEnable) {
        ActivityPlaceIsEnable = activityPlaceIsEnable;
    }


    @Override
    public String toString() {
        return "ActivityPlace{" +
                "ActivityPlaceId='" + ActivityPlaceId + '\'' +
                ", ActivityPlaceName='" + ActivityPlaceName + '\'' +
                ", ActivityPlaceWeek=" + ActivityPlaceWeek +
                ", ActivityPlaceWeekDay=" + ActivityPlaceWeekDay +
                ", ActivityPlaceTeach=" + ActivityPlaceTeach +
                ", ActivityPlaceIsEnable=" + ActivityPlaceIsEnable +
                '}';
    }

}
