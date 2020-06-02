package cn.system.dao;

import cn.system.domain.ActivityPlace;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityPlaceDao {
    @Select("select * from SYSTEM_ACTIVITYPLACE")
    @Results(id="ActivityPlace",value = {
            @Result(id = true,column="ActivityPlaceId",property="ActivityPlaceId"),
            @Result(column = "ActivityPlaceName",property = "ActivityPlaceName"),
            @Result(column = "ActivityPlaceWeek",property = "ActivityPlaceWeek"),
            @Result(column = "ActivityPlaceWeekDay",property = "ActivityPlaceWeekDay"),
            @Result(column = "ActivityPlaceTeach",property = "ActivityPlaceTeach"),
            @Result(column = "ActivityPlaceIsEnable",property = "ActivityPlaceIsEnable")
    })
    public List<ActivityPlace> findActivityPlaceAll();

    @Select("select * from SYSTEM_ACTIVITYPLACE where ActivityPlaceIsEnable=1")
    @ResultMap("ActivityPlace")
    public List<ActivityPlace> findActivityPlaceValidAll();

    @Select("select * from SYSTEM_ACTIVITYPLACE where ActivityPlaceIsEnable=0")
    @ResultMap("ActivityPlace")
    public List<ActivityPlace> findActivityPlaceInvalidAll();

    @Select("select * from SYSTEM_ACTIVITYPLACE where ActivityPlaceWeek=#{ActivityPlaceWeek} and ActivityPlaceIsEnable=#{ActivityPlaceIsEnable}")
    @ResultMap("ActivityPlace")
    public List<ActivityPlace> findActivityPlaceByWeekAndValue(@Param("ActivityPlaceWeek")int ActivityPlaceWeek,@Param("ActivityPlaceIsEnable")int ActivityPlaceIsEnable);

    @Update("update SYSTEM_ACTIVITYPLACE set ActivityPlaceIsEnable=#{ActivityPlaceIsEnable} where ActivityPlaceId=#{ActivityPlaceId}")
    @ResultMap("ActivityPlace")
    public int updateActivityPlaceIsValid(@Param("ActivityPlaceId")String ActivityPlaceId,@Param("ActivityPlaceIsEnable")int ActivityPlaceIsEnable);


    @Insert("insert into SYSTEM_ACTIVITYPLACE(ActivityPlaceId,ActivityPlaceName,ActivityPlaceWeek,ActivityPlaceWeekDay,ActivityPlaceTeach,ActivityPlaceIsEnable) " +
            "values(#{ActivityPlaceId},#{ActivityPlaceName},#{ActivityPlaceWeek},#{ActivityPlaceWeekDay},#{ActivityPlaceTeach},#{ActivityPlaceIsEnable})")
    @ResultMap("ActivityPlace")
    public int saveActivityPlace(ActivityPlace activityPlace);

    @Delete("delete from SYSTEM_ACTIVITYPLACE where ActivityPlaceId=#{ActivityPlaceId}")
    @ResultMap("ActivityPlace")
    public int deleteActivityPlace(@Param("ActivityPlaceId")String ActivityPlaceId);
}
