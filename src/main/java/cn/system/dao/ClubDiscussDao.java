package cn.system.dao;

import cn.system.domain.ClubDiscuss;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Repository
public interface ClubDiscussDao {
    //
    @Select("select * from system_clubdiscuss")
    @Results(id="ClubDiscuss",value = {
            @Result(id = true,column="ClubDiscussId",property="ClubDiscussId"),
            @Result(column = "ClubId",property = "ClubId"),
            @Result(column = "ClubDiscussName",property = "ClubDiscussName"),
            @Result(column = "ClubDiscussContent",property = "ClubDiscussContent"),
            @Result(column = "ClubDiscussClickNumber",property = "ClubDiscussClickNumber"),
            @Result(column = "ClubDiscussComment",property = "ClubDiscussComment")
    })
    public List<ClubDiscuss> findClubDiscussAll();

    @Select("select * from system_clubdiscuss where ClubId=#{ClubId}")
    @ResultMap("ClubDiscuss")
    public List<ClubDiscuss> findClubDiscussAllByClubId(int ClubId);

    @Select("select * from system_clubdiscuss where ClubDiscussId =#{ClubDiscussId}")
    @RequestMapping("ClubDiscuss")
    public ClubDiscuss findClubDiscussByClubDiscussId(int ClubDiscussId);

    @Select(" select * FROM system_clubdiscuss ORDER BY ClubDiscussId DESC LIMIT 0,1")
    @ResultMap("ClubDiscuss")
    public ClubDiscuss findClubDiscussBiggestId();

    @Insert("insert into system_clubdiscuss(ClubDiscussId,ClubId,ClubDiscussName,ClubDiscussContent,ClubDiscussClickNumber,ClubDiscussComment) values(#{ClubDiscussId},#{ClubId},#{ClubDiscussName},#{ClubDiscussContent},#{ClubDiscussClickNumber},#{ClubDiscussComment})")
    @ResultMap("ClubDiscuss")
    public int saveClubDiscuss(ClubDiscuss clubDiscuss);

    //添加@Param注解
    @Update("update system_clubdiscuss set ClubDiscussComment = #{ClubDiscussComment} where ClubDiscussId= #{ClubDiscussId}")
    @ResultMap("ClubDiscuss")
    public int updateClubDiscussComment(@Param("ClubDiscussId")int ClubDiscussId,@Param("ClubDiscussComment")String ClubDiscussComment);

    //添加@Param注解
    @Update("update system_clubdiscuss set ClubDiscussClickNumber = #{ClubDiscussClickNumber} where ClubDiscussId= #{ClubDiscussId}")
    @ResultMap("ClubDiscuss")
    public int updateClubDiscussClick(@Param("ClubDiscussId")int ClubDiscussId,@Param("ClubDiscussClickNumber")int ClubDiscussClickNumber);

}
