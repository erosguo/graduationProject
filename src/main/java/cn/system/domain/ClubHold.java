package cn.system.domain;

import java.io.Serializable;

public class ClubHold implements Serializable {
    private int ClubId;
    private int ActivityId;

    public int getClubId() {
        return ClubId;
    }

    public void setClubId(int clubId) {
        ClubId = clubId;
    }

    public int getActivityId() {
        return ActivityId;
    }

    public void setActivityId(int activityId) {
        ActivityId = activityId;
    }


    @Override
    public String toString() {
        return "ClubHold{" +
                "ClubId=" + ClubId +
                ", ActivityId=" + ActivityId +
                '}';
    }


}
