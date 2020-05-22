package cn.system.dao;

import cn.system.domain.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {
    @Select("select * from SYSTEM_MESSAGE")
    @Results(id="Message",value = {
            @Result(id = true,column="MessageId",property="MessageId"),
            @Result(column = "UserId",property = "UserId"),
            @Result(column = "MessageType",property = "MessageType"),
            @Result(column = "MessageFrom",property = "MessageFrom"),
            @Result(column = "MessageContent",property = "MessageContent")
    })
    public List<Message> findSystemMessageAll();

    @Select("select * from SYSTEM_MESSAGE where UserId =#{UserId} ORDER BY MessageId DESC")
    @ResultMap("Message")
    public List<Message> findSystemMessageByUserId(String UserId);

    @Select("select * from SYSTEM_MESSAGE where MessageId =#{MessageId}")
    @ResultMap("Message")
    public Message findSystemMessageByMessageId(int MessageId);

    @Select(" select * FROM SYSTEM_MESSAGE ORDER BY MessageId DESC LIMIT 0,1")
    @ResultMap("Message")
    public Message findMessageBiggestId();

    @Insert("insert into SYSTEM_MESSAGE(MessageId,UserId,MessageType,MessageContent,MessageFrom) " +
            "values(#{MessageId},#{UserId},#{MessageType},#{MessageContent},#{MessageFrom})")
    @ResultMap("Message")
    public int saveMessage(Message message);

    @Delete("delete from SYSTEM_MESSAGE where MessageId=#{MessageId}")
    @ResultMap("Message")
    public int deleteMessage(int MessageId);

}
