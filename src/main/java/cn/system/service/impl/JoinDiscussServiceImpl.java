package cn.system.service.impl;

import cn.system.dao.JoinDiscussDao;
import cn.system.domain.JoinDiscuss;
import cn.system.service.JoinDiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("JoinDiscuss")
public class JoinDiscussServiceImpl implements JoinDiscussService {
    @Autowired
    private JoinDiscussDao joinDiscussDao;

    @Override
    public List<JoinDiscuss> findJoinDiscussAll() {
        return joinDiscussDao.findJoinDiscussAll();
    }

    @Override
    public List<JoinDiscuss> findJoinDiscussAllByUserId(String UserId) {
        return joinDiscussDao.findJoinDiscussAllByUserId(UserId);
    }

    @Override
    public JoinDiscuss findJoinDiscussById(String UserId, int ClubDiscuss) {
        return joinDiscussDao.findJoinDiscussById(UserId,ClubDiscuss);
    }

    @Override
    public int saveJoinDiscuss(JoinDiscuss joinDiscuss) {

        return joinDiscussDao.saveJoinDiscuss(joinDiscuss);
    }
}
