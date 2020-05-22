package cn.system.service;

import cn.system.domain.Message;

import java.util.List;

public interface MessageService {
    public List<Message> findSystemMessageAll();
    public List<Message> findSystemMessageByUserId(String UserId);
    public Message findSystemMessageByMessageId(int MessageId);
    public Message findMessageBiggestId();
    public int saveMessage(Message message);
    public int deleteMessage(int MessageId);
}
