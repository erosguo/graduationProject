package cn.system.service.impl;

import cn.system.dao.SelectDao;
import cn.system.service.SelectService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelectService")
public class SelectServiceImpl implements SelectService {
    @Autowired
    private SelectDao selectDao;

    @Override
    public List<cn.system.domain.Select> findSelectAll() {
        return selectDao.findSelectAll();
    }

    @Override
    public List<cn.system.domain.Select> findSelectByUserId(String UserId) {
        return selectDao.findSelectByUserId(UserId);
    }
}
