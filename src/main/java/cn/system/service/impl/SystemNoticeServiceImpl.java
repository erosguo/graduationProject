package cn.system.service.impl;


import cn.system.dao.SystemNoticeDao;
import cn.system.domain.SystemNotice;
import cn.system.service.SystemNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("SystemNoticeService")
public class SystemNoticeServiceImpl implements SystemNoticeService {
    @Autowired
    private SystemNoticeDao systemNoticeDao;

    @Override
    public List<SystemNotice> findSystemNoticeAll() {
        return systemNoticeDao.findSystemNoticeAll();
    }

    @Override
    public SystemNotice findSystemNoticeById(int SystemNoticeId) {
        return systemNoticeDao.findSystemNoticeById(SystemNoticeId);
    }


    @Override
    public int saveSystemNotice(SystemNotice systemNotice) {

        return systemNoticeDao.saveSystemNotice(systemNotice);
    }

    @Override
    public int updateSystemNoticeContentById(int SystemNoticeId, String SystemNoticeContent) {

        return systemNoticeDao.updateSystemNoticeContentById(SystemNoticeId,SystemNoticeContent);
    }

    @Override
    public SystemNotice findNewestSystemNotice() {

        return systemNoticeDao.findNewestSystemNotice();
    }

    @Override
    public int deleteSystemNotice(int SystemNoticeId) {
        return systemNoticeDao.deleteSystemNotice(SystemNoticeId);
    }

    @Override
    public int updateSystemNotice(int SystemNoticeId, String SystemNoticeName, String SystemNoticeContent) {
        return systemNoticeDao.updateSystemNotice(SystemNoticeId,SystemNoticeName,SystemNoticeContent);
    }
}
