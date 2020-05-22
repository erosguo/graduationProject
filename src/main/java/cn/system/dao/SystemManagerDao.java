package cn.system.dao;

import cn.system.domain.SystemManager;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemManagerDao {
    //查询所有管理员
    @Select("select * from system_systemmanager")
    @Results(id="SystemManager",value = {
            @Result(id = true,column="SystemManagerId",property="SystemManagerId"),
            @Result(column = "SystemManagerPassword",property = "SystemManagerPassword"),
            @Result(column = "SystemManagerTel",property = "SystemManagerTel"),
            @Result(column = "SystemManagerEmail",property = "SystemManagerEmail"),
            @Result(column = "SystemManagerName",property = "SystemManagerName")
    })
    public List<SystemManager> findSystemManagerAll();

    @Select("select * from system_systemmanager where SystemManagerId =#{SystemManagerId}")
    @ResultMap("SystemManager")
    public SystemManager findSystemManagerById(String SystemManagerId);

    //添加@Param注解
    @Update("update system_systemmanager set SystemManagerName = #{SystemManagerName} where SystemManagerId = #{SystemManagerId}")
    @ResultMap("SystemManager")
    public int updateSystemManagerNameById(@Param("SystemManagerId")String SystemManagerId,@Param("SystemManagerName")String SystemManagerName);

    //添加@Param注解
    @Update("update system_systemmanager set SystemManagerTel = #{SystemManagerTel} where SystemManagerId = #{SystemManagerId}")
    @ResultMap("SystemManager")
    public int updateSystemManagerTelById(@Param("SystemManagerId")String SystemManagerId,@Param("SystemManagerTel")String SystemManagerTel);

    //添加@Param注解
    @Update("update system_systemmanager set SystemManagerEmail = #{SystemManagerEmail} where SystemManagerId = #{SystemManagerId}")
    @ResultMap("SystemManager")
    public int updateSystemManagerEmailById(@Param("SystemManagerId")String SystemManagerId,@Param("SystemManagerEmail")String SystemManagerEmail);

    //添加@Param注解
    @Update("update system_systemmanager set SystemManagerPassword = #{SystemManagerPassword} where SystemManagerId = #{SystemManagerId}")
    @ResultMap("SystemManager")
    public int updateSystemManagerPasswordById(@Param("SystemManagerId")String SystemManagerId,@Param("SystemManagerPassword")String SystemManagerPassword);

    @Insert("insert into system_systemmanager(SystemManagerId,SystemManagerPassword,SystemManagerTel,SystemManagerEmail,SystemManagerName) values(#{SystemManagerId},#{SystemManagerPassword},#{SystemManagerTel},#{SystemManagerEmail},#{SystemManagerName})")
    @ResultMap("SystemManager")
    public int saveSystemManager(SystemManager systemManager);

}
