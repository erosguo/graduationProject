package cn.system.dao;

import cn.system.domain.PersonHold;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonHoldDao {
    @Select("select * from RELATIONSHIP_PERSONHOLD")
    @Results(id="PersonHold",value = {
            @Result(id = true,column="UserId",property="UserId"),
            @Result(id = true,column = "ActivityId",property = "ActivityId")
    })
    public List<PersonHold> findPersonHoldAll();

    @Select("select * from RELATIONSHIP_PERSONHOLD where UserId=#{UserId}")
    @ResultMap("PersonHold")
    public List<PersonHold> findPersonHoldAllByUserId(@Param("UserId")String UserId);

    @Insert("insert into RELATIONSHIP_PERSONHOLD(UserId,ActivityId) values(#{UserId},#{ActivityId})")
    @ResultMap("PersonHold")
    public int savePersonHold(PersonHold personHold);

    @Delete("delete from RELATIONSHIP_PERSONHOLD where UserId =#{UserId} and ActivityId=#{ActivityId}")
    @ResultMap("PersonHold")
    public int deletePersonHold(PersonHold personHold);
}
