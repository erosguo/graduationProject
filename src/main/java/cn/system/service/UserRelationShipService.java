package cn.system.service;

import cn.system.domain.UserRelationShip;

import java.util.List;

public interface UserRelationShipService {
    public List<UserRelationShip> findUserRelationShipAll();
    public List<UserRelationShip> findUserRelationShipAllByRelationshipUserId(String RelationshipUserId);
    public int saveUserRelationShip(UserRelationShip userRelationShip);
    public int deleteUserRelationShip(UserRelationShip userRelationShip);


}
