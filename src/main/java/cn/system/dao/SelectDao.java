package cn.system.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectDao {
    @Select("select * from RELATIONSHIP_SELECT")
    @Results(id="Select",value = {
            @Result(id = true,column="CourseId",property="CourseId"),
            @Result(id = true,column = "CourseTeachId",property = "CourseTeachId"),
            @Result(id = true,column = "UserId",property = "UserId")
    })
    public List<cn.system.domain.Select> findSelectAll();

    @Select("select * from RELATIONSHIP_SELECT where UserId=#{UserId}")
    @ResultMap("Select")
    public List<cn.system.domain.Select> findSelectByUserId(String UserId);



}
