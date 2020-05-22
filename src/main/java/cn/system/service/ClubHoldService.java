package cn.system.service;

import cn.system.domain.ClubHold;

import java.util.List;

public interface ClubHoldService {
    public List<ClubHold> findClubHoldAll();
    public List<ClubHold> findClubHoldAllByClubId(int ClubId);
    public int saveClubHold(ClubHold clubHold);
    public int deleteClubHold(ClubHold clubHold);
}
