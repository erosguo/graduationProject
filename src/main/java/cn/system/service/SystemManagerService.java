package cn.system.service;

import cn.system.domain.SystemManager;

import java.util.List;

public interface SystemManagerService {

    //
    public List<SystemManager> findSystemManagerAll();
    //
    public SystemManager findSystemManagerById(String SystemManagerId);
    //
    public int saveSystemManager(SystemManager systemManager);
    //
    public int updateSystemManagerPasswordById(String SystemManagerId,String SystemManagerPassword);
    //
    public int updateSystemManagerNameById(String SystemManagerId,String SystemManagerName);

    //
    public int updateSystemManagerEmailById(String SystemManagerId,String SystemManagerEmail);

    //
    public int updateSystemManagerTelById(String SystemManagerId,String SystemManagerTel);
}
