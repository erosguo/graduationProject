package cn.system.dao;

import cn.system.domain.JoinDiscuss;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinDiscussDao {
    @Select("select * from RELATIONSHIP_JOINDISCUSS")
    @Results(id="JoinDiscuss",value = {
            @Result(id = true,column="UserId",property="UserId"),
            @Result(column = "ClubDiscussId",property = "ClubDiscussId")
    })
    public List<JoinDiscuss> findJoinDiscussAll();

    @Select("select * from RELATIONSHIP_JOINDISCUSS where UserId=#{UserId}")
    @ResultMap("JoinDiscuss")
    public List<JoinDiscuss> findJoinDiscussAllByUserId(@Param("UserId")String UserId);

    @Select("select * from RELATIONSHIP_JOINDISCUSS where UserId=#{UserId} and ClubDiscussId=#{ClubDiscussId}")
    @ResultMap("JoinDiscuss")
    public JoinDiscuss findJoinDiscussById(@Param("UserId")String UserId,@Param("ClubDiscussId")int ClubDiscussId);

    @Insert("insert into RELATIONSHIP_JOINDISCUSS(UserId,ClubDiscussId) values(#{UserId},#{ClubDiscussId})")
    @ResultMap("JoinDiscuss")
    public int saveJoinDiscuss(JoinDiscuss joinDiscuss);
}
