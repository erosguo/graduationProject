package cn.system.service;

import cn.system.domain.ActivityPlace;

import java.util.List;

public interface ActivityPlaceService {

    public List<ActivityPlace> findActivityPlaceAll();
    public int saveActivityPlace(ActivityPlace activityPlace);
    public List<ActivityPlace> findActivityPlaceInvalidAll();
    public List<ActivityPlace> findActivityPlaceValidAll();
    public List<ActivityPlace> findActivityPlaceByWeekAndValue(int ActivityPlaceWeek,int ActivityPlaceIsEnable);
    public int updateActivityPlaceIsValid(String ActivityPlaceId,int ActivityPlaceIsEnable);
    public int deleteActivityPlace(String ActivityPlaceId);

}
