package cn.system.service.impl;

import cn.system.dao.BelongDao;
import cn.system.domain.Belong;
import cn.system.service.BelongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BelongService")
public class BelongServiceImpl implements BelongService {
    @Autowired
    private BelongDao belongDao;
    @Override
    public List<Belong> findBelongAll() {
        return belongDao.findBelongAll();
    }

    @Override
    public List<Belong> findBelongAllByUserId(String UserId) {
        return belongDao.findBelongAllByUserId(UserId);
    }

    @Override
    public List<Belong> findBelongAllByClubId(int ClubId) {
        return belongDao.findBelongAllByClubId(ClubId);
    }

    @Override
    public List<Belong> findBelongInvalidAllByClubId(int ClubId) {
        return belongDao.findBelongInvalidAllByClubId(ClubId);
    }

    @Override
    public List<Belong> findBelongValidAllByClubId(int ClubId) {
        return belongDao.findBelongValidAllByClubId(ClubId);
    }

    @Override
    public List<Belong> findBelongValidAllByUserId(String UserId) {
        return belongDao.findBelongValidAllByUserId(UserId);
    }

    @Override
    public List<Belong> findBelongInvalidAllByUserId(String UserId) {
        return belongDao.findBelongInvalidAllByUserId(UserId);
    }

    @Override
    public Belong findUBelongByUserId(String UserId, int ClubId) {
        return belongDao.findUBelongByUserId(UserId,ClubId);
    }

    @Override
    public int saveBelong(Belong belong) {
        return belongDao.saveBelong(belong);
    }

    @Override
    public int updateBelongIsEnable(String UserId, int ClubId, int BelongIsEnable) {
        return belongDao.updateBelongIsEnable(UserId,ClubId,BelongIsEnable);
    }

    @Override
    public int deleteBelong(String UserId, int ClubId) {
        return belongDao.deleteBelong(UserId,ClubId);
    }


}
