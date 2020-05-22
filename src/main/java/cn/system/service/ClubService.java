package cn.system.service;

import cn.system.domain.Club;

import java.util.List;
import java.util.Map;

public interface ClubService {

    //
    public List<Club> findClubAll();

    public List<Club> findClubValidAll();

    public List<Club> findClubInvalidAll();
    //
    public Club findClubById(int ClubId);
    //
    public int saveClub(Club club);
    //
    public int updateClubNoticeById(int ClubId,String ClubNotice);
    //
    public Club findClubBiggestId();
    //
    public int updateClubIsEnable(int ClubId,int ClubIsEnable);
    //
    public  int deleteClubById(int ClubId);
    public List<Club> findClubByName(String ClubName);
    public Club findClubByUName(String ClubName);

}
