package cn.system.service;

import cn.system.domain.ClubManager;

import java.util.List;

public interface ClubManagerService {
    //
    public List<ClubManager> findClubManagerAll();
    //
    public ClubManager findClubManagerById(String ClubManagerId);
    //
    public int saveClubManager(ClubManager clubManager);
    //
    public int updateClubManagerNameById(String ClubManagerId,String ClubManagerName);
    //
    public int updateClubManagerPasswordById(String ClubManagerId,String ClubManagerPassword);
    //
    public int updateClubManagerTelById(String ClubManagerId,String ClubManagerTel);
    //
    public int updateClubManagerEmailById(String ClubManagerId,String ClubManagerEmail);

}
