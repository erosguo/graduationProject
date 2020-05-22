package cn.system.domain;

import java.io.Serializable;

/**
 * 消息
 */
public class Message implements Serializable {
    private int MessageId;
    private String UserId;

    private int MessageType;
    private String MessageContent;
    private String MessageFrom;

    public String getMessageFrom() {
        return MessageFrom;
    }

    public void setMessageFrom(String messageFrom) {
        MessageFrom = messageFrom;
    }



    public int getMessageId() {
        return MessageId;
    }

    public void setMessageId(int messageId) {
        MessageId = messageId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public int getMessageType() {
        return MessageType;
    }

    public void setMessageType(int messageType) {
        MessageType = messageType;
    }

    public String getMessageContent() {
        return MessageContent;
    }

    public void setMessageContent(String messageContent) {
        MessageContent = messageContent;
    }


    @Override
    public String toString() {
        return "Message{" +
                "MessageId=" + MessageId +
                ", UserId='" + UserId + '\'' +
                ", MessageType=" + MessageType +
                ", MessageContent='" + MessageContent + '\'' +
                ", MessageFrom='" + MessageFrom + '\'' +
                '}';
    }

}
