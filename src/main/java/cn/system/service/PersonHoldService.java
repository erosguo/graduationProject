package cn.system.service;

import cn.system.domain.PersonHold;

import java.util.List;

public interface PersonHoldService {
    public List<PersonHold> findPersonHoldAll();
    public List<PersonHold> findPersonHoldAllByUserId(String UserId);
    public int savePersonHold(PersonHold personHold);
    public int deletePersonHold(PersonHold personHold);



}
