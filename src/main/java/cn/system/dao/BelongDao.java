package cn.system.dao;

import cn.system.domain.Belong;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BelongDao {
    @Select("select * from RELATIONSHIP_BELONG")
    @Results(id="Belong",value = {
            @Result(id = true,column="UserId",property="UserId"),
            @Result(id=true,column = "ClubId",property = "ClubId"),
            @Result(column = "BelongIsEnable",property = "BelongIsEnable")
    })
    public List<Belong> findBelongAll();

    @Select("select * from RELATIONSHIP_BELONG where UserId=#{UserId}")
    @ResultMap("Belong")
    public List<Belong> findBelongAllByUserId(@Param("UserId")String UserId);

    @Select("select * from RELATIONSHIP_BELONG where UserId=#{UserId} and ClubId=#{ClubId}")
    @ResultMap("Belong")
    public Belong findUBelongByUserId(@Param("UserId")String UserId,@Param("ClubId")int ClubId);

    @Select("select * from relationship_belong where ClubId=#{ClubId}")
    @ResultMap("Belong")
    public List<Belong> findBelongAllByClubId(@Param("ClubId")int ClubId);

    @Select("select * from relationship_belong where ClubId=#{ClubId} and BelongIsEnable=0")
    @ResultMap("Belong")
    public List<Belong> findBelongInvalidAllByClubId(@Param("ClubId")int ClubId);

    @Select("select * from relationship_belong where ClubId=#{ClubId} and BelongIsEnable=1")
    @ResultMap("Belong")
    public List<Belong> findBelongValidAllByClubId(@Param("ClubId")int ClubId);

    @Select("select * from relationship_belong where UserId=#{UserId} and BelongIsEnable=0")
    @ResultMap("Belong")
    public List<Belong> findBelongInvalidAllByUserId(@Param("UserId")String UserId);

    @Select("select * from relationship_belong where UserId=#{UserId} and BelongIsEnable=1")
    @ResultMap("Belong")
    public List<Belong> findBelongValidAllByUserId(@Param("UserId")String UserId);

    @Insert("insert into RELATIONSHIP_BELONG(UserId,ClubId,BelongIsEnable) values(#{UserId},#{ClubId},#{BelongIsEnable})")
    @ResultMap("Belong")
    public int saveBelong(Belong belong);

    @Delete("delete from RELATIONSHIP_BELONG where UserId=#{UserId} and ClubId=#{ClubId}")
    @ResultMap("Belong")
    public int deleteBelong(@Param("UserId")String UserId,@Param("ClubId")int ClubId);

    @Update("update RELATIONSHIP_BELONG set BelongIsEnable = #{BelongIsEnable} where ClubId = #{ClubId} and UserId=#{UserId}")
    @ResultMap("Belong")
    public int updateBelongIsEnable(@Param("UserId")String UserId,@Param("ClubId")int ClubId,@Param("BelongIsEnable")int BelongIsEnable);
}
