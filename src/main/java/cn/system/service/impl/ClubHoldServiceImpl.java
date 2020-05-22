package cn.system.service.impl;

import cn.system.dao.ClubHoldDao;
import cn.system.domain.ClubHold;
import cn.system.service.ClubHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClubHoldService")
public class ClubHoldServiceImpl implements ClubHoldService {
    @Autowired
    private ClubHoldDao clubHoldDao;
    @Override
    public List<ClubHold> findClubHoldAll() {
        return clubHoldDao.findClubHoldAll();
    }

    @Override
    public List<ClubHold> findClubHoldAllByClubId(int ClubId) {
        return clubHoldDao.findClubHoldAllByClubId(ClubId);
    }

    @Override
    public int saveClubHold(ClubHold clubHold) {
        return clubHoldDao.saveClubHold(clubHold);
    }

    @Override
    public int deleteClubHold(ClubHold clubHold) {
        return clubHoldDao.deleteClubHold(clubHold);
    }
}
