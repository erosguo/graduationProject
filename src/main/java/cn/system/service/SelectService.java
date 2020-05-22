package cn.system.service;

import cn.system.domain.Select;

import java.util.List;

public interface SelectService {
    public List<cn.system.domain.Select> findSelectAll();
    public List<cn.system.domain.Select> findSelectByUserId(String UserId);


}
