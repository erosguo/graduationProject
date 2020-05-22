package cn.system.domain;

import com.sun.javafx.beans.IDProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 社团
 */
public class Club implements Serializable {



    private int ClubId;
    private String ClubName;
    private String ClubIntroduction;
    private String ClubNotice;
    private int ClubIsEnable;
    private String ClubFile;

    //一对多关系，一个社团拥有多个讨论
    private List<ClubDiscuss> clubDiscusses;


    //一对多关系，一个社团拥有多个活动
    private List<ClubHold> clubHoldList;

    //多对多关系，一个社团存在多个用户
    private List<Belong> belongList;

    public List<Belong> getBelongList() {
        return belongList;
    }

    public void setBelongList(List<Belong> belongList) {
        this.belongList = belongList;
    }

    public List<ClubHold> getClubHoldList() {
        return clubHoldList;
    }

    public void setClubHoldList(List<ClubHold> clubHoldList) {
        this.clubHoldList = clubHoldList;
    }



    public List<ClubDiscuss> getClubDiscusses() {
        return clubDiscusses;
    }

    public void setClubDiscusses(List<ClubDiscuss> clubDiscusses) {
        this.clubDiscusses = clubDiscusses;
    }



    public int getClubId() {
        return ClubId;
    }

    public void setClubId(int clubId) {
        ClubId = clubId;
    }

    public String getClubName() {
        return ClubName;
    }

    public void setClubName(String clubName) {
        ClubName = clubName;
    }

    public String getClubIntroduction() {
        return ClubIntroduction;
    }

    public void setClubIntroduction(String clubIntroduction) {
        ClubIntroduction = clubIntroduction;
    }

    public String getClubNotice() {
        return ClubNotice;
    }

    public void setClubNotice(String clubNotice) {
        ClubNotice = clubNotice;
    }

    public int getClubIsEnable() {
        return ClubIsEnable;
    }

    public void setClubIsEnable(int clubIsEnable) {
        ClubIsEnable = clubIsEnable;
    }

    public String getClubFile() {
        return ClubFile;
    }

    public void setClubFile(String clubFile) {
        ClubFile = clubFile;
    }


    @Override
    public String toString() {
        return "Club{" +
                "ClubId=" + ClubId +
                ", ClubName='" + ClubName + '\'' +
                ", ClubIntroduction='" + ClubIntroduction + '\'' +
                ", ClubNotice='" + ClubNotice + '\'' +
                ", ClubIsEnable=" + ClubIsEnable +
                ", ClubFile='" + ClubFile + '\'' +
                ", clubDiscusses=" + clubDiscusses +
                ", clubHoldList=" + clubHoldList +
                ", belongList=" + belongList +
                '}';
    }



}
