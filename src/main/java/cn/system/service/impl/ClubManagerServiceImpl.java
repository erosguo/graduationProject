package cn.system.service.impl;

import cn.system.dao.ClubManagerDao;
import cn.system.domain.ClubManager;
import cn.system.service.ClubManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClubManagerService")
public class ClubManagerServiceImpl implements ClubManagerService {

    @Autowired
    private ClubManagerDao clubManagerDao;

    @Override
    public List<ClubManager> findClubManagerAll() {

        return clubManagerDao.findClubManagerAll();
    }

    @Override
    public ClubManager findClubManagerById(String ClubManagerId) {

        return clubManagerDao.findClubManagerById(ClubManagerId);
    }

    @Override
    public int saveClubManager(ClubManager clubManager) {
        return clubManagerDao.saveClubManager(clubManager);
    }

    @Override
    public int updateClubManagerNameById(String ClubManagerId, String ClubManagerName) {
        return clubManagerDao.updateClubManagerNameById(ClubManagerId,ClubManagerName);
    }

    @Override
    public int updateClubManagerPasswordById(String ClubManagerId, String ClubManagerPassword) {
        return clubManagerDao.updateClubManagerPasswordById(ClubManagerId,ClubManagerPassword);
    }

    @Override
    public int updateClubManagerTelById(String ClubManagerId, String ClubManagerTel) {
        return clubManagerDao.updateClubManagerTelById(ClubManagerId,ClubManagerTel);
    }

    @Override
    public int updateClubManagerEmailById(String ClubManagerId, String ClubManagerEmail) {
        return clubManagerDao.updateClubManagerEamilById(ClubManagerId,ClubManagerEmail);
    }
}
