package cn.system.dao;

import cn.system.domain.JoinActivity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinActivityDao {
    @Select("select * from USER_CLUBDISCUSS_JOINACTIVITY")
    @Results(id="JoinActivity",value = {
            @Result(id = true,column="ActivityId",property="ActivityId"),
            @Result(id = true,column="UserId",property="UserId"),
            @Result(column = "JoinActivityIsSuccess",property = "JoinActivityIsSuccess")
    })
    public List<JoinActivity> findJoinActivityAll();

    @Select("select * from USER_CLUBDISCUSS_JOINACTIVITY where ActivityId=#{ActivityId}")
    @ResultMap("JoinActivity")
    public List<JoinActivity> findJoinActivityAllByActivityId(@Param("ActivityId")int ActivityId);

    @Select("select * from USER_CLUBDISCUSS_JOINACTIVITY where UserId=#{UserId}")
    @ResultMap("JoinActivity")
    public List<JoinActivity> findJoinActivityAllByUserId(@Param("UserId")String UserId);

    @Select("select * from USER_CLUBDISCUSS_JOINACTIVITY where UserId=#{UserId} and ActivityId=#{ActivityId}")
    @ResultMap("JoinActivity")
    public JoinActivity findUJoinActivityById(@Param("UserId")String UserId,@Param("ActivityId")int ActivityId);

    @Insert("insert into USER_CLUBDISCUSS_JOINACTIVITY(ActivityId,UserId,JoinActivityIsSuccess) values(#{ActivityId},#{UserId},#{JoinActivityIsSuccess})")
    @ResultMap("JoinActivity")
    public int saveJoinActivity(JoinActivity joinActivity);

    @Delete("delete from USER_CLUBDISCUSS_JOINACTIVITY where UserId=#{UserId} and ActivityId=#{ActivityId}")
    @ResultMap("JoinActivity")
    public int deleteJoinActivity(@Param("UserId")String UserId,@Param("ActivityId")int ActivityId);

    @Update("update USER_CLUBDISCUSS_JOINACTIVITY set JoinActivityIsSuccess=#{JoinActivityIsSuccess} where UserId=#{UserId} and ActivityId=#{ActivityId}")
    @ResultMap("JoinActivity")
    public int updateJoinActivity(@Param("UserId")String UserId,@Param("ActivityId")int ActivityId,@Param("JoinActivityIsSuccess")int JoinActivityIsSuccess);
}
