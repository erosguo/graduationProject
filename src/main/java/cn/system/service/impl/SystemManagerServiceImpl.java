package cn.system.service.impl;

import cn.system.dao.SystemManagerDao;
import cn.system.domain.SystemManager;
import cn.system.service.SystemManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SystemManagerService")
public class SystemManagerServiceImpl implements SystemManagerService {

    @Autowired
    private SystemManagerDao systemManagerDao;

    @Override
    public List<SystemManager> findSystemManagerAll() {

        return systemManagerDao.findSystemManagerAll();
    }

    @Override
    public SystemManager findSystemManagerById(String SystemManagerId) {
        return systemManagerDao.findSystemManagerById(SystemManagerId);
    }

    @Override
    public int saveSystemManager(SystemManager systemManager) {
        return 0;
    }

    @Override
    public int updateSystemManagerPasswordById(String SystemManagerId, String SystemManagerPassword) {
        return systemManagerDao.updateSystemManagerPasswordById(SystemManagerId,SystemManagerPassword);
    }

    @Override
    public int updateSystemManagerNameById(String SystemManagerId, String SystemManagerName) {

        return systemManagerDao.updateSystemManagerNameById(SystemManagerId,SystemManagerName);
    }

    @Override
    public int updateSystemManagerEmailById(String SystemManagerId, String SystemManagerEmail) {
        return systemManagerDao.updateSystemManagerEmailById(SystemManagerId,SystemManagerEmail);
    }

    @Override
    public int updateSystemManagerTelById(String SystemManagerId, String SystemManagerTel) {
        return systemManagerDao.updateSystemManagerTelById(SystemManagerId,SystemManagerTel);
    }
}
