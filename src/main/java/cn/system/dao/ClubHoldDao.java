package cn.system.dao;

import cn.system.domain.ClubHold;
import cn.system.domain.JoinDiscuss;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubHoldDao {
    @Select("select * from RELATIONSHIP_CLUBHOLD")
    @Results(id="ClubHold",value = {
            @Result(id = true,column="ClubId",property="ClubId"),
            @Result(id = true,column = "ActivityId",property = "ActivityId")
    })
    public List<ClubHold> findClubHoldAll();

    @Select("select * from RELATIONSHIP_CLUBHOLD where ClubId=#{ClubId}")
    @ResultMap("ClubHold")
    public List<ClubHold> findClubHoldAllByClubId(@Param("ClubId")int ClubId);

    @Insert("insert into RELATIONSHIP_CLUBHOLD(ClubId,ActivityId) values(#{ClubId},#{ActivityId})")
    @ResultMap("ClubHold")
    public int saveClubHold(ClubHold clubHold);

    @Delete("delete from RELATIONSHIP_CLUBHOLD where ClubId =#{ClubId} and ActivityId=#{ActivityId}")
    @ResultMap("ClubHold")
    public int deleteClubHold(ClubHold clubHold);
}
