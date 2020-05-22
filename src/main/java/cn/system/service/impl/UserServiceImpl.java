package cn.system.service.impl;

import cn.system.dao.UserDao;
import cn.system.domain.User;
import cn.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findUserAll() {

        return userDao.findUserAll();
    }

    @Override
    public User findUserById(String UserId) {

        return userDao.findUserById(UserId);
    }

    @Override
    public List<User> findInvalidUserAll() {
        return userDao.findInvalidUserAll();
    }

    @Override
    public int saveUser(User User) {
        return userDao.saveUser(User);
    }

    @Override
    public int deleteUserById(String UserId) {
        return userDao.deleteUserById(UserId);
    }

    @Override
    public int updateUserNameById(String UserId,String UserName) {
        return userDao.updateUserNameById(UserId,UserName);
    }

    @Override
    public int updateUserPasswordById(String UserId, String UserPassword) {
        return userDao.updateUserPasswordById(UserId,UserPassword);
    }

    @Override
    public int updateUserIntroductionById(String UserId, String UserIntroduction) {
        return userDao.updateUserIntroductionById(UserId,UserIntroduction);
    }

    @Override
    public int updateUserTelById(String UserId, String UserTel) {
        return userDao.updateUserTelById(UserId,UserTel);
    }

    @Override
    public int updateUserEmailById(String UserId, String UserEmail) {
        return userDao.updateUserEmailById(UserId,UserEmail);
    }

    @Override
    public int updateUserHobbyById(String UserId, String UserHobby) {
        return userDao.updateUserHobbyById(UserId,UserHobby);
    }

    @Override
    public int updateIsEnableById(String UserId, int UserIsEnable) {
        return userDao.updateIsEnableById(UserId,UserIsEnable);
    }
}
