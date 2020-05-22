package cn.system.service.impl;

import cn.system.dao.PersonHoldDao;
import cn.system.domain.PersonHold;
import cn.system.service.PersonHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("PersonHoldService")
public class PersonHoldServiceImpl implements PersonHoldService {
    @Autowired
    private PersonHoldDao personHoldDao;
    @Override
    public List<PersonHold> findPersonHoldAll() {
        return personHoldDao.findPersonHoldAll();
    }

    @Override
    public List<PersonHold> findPersonHoldAllByUserId(String UserId) {
        return personHoldDao.findPersonHoldAllByUserId(UserId);
    }

    @Override
    public int savePersonHold(PersonHold personHold) {
        return personHoldDao.savePersonHold(personHold);
    }

    @Override
    public int deletePersonHold(PersonHold personHold) {
        return personHoldDao.deletePersonHold(personHold);
    }
}
