package cn.system.service.impl;

import cn.system.dao.JoinActivityDao;
import cn.system.domain.JoinActivity;
import cn.system.service.JoinActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("JoinActivityService")
public class JoinActivityServiceImpl implements JoinActivityService {
    @Autowired
    private JoinActivityDao joinActivityDao;
    @Override
    public List<JoinActivity> findJoinActivityAll() {
        return joinActivityDao.findJoinActivityAll();
    }

    @Override
    public List<JoinActivity> findJoinActivityAllByActivityId(int ActivityId) {
        return joinActivityDao.findJoinActivityAllByActivityId(ActivityId);
    }

    @Override
    public List<JoinActivity> findJoinActivityAllByUserId(String UserId) {
        return joinActivityDao.findJoinActivityAllByUserId(UserId);
    }

    @Override
    public JoinActivity findUJoinActivityById(String UserId, int ActivityId) {
        return joinActivityDao.findUJoinActivityById(UserId,ActivityId);
    }

    @Override
    public int saveJoinActivity(JoinActivity joinActivity) {
        return joinActivityDao.saveJoinActivity(joinActivity);
    }

    @Override
    public int deleteJoinActivity(String UserId, int ActivityId) {
        return joinActivityDao.deleteJoinActivity(UserId,ActivityId);
    }

    @Override
    public int updateJoinActivity(String UserId, int ActivityId, int JoinActivityIsSuccess) {
        return joinActivityDao.updateJoinActivity(UserId,ActivityId,JoinActivityIsSuccess);
    }
}
