package cn.system.dao;

import cn.system.domain.SystemNotice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 */
@Repository
public interface SystemNoticeDao {

    /**
     * 查询全部公告
     * @return
     */
    @Select("select * from system_systemnotice")
    @Results(id="SystemNotice",value = {
            @Result(id = true,column="SystemNoticeId",property="SystemNoticeId"),
            @Result(column = "SystemManagerId",property = "SystemManagerId"),
            @Result(column = "SystemNoticeContent",property = "SystemNoticeContent"),
            @Result(column = "SystemNoticeTime",property = "SystemNoticeTime"),
            @Result(column = "SystemNoticeName",property = "SystemNoticeName")
    })
    public List<SystemNotice> findSystemNoticeAll();

    //查询最新公告
    @Select(" select * FROM system_systemnotice ORDER BY SystemNoticeId DESC LIMIT 0,1")
    @ResultMap("SystemNotice")
    public SystemNotice findSystemNoticeBiggestId();

    //根据id查询公告
    @Select("select * from system_systemnotice where SystemNoticeId =#{SystemNoticeId}")
    @ResultMap("SystemNotice")
    public SystemNotice findSystemNoticeById(int SystemNoticeId);


    //保存公告
    @Insert("insert into system_systemnotice(SystemNoticeId,SystemManagerId,SystemNoticeContent,SystemNoticeTime,SystemNoticeName) values(#{SystemNoticeId},#{SystemManagerId},#{SystemNoticeContent},#{SystemNoticeTime},#{SystemNoticeName})")
    @ResultMap("SystemNotice")
    public int saveSystemNotice(SystemNotice systemNotice);



    //查询最新记录
    @Select(" select * FROM system_systemnotice ORDER BY SystemNoticeTime DESC LIMIT 0,1")
    @ResultMap("SystemNotice")
    public SystemNotice findNewestSystemNotice();

    /**
     * 更新
     * @param SystemNoticeId
     * @param SystemNoticeContent
     * @return
     */
    @Update("update system_systemnotice set SystemNoticeContent=#{SystemNoticeContent} where SystemNoticeId = #{SystemNoticeId}")
    @RequestMapping("SystemNotice")
    public int updateSystemNoticeContentById(@Param("SystemNoticeId")int SystemNoticeId, @Param("SystemNoticeContent")String SystemNoticeContent);
    //更新公告
    @Update("update system_systemnotice set SystemNoticeName = #{SystemNoticeName},SystemNoticeContent=#{SystemNoticeContent} where SystemNoticeId = #{SystemNoticeId}")
    @ResultMap("SystemNotice")
    public int updateSystemNotice(@Param("SystemNoticeId")int SystemNoticeId,@Param("SystemNoticeName")String SystemNoticeName,@Param("SystemNoticeContent")String SystemNoticeContent);

    //删除公告
    @Delete("DELETE FROM system_systemnotice WHERE SystemNoticeId = #{SystemNoticeId}")
    @ResultMap("SystemNotice")
    public int deleteSystemNotice(int SystemNoticeId);
}
