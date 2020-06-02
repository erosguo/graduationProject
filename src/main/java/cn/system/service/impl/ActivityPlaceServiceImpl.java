package cn.system.service.impl;

import cn.system.dao.ActivityPlaceDao;
import cn.system.domain.ActivityPlace;
import cn.system.service.ActivityPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ActivityPlaceService")
public class ActivityPlaceServiceImpl implements ActivityPlaceService {
    @Autowired
    private ActivityPlaceDao activityPlaceDao;
    @Override
    public List<ActivityPlace> findActivityPlaceAll() {
        return activityPlaceDao.findActivityPlaceAll();
    }

    @Override
    public int saveActivityPlace(ActivityPlace activityPlace) {
        return activityPlaceDao.saveActivityPlace(activityPlace);
    }

    @Override
    public List<ActivityPlace> findActivityPlaceInvalidAll() {
        return activityPlaceDao.findActivityPlaceInvalidAll();
    }

    @Override
    public List<ActivityPlace> findActivityPlaceValidAll() {
        return activityPlaceDao.findActivityPlaceValidAll();
    }

    @Override
    public List<ActivityPlace> findActivityPlaceByWeekAndValue(int ActivityPlaceWeek, int ActivityPlaceIsEnable) {
        return activityPlaceDao.findActivityPlaceByWeekAndValue(ActivityPlaceWeek,ActivityPlaceIsEnable);
    }


    @Override
    public int updateActivityPlaceIsValid(String ActivityPlaceId, int ActivityPlaceIsEnable) {
        return activityPlaceDao.updateActivityPlaceIsValid(ActivityPlaceId,ActivityPlaceIsEnable);
    }

    @Override
    public int deleteActivityPlace(String ActivityPlaceId) {
        return activityPlaceDao.deleteActivityPlace(ActivityPlaceId);
    }

}
