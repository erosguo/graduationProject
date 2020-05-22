package cn.system.domain;

import java.io.Serializable;

public class Belong implements Serializable {
    private String UserId;
    private int ClubId;
    private int BelongIsEnable;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public int getClubId() {
        return ClubId;
    }

    public void setClubId(int clubId) {
        ClubId = clubId;
    }

    public int getBelongIsEnable() {
        return BelongIsEnable;
    }

    public void setBelongIsEnable(int belongIsEnable) {
        BelongIsEnable = belongIsEnable;
    }


    @Override
    public String toString() {
        return "Belong{" +
                "UserId='" + UserId + '\'' +
                ", ClubId=" + ClubId +
                ", BelongIsEnable=" + BelongIsEnable +
                '}';
    }
}
