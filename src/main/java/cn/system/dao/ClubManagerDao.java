package cn.system.dao;

import cn.system.domain.ClubManager;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubManagerDao {

    //查询所有社团管理员
    @Select("select * from system_clubmanager")
    @Results(id="ClubManager",value = {
            @Result(id = true,column="ClubManagerId",property="ClubManagerId"),
            @Result(column = "ClubId",property = "ClubId"),
            @Result(column = "ClubManagerPassword",property = "ClubManagerPassword"),
            @Result(column = "ClubManagerName",property = "ClubManagerName"),
            @Result(column = "ClubManagerEmail",property = "ClubManagerEmail"),
            @Result(column = "ClubManagerTel",property = "ClubManagerTel"),
            @Result(column = "ClubId",property = "Club",one = @One(select="cn.system.dao.ClubDao.findClubById",fetchType= FetchType.EAGER))
    })
    public List<ClubManager> findClubManagerAll();

    @Select("select * from system_clubmanager where ClubManagerId=#{ClubManagerId}")
    @ResultMap("ClubManager")
    public ClubManager findClubManagerById(String ClubManagerId);

    @Insert("insert into system_clubmanager(ClubManagerId,ClubId,ClubManagerPassword,ClubManagerName,ClubManagerEmail,ClubManagerTel) values(#{ClubManagerId},#{ClubId},#{ClubManagerPassword},#{ClubManagerName},#{ClubManagerEmail},#{ClubManagerTel})")
    @ResultMap("ClubManager")
    public int saveClubManager(ClubManager clubManager);

    //添加@Param注解
    @Update("update system_clubmanager set ClubManagerPassword = #{ClubManagerPassword} where ClubManagerId= #{ClubManagerId}")
    @ResultMap("ClubManager")
    public int updateClubManagerPasswordById(@Param("ClubManagerId")String ClubManagerId,@Param("ClubManagerPassword")String ClubManagerPassword);

    //添加@Param注解
    @Update("update system_clubmanager set ClubManagerName = #{ClubManagerName} where ClubManagerId= #{ClubManagerId}")
    @ResultMap("ClubManager")
    public int updateClubManagerNameById(@Param("ClubManagerId")String ClubManagerId,@Param("ClubManagerName")String ClubManagerName);

    //添加@Param注解
    @Update("update system_clubmanager set ClubManagerEmail = #{ClubManagerEmail} where ClubManagerId= #{ClubManagerId}")
    @ResultMap("ClubManager")
    public int updateClubManagerEamilById(@Param("ClubManagerId")String ClubManagerId,@Param("ClubManagerEmail")String ClubManagerEmail);

    //添加@Param注解
    @Update("update system_clubmanager set ClubManagerTel = #{ClubManagerTel} where ClubManagerId= #{ClubManagerId}")
    @ResultMap("ClubManager")
    public int updateClubManagerTelById(@Param("ClubManagerId")String ClubManagerId,@Param("ClubManagerTel")String ClubManagerTel);


}
