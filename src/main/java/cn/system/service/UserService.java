package cn.system.service;

import cn.system.domain.User;

import java.util.List;

public interface UserService {
    //
    public List<User> findUserAll();
    //
    public User findUserById(String UserId);
    //
    public List<User> findInvalidUserAll();
    //
    public int saveUser(User User);
    //
    public int deleteUserById(String UserId);
    //
    public int updateUserNameById(String UserId,String UserName);
    //
    public int updateUserPasswordById(String UserId,String UserPassword);
    //
    public int updateUserIntroductionById(String UserId,String UserIntroduction);
    //
    public int updateUserTelById(String UserId,String UserTel);
    //
    public int updateUserEmailById(String UserId,String UserEmail);
    //
    public int updateUserHobbyById(String UserId,String UserHobby);
    //
    public int updateIsEnableById(String UserId,int UserIsEnable);
}
