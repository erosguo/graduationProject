package cn.system.service;

import cn.system.domain.ClubDiscuss;

import java.util.List;

public interface ClubDiscussService {
    public List<ClubDiscuss> findClubDiscussAll();
    public List<ClubDiscuss> findClubDiscussByClubIdPageAll(int ClubId,int page,int size);
    public List<ClubDiscuss> findClubDiscussByClubIdAll(int ClubId);
    public ClubDiscuss findClubDiscussByClubDiscussId(int ClubDiscussId);
    public int saveClubDiscuss(ClubDiscuss clubDiscuss);
    public ClubDiscuss findClubDiscussBiggestId();
    public int updateClubDiscussComment(int ClubDiscussId,String ClubDiscussComment);
    public int updateClubDiscussClick(int ClubDiscussId,int ClubDiscussClickNumber);


}
