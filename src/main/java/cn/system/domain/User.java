package cn.system.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 用户
 */
public class User implements Serializable {

    private String UserId;
    private String UserPassword;
    private String UserName;
    private String UserIntroduction;
    private String UserHobby;
    private String UserEmail;
    private String UserTel;
    private int UserIsEnable;


    //包含belong（社团归属信息的集合）
    //一个用户对应多个联系
    private List<Belong> belongList;

    //用户参与社团讨论
    private List<JoinDiscuss> joinDiscussList;

    //多对多关系，参与活动
    private List<JoinActivity> joinActivityList;

    //多对多关系，选择课程
    private List<Select> selectList;

    public List<Select> getSelectList() {
        return selectList;
    }

    public void setSelectList(List<Select> selectList) {
        this.selectList = selectList;
    }



    public List<JoinActivity> getJoinActivityList() {
        return joinActivityList;
    }

    public void setJoinActivityList(List<JoinActivity> joinActivityList) {
        this.joinActivityList = joinActivityList;
    }



    public List<JoinDiscuss> getJoinDiscussList() {
        return joinDiscussList;
    }

    public void setJoinDiscussList(List<JoinDiscuss> joinDiscussList) {
        this.joinDiscussList = joinDiscussList;
    }



    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserIntroduction() {
        return UserIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        UserIntroduction = userIntroduction;
    }

    public String getUserHobby() {
        return UserHobby;
    }

    public void setUserHobby(String userHobby) {
        UserHobby = userHobby;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserTel() {
        return UserTel;
    }

    public void setUserTel(String userTel) {
        UserTel = userTel;
    }

    public int getUserIsEnable() {
        return UserIsEnable;
    }

    public void setUserIsEnable(int userIsEnable) {
        UserIsEnable = userIsEnable;
    }

    public List<Belong> getBelongList() {
        return belongList;
    }

    public void setBelongList(List<Belong> belongList) {
        this.belongList = belongList;
    }


    @Override
    public String toString() {
        return "User{" +
                "UserId='" + UserId + '\'' +
                ", UserPassword='" + UserPassword + '\'' +
                ", UserName='" + UserName + '\'' +
                ", UserIntroduction='" + UserIntroduction + '\'' +
                ", UserHobby='" + UserHobby + '\'' +
                ", UserEmail='" + UserEmail + '\'' +
                ", UserTel='" + UserTel + '\'' +
                ", UserIsEnable=" + UserIsEnable +
                ", belongList=" + belongList +
                ", joinDiscussList=" + joinDiscussList +
                ", joinActivityList=" + joinActivityList +
                ", selectList=" + selectList +
                '}';
    }


}
