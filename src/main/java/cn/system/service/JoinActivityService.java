package cn.system.service;

import cn.system.domain.JoinActivity;

import java.util.List;

public interface JoinActivityService {
    public List<JoinActivity> findJoinActivityAll();
    public List<JoinActivity> findJoinActivityAllByActivityId(int ActivityId);
    public List<JoinActivity> findJoinActivityAllByUserId(String UserId);
    public JoinActivity findUJoinActivityById(String UserId,int ActivityId);
    public int saveJoinActivity(JoinActivity joinActivity);
    public int deleteJoinActivity(String UserId,int ActivityId);
    public int updateJoinActivity(String UserId,int ActivityId,int JoinActivityIsSuccess);





}
