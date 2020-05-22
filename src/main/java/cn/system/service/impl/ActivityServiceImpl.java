package cn.system.service.impl;

import cn.system.dao.ActivityDao;
import cn.system.domain.Activity;
import cn.system.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ActivityService")
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;
    @Override
    public List<Activity> findActivityAll() {
        return activityDao.findActivityAll();
    }

    @Override
    public Activity findActivityActivityById(int Activity) {
        return activityDao.findActivityActivityById(Activity);
    }

    @Override
    public int saveActivity(Activity activity) {
        return activityDao.saveActivity(activity);
    }

    @Override
    public Activity findActivityBiggestId() {
        return activityDao.findActivityBiggestId();
    }

    @Override
    public int updateActivityStateById(int ActivityId, int ActivityState) {
        return activityDao.updateActivityStateById(ActivityId,ActivityState);
    }

    @Override
    public int deleteActivity(Activity activity) {
        return activityDao.deleteActivity(activity);
    }

    @Override
    public List<Activity> findActivityActivityByState(int ActivityState) {
        return activityDao.findActivityActivityByState(ActivityState);
    }
}
