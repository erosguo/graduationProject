package cn.system.service.impl;

import cn.system.dao.UserRelationShipDao;
import cn.system.domain.UserRelationShip;
import cn.system.service.UserRelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("UserRelationShipService")
public class UserRelationShipServiceImpl implements UserRelationShipService {
    @Autowired
    private UserRelationShipDao userRelationShipDao;
    @Override
    public List<UserRelationShip> findUserRelationShipAll() {
        return userRelationShipDao.findUserRelationShipAll();
    }

    @Override
    public List<UserRelationShip> findUserRelationShipAllByRelationshipUserId(String RelationshipUserId) {
        return userRelationShipDao.findUserRelationShipAllByRelationshipUserId(RelationshipUserId);
    }

    @Override
    public int saveUserRelationShip(UserRelationShip userRelationShip) {
        return userRelationShipDao.saveUserRelationShip(userRelationShip);
    }

    @Override
    public int deleteUserRelationShip(UserRelationShip userRelationShip) {
        return userRelationShipDao.deleteUserRelationShip(userRelationShip);
    }
}
