package cn.system.service;

import cn.system.domain.Activity;

import java.util.List;

public interface ActivityService {
    public List<Activity> findActivityAll();
    public Activity findActivityActivityById(int Activity);
    public int saveActivity(Activity activity);
    public Activity findActivityBiggestId();
    public int updateActivityStateById(int ActivityId,int ActivityState);
    public int deleteActivity(Activity activity);
    public List<Activity> findActivityActivityByState(int ActivityState);

}
