package cn.system.service;

import cn.system.domain.Belong;

import java.util.List;

public interface BelongService {
    public List<Belong> findBelongAll();
    public List<Belong> findBelongAllByUserId(String UserId);
    public List<Belong> findBelongAllByClubId(int ClubId);
    public List<Belong> findBelongInvalidAllByClubId(int ClubId);
    public List<Belong> findBelongValidAllByClubId(int ClubId);
    public List<Belong> findBelongValidAllByUserId(String UserId);
    public List<Belong> findBelongInvalidAllByUserId(String UserId);
    public Belong findUBelongByUserId(String UserId,int ClubId);

    public int saveBelong(Belong belong);
    public int updateBelongIsEnable(String UserId,int ClubId,int BelongIsEnable);
    public int deleteBelong(String UserId,int ClubId);
}
