package cn.system.domain;

import java.io.Serializable;

/**
 * 社团管理员
 */
public class ClubManager implements Serializable {
    private String ClubManagerId;
    private int ClubId;



    private String ClubManagerPassword;
    private String ClubManagerName;
    private String ClubManagerTel;
    private String ClubManagerEmail;

    //一个社团管理员只能管理一个社团
    private Club Club;

    public String getClubManagerId() {
        return ClubManagerId;
    }

    public void setClubManagerId(String clubManagerId) {
        ClubManagerId = clubManagerId;
    }

    public int getClubId() {
        return ClubId;
    }

    public void setClubId(int clubId) {
        ClubId = clubId;
    }

    public String getClubManagerPassword() {
        return ClubManagerPassword;
    }

    public void setClubManagerPassword(String clubManagerPassword) {
        ClubManagerPassword = clubManagerPassword;
    }

    public String getClubManagerName() {
        return ClubManagerName;
    }

    public void setClubManagerName(String clubManagerName) {
        ClubManagerName = clubManagerName;
    }

    public String getClubManagerTel() {
        return ClubManagerTel;
    }

    public void setClubManagerTel(String clubManagerTel) {
        ClubManagerTel = clubManagerTel;
    }

    public String getClubManagerEmail() {
        return ClubManagerEmail;
    }

    public void setClubManagerEmail(String clubManagerEmail) {
        ClubManagerEmail = clubManagerEmail;
    }

    public cn.system.domain.Club getClub() {
        return Club;
    }

    public void setClub(cn.system.domain.Club club) {
        Club = club;
    }

    @Override
    public String toString() {
        return "ClubManager{" +
                "ClubManagerId='" + ClubManagerId + '\'' +
                ", ClubId=" + ClubId +
                ", ClubManagerPassword='" + ClubManagerPassword + '\'' +
                ", ClubManagerName='" + ClubManagerName + '\'' +
                ", ClubManagerTel='" + ClubManagerTel + '\'' +
                ", ClubManagerEmail='" + ClubManagerEmail + '\'' +
                ", Club=" + Club +
                '}';
    }
}
