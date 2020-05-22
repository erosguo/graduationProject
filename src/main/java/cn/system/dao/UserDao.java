package cn.system.dao;

import cn.system.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //查询用户
    @Select("select * from system_user")
    @Results(id="User",value = {
            @Result(id = true,column="UserId",property="UserId"),
            @Result(column = "UserPassword",property = "UserPassword"),
            @Result(column = "UserName",property = "UserName"),
            @Result(column = "UserIntroduction",property = "UserIntroduction"),
            @Result(column = "UserHobby",property = "UserHobby"),
            @Result(column = "UserEmail",property = "UserEmail"),
            @Result(column = "UserTel",property = "UserTel"),
            @Result(column = "UserIsEnable",property = "UserIsEnable"),
            @Result(column = "UserId",property = "belongList",many=@Many(select = ("cn.system.dao.BelongDao.findBelongAllByUserId"),fetchType= FetchType.LAZY)),
            @Result(column = "UserId",property = "joinDiscussList",one = @One(select = "cn.system.dao.JoinDiscussDao.findJoinDiscussAllByUserId",fetchType = FetchType.EAGER)),
            @Result(column = "UserId",property = "joinActivityList",many = @Many(select = ("cn.system.dao.JoinActivityDao.findJoinActivityAllByUserId"),fetchType = FetchType.LAZY)),
            @Result(column = "UserId",property = "selectList",many = @Many(select = ("cn.system.dao.SelectDao.findSelectByUserId"),fetchType = FetchType.LAZY))
    })
    public List<User> findUserAll();

    //
    @Select("select * from system_user where UserId= #{UserId}")
    @ResultMap(value = "User")
    public User findUserById(String UserId);
    //
    @Select("select * from system_user where UserIsEnable = 0")
    @ResultMap("User")
    public List<User> findInvalidUserAll();

    //
    @Insert("insert into system_user(UserId,UserPassword,UserName,UserIntroduction,UserHobby,UserEmail,UserTel,UserIsEnable) values(#{UserId},#{UserPassword},#{UserName},#{UserIntroduction},#{UserHobby},#{UserEmail},#{UserTel},#{UserIsEnable})")
    @ResultMap("User")
    public int saveUser(User user);

    @Delete("delete from system_user where UserId= #{UserId}")
    @ResultMap("User")
    public int deleteUserById(@Param("UserId")String UserId);

    //添加@Param注解
    @Update("update system_user set UserPassword = #{UserPassword} where UserId= #{UserId}")
    @ResultMap("User")
    public int updateUserPasswordById(@Param("UserId")String UserId,@Param("UserPassword")String UserPassword);

    //添加@Param注解
    @Update("update system_user set UserName = #{UserName} where UserId = #{UserId}")
    @ResultMap("User")
    public int updateUserNameById(@Param("UserId")String UserId,@Param("UserName")String UserName);

    //添加@Param注解
    @Update("update system_user set UserIntroduction = #{UserIntroduction} where UserId = #{UserId}")
    @ResultMap("User")
    public int updateUserIntroductionById(@Param("UserId")String UserId,@Param("UserIntroduction")String UserIntroduction);

    //添加@Param注解
    @Update("update system_user set UserHobby = #{UserHobby} where UserId = #{UserId}")
    @ResultMap("User")
    public int updateUserHobbyById(@Param("UserId")String UserId,@Param("UserHobby")String UserHobby);


    //添加@Param注解
    @Update("update system_user set UserEmail = #{UserEmail} where UserId = #{UserId}")
    @ResultMap("User")
    public int updateUserEmailById(@Param("UserId")String UserId,@Param("UserEmail")String UserEmail);

    //添加@Param注解
    @Update("update system_user set UserTel = #{UserTel} where UserId = #{UserId}")
    @ResultMap("User")
    public int updateUserTelById(@Param("UserId")String UserId,@Param("UserTel")String UserTel);

    //添加@Param注解
    @Update("update system_user set UserIsEnable = #{UserIsEnable} where UserId = #{UserId}")
    @ResultMap("User")
    public int updateIsEnableById(@Param("UserId")String UserId,@Param("UserIsEnable")int UserIsEnable);

}
