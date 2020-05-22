package cn.system.utils;

import cn.system.domain.Activity;

public class ActivityUtil{


    private Activity activity;
    private int isUserJoin;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getIsUserJoin() {
        return isUserJoin;
    }

    public void setIsUserJoin(int isUserJoin) {
        this.isUserJoin = isUserJoin;
    }

    @Override
    public String toString() {
        return "ActivityUtil{" +
                "activity=" + activity +
                ", isUserJoin=" + isUserJoin +
                '}';
    }

}
