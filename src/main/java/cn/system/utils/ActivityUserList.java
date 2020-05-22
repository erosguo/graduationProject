package cn.system.utils;

import cn.system.domain.Activity;

import java.util.List;

public class ActivityUserList {
    public List<UserApplyActivityUtil> userApplyActivityUtilList;
    public Activity activity;
    public List<UserApplyActivityUtil> getUserApplyActivityUtilList() {
        return userApplyActivityUtilList;
    }

    public void setUserApplyActivityUtilList(List<UserApplyActivityUtil> userApplyActivityUtilList) {
        this.userApplyActivityUtilList = userApplyActivityUtilList;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }


}
