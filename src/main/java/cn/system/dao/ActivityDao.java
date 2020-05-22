package cn.system.dao;

import cn.system.domain.Activity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityDao {
    //查询用户
    @Select("select * from SYSTEM_ACTIVITY")
    @Results(id="Activity",value = {
            @Result(id = true,column="ActivityId",property="ActivityId"),
            @Result(column = "ActivityName",property = "ActivityName"),
            @Result(column = "ActivityIntroduction",property = "ActivityIntroduction"),
            @Result(column = "ActivityContent",property = "ActivityContent"),
            @Result(column = "ActivityPlace",property = "ActivityPlace"),
            @Result(column = "ActivityJoinBeginTime",property = "ActivityJoinBeginTime"),
            @Result(column = "ActivityJoinEndTime",property = "ActivityJoinEndTime"),
            @Result(column = "ActivityState",property = "ActivityState"),
            @Result(column = "ActivityJoinWay",property = "ActivityJoinWay"),
            @Result(column = "ActivityPersonCount",property = "ActivityPersonCount"),
            @Result(column = "ActivityPersonMethod",property = "ActivityPersonMethod"),
            @Result(column = "ActivityType",property = "ActivityType"),
            @Result(column = "ActivityBeginTime",property = "ActivityBeginTime"),
            @Result(column = "ActivityEndTime",property = "ActivityEndTime"),
            @Result(column = "ActivityId",property = "joinActivityList",many=@Many(select = ("cn.system.dao.JoinActivityDao.findJoinActivityAllByActivityId"),fetchType= FetchType.LAZY)),

    })
    public List<Activity> findActivityAll();

    @Select("select * from SYSTEM_ACTIVITY where ActivityId = #{ActivityId}")
    @ResultMap(value = "Activity")
    public Activity findActivityActivityById(int Activity);

    @Select("select * from SYSTEM_ACTIVITY where ActivityState = #{ActivityState}")
    @ResultMap(value = "Activity")
    public List<Activity> findActivityActivityByState(int ActivityState);

    @Select(" select * FROM SYSTEM_ACTIVITY ORDER BY ActivityId DESC LIMIT 0,1")
    @ResultMap("Activity")
    public Activity findActivityBiggestId();

    @Insert("insert into SYSTEM_ACTIVITY" +
            "(ActivityId,ActivityName,ActivityIntroduction,ActivityContent,ActivityPlace,ActivityJoinBeginTime,ActivityJoinEndTime,ActivityState,ActivityJoinWay,ActivityPersonCount,ActivityPersonMethod,ActivityType,ActivityBeginTime,ActivityEndTime) " +
            "values" +
            "(#{ActivityId},#{ActivityName},#{ActivityIntroduction},#{ActivityContent},#{ActivityPlace},#{ActivityJoinBeginTime},#{ActivityJoinEndTime},#{ActivityState},#{ActivityJoinWay},#{ActivityPersonCount},#{ActivityPersonMethod},#{ActivityType},#{ActivityBeginTime},#{ActivityEndTime})")
    @ResultMap("Activity")
    public int saveActivity(Activity activity);

    @Update("update SYSTEM_ACTIVITY set ActivityState=#{ActivityState} where ActivityId=#{ActivityId}")
    @ResultMap("Activity")
    public int updateActivityStateById(@Param("ActivityId")int ActivityId,@Param("ActivityState")int ActivityState);

    @Delete("delete from SYSTEM_ACTIVITY where ActivityId=#{ActivityId}")
    @ResultMap("Activity")
    public int deleteActivity(Activity activity);

}
