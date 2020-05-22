package cn.system.service;

import cn.system.dao.JoinDiscussDao;
import cn.system.domain.JoinDiscuss;


import java.util.List;

public interface JoinDiscussService {
    public List<JoinDiscuss> findJoinDiscussAll();
    public List<JoinDiscuss> findJoinDiscussAllByUserId(String UserId);
    public JoinDiscuss findJoinDiscussById(String UserId,int ClubDiscuss);
    public int saveJoinDiscuss(JoinDiscuss joinDiscuss);

}
