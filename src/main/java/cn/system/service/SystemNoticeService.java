package cn.system.service;

import cn.system.domain.SystemNotice;

import java.util.List;

public interface SystemNoticeService {

    //
    public List<SystemNotice> findSystemNoticeAll();
    //
    public SystemNotice findSystemNoticeById(int SystemNoticeId);
    //
    public int saveSystemNotice(SystemNotice systemNotice);
    //
    public int updateSystemNoticeContentById(int SystemNoticeId,String SystemNoticeContent);
    //
    public SystemNotice findNewestSystemNotice();

    public int deleteSystemNotice(int SystemNoticeId);

    public int updateSystemNotice(int SystemNoticeId,String SystemNoticeName,String SystemNoticeContent);

}
