package cn.system.dao;

import cn.system.domain.UserRelationShip;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface UserRelationShipDao {
    @Select("select * from SYSTEM_USERRELATIONSHIP")
    @Results(id="UserRelationShip",value = {
            @Result(id = true,column="RelationshipUserId",property="RelationshipUserId"),
            @Result(id = true,column = "RelationshipFriendId",property = "RelationshipFriendId")
    })
    public List<UserRelationShip> findUserRelationShipAll();

    @Select("select * from SYSTEM_USERRELATIONSHIP where RelationshipUserId=#{RelationshipUserId}")
    @ResultMap("UserRelationShip")
    public List<UserRelationShip> findUserRelationShipAllByRelationshipUserId(@Param("RelationshipUserId")String RelationshipUserId);

    @Insert("insert into SYSTEM_USERRELATIONSHIP(RelationshipUserId,RelationshipFriendId) " +
            "values(#{RelationshipUserId},#{RelationshipFriendId})")
    @ResultMap("UserRelationShip")
    public int saveUserRelationShip(UserRelationShip userRelationShip);

    @Delete("delete from SYSTEM_USERRELATIONSHIP where RelationshipUserId=#{RelationshipUserId} and RelationshipFriendId=#{RelationshipFriendId}")
    @ResultMap("UserRelationShip")
    public int deleteUserRelationShip(UserRelationShip userRelationShip);
}
