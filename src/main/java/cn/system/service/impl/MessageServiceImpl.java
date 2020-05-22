package cn.system.service.impl;

import cn.system.dao.MessageDao;
import cn.system.domain.Message;
import cn.system.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MessageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Override
    public List<Message> findSystemMessageAll() {
        return messageDao.findSystemMessageAll();
    }

    @Override
    public List<Message> findSystemMessageByUserId(String UserId) {
        return messageDao.findSystemMessageByUserId(UserId);
    }

    @Override
    public Message findSystemMessageByMessageId(int MessageId) {
        return messageDao.findSystemMessageByMessageId(MessageId);
    }

    @Override
    public Message findMessageBiggestId() {
        return messageDao.findMessageBiggestId();
    }

    @Override
    public int saveMessage(Message message) {
        return messageDao.saveMessage(message);
    }

    @Override
    public int deleteMessage(int MessageId) {
        return messageDao.deleteMessage(MessageId);
    }
}
