package cn.system.domain;

import java.io.Serializable;

/**
 * 系统公告
 */
public class SystemNotice implements Serializable {

    private int SystemNoticeId;
    private String SystemManagerId;
    private String SystemNoticeContent;
    private String SystemNoticeTime;
    private String SystemNoticeName;

    public int getSystemNoticeId() {
        return SystemNoticeId;
    }

    public void setSystemNoticeId(int systemNoticeId) {
        SystemNoticeId = systemNoticeId;
    }

    public String getSystemManagerId() {
        return SystemManagerId;
    }

    public void setSystemManagerId(String systemManagerId) {
        SystemManagerId = systemManagerId;
    }

    public String getSystemNoticeContent() {
        return SystemNoticeContent;
    }

    public void setSystemNoticeContent(String systemNoticeContent) {
        SystemNoticeContent = systemNoticeContent;
    }

    public String getSystemNoticeTime() {
        return SystemNoticeTime;
    }

    public void setSystemNoticeTime(String systemNoticeTime) {
        SystemNoticeTime = systemNoticeTime;
    }

    public String getSystemNoticeName() {
        return SystemNoticeName;
    }

    public void setSystemNoticeName(String systemNoticeName) {
        SystemNoticeName = systemNoticeName;
    }


    @Override
    public String toString() {
        return "SystemNotice{" +
                "SystemNoticeId='" + SystemNoticeId + '\'' +
                ", SystemManagerId='" + SystemManagerId + '\'' +
                ", SystemNoticeContent='" + SystemNoticeContent + '\'' +
                ", SystemNoticeTime='" + SystemNoticeTime + '\'' +
                ", SystemNoticeName='" + SystemNoticeName + '\'' +
                '}';
    }


}
