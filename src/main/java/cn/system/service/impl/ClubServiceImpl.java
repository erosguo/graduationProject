package cn.system.service.impl;

import cn.system.dao.ClubDao;
import cn.system.domain.Club;
import cn.system.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClubService")
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubDao clubDao;

    @Override
    public List<Club> findClubAll() {
        return clubDao.findClubAll();
    }

    @Override
    public List<Club> findClubValidAll() {
        return clubDao.findClubValidAll();
    }

    @Override
    public List<Club> findClubInvalidAll() {
        return clubDao.findClubInvalidAll();
    }

    @Override
    public Club findClubById(int ClubId) {
        return clubDao.findClubById(ClubId);
    }

    @Override
    public int saveClub(Club club) {
        return clubDao.saveUser(club);
    }

    @Override
    public int updateClubNoticeById(int ClubId, String ClubNotice) {

        return clubDao.updateClubNoticeById(ClubId,ClubNotice);
    }

    @Override
    public Club findClubBiggestId() {
        return clubDao.findClubBiggestId();
    }

    @Override
    public int updateClubIsEnable(int ClubId, int ClubIsEnable) {
        return clubDao.updateIsEnableById(ClubId,ClubIsEnable);
    }

    @Override
    public int deleteClubById(int ClubId) {
        return clubDao.deleteUserById(ClubId);
    }

    @Override
    public List<Club> findClubByName(String ClubName) {
        return clubDao.findClubByName(ClubName);
    }

    @Override
    public Club findClubByUName(String ClubName) {
        return clubDao.findClubByUName(ClubName);
    }

}
