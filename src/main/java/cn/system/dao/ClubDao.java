package cn.system.dao;

import cn.system.domain.Club;
import cn.system.domain.ClubDiscuss;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Repository
public interface ClubDao {
    //
    @Select("select * from system_club")
    @Results(id="Club",value = {
            @Result(id = true,column="ClubId",property="ClubId"),
            @Result(column = "ClubName",property = "ClubName"),
            @Result(column = "ClubIntroduction",property = "ClubIntroduction"),
            @Result(column = "ClubNotice",property = "ClubNotice"),
            @Result(column = "ClubFile",property = "ClubFile"),
            @Result(column = "ClubIsEnable",property = "ClubIsEnable"),
            @Result(column = "ClubId",property = "clubDiscusses",one=@One(select = "cn.system.dao.ClubDiscussDao.findClubDiscussAllByClubId",fetchType = FetchType.EAGER)),
            @Result(column = "ClubId",property = "belongList",many = @Many(select="cn.system.dao.BelongDao.findBelongAllByClubId",fetchType = FetchType.LAZY)),
            @Result(column = "ClubId",property = "clubHoldList",one =@One(select = "cn.system.dao.ClubHoldDao.findClubHoldAllByClubId",fetchType = FetchType.EAGER))

    })
    public List<Club> findClubAll();

    @Select("select * from system_club where ClubId=#{ClubId}")
    @ResultMap("Club")
    public Club findClubById(int ClubId);

    @Select("select * from system_club where INSTR(ClubName,#{ClubName})")
    @ResultMap("Club")
    public List<Club> findClubByName(String ClubName);

    @Select("select * from system_club where ClubName=#{ClubName}")
    @ResultMap("Club")
    public Club findClubByUName(String ClubName);

    @Select("select * from system_club where ClubIsEnable = 1")
    @ResultMap("Club")
    public List<Club> findClubValidAll();

    @Select("select * from system_club where ClubIsEnable = 0")
    @ResultMap("Club")
    public List<Club> findClubInvalidAll();

    /*@Select("select IFNULL(MAX(ClubId),1) as ClubId from system_club")*/
    @Select(" select * FROM system_club ORDER BY ClubId DESC LIMIT 0,1")
    @ResultMap("Club")
    public Club findClubBiggestId();

    @Insert("insert into system_club(ClubId,ClubName,ClubIntroduction,ClubNotice,ClubIsEnable,ClubFile) values(#{ClubId},#{ClubName},#{ClubIntroduction},#{ClubNotice},#{ClubIsEnable},#{ClubFile})")
    @ResultMap("Club")
    public int saveUser(Club club);

    @Update("update system_club set ClubNotice = #{ClubNotice} where ClubId = #{ClubId} ")
    @ResultMap("Club")
    public int updateClubNoticeById(@Param("ClubId")int ClubId,@Param("ClubNotice")String ClubNotice);

    //添加@Param注解
    @Update("update system_club set ClubIsEnable = #{ClubIsEnable} where ClubId = #{ClubId}")
    @ResultMap("Club")
    public int updateIsEnableById(@Param("ClubId")int ClubId,@Param("ClubIsEnable")int ClubIsEnable);

    //
    @Delete("delete from system_club where ClubId= #{ClubId}")
    @ResultMap("Club")
    public int deleteUserById(@Param("ClubId")int ClubId);
}
