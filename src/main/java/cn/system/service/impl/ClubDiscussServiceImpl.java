package cn.system.service.impl;

import cn.system.dao.ClubDiscussDao;
import cn.system.domain.ClubDiscuss;
import cn.system.service.ClubDiscussService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClubDiscuss")
public class ClubDiscussServiceImpl implements ClubDiscussService {
    @Autowired
    private ClubDiscussDao clubDiscussDao;
    @Override
    public List<ClubDiscuss> findClubDiscussAll() {
        //pageNum为页码值，pagesize为每页显示条数，必须在调用查询之前中间不能有其他语句
        PageHelper.startPage(1,3);
        return clubDiscussDao.findClubDiscussAll();
    }


    @Override
    public List<ClubDiscuss> findClubDiscussByClubIdAll(int ClubId) {
        return clubDiscussDao.findClubDiscussAllByClubId(ClubId);
    }

    @Override
    public List<ClubDiscuss> findClubDiscussByClubIdPageAll(int ClubId,int page,int size) {
        PageHelper.startPage(page,size);
        return clubDiscussDao.findClubDiscussAllByClubId(ClubId);
    }

    @Override
    public ClubDiscuss findClubDiscussByClubDiscussId(int ClubDiscussId) {
        return clubDiscussDao.findClubDiscussByClubDiscussId(ClubDiscussId);
    }

    @Override
    public int saveClubDiscuss(ClubDiscuss clubDiscuss) {
        return clubDiscussDao.saveClubDiscuss(clubDiscuss);
    }

    @Override
    public ClubDiscuss findClubDiscussBiggestId() {
        return clubDiscussDao.findClubDiscussBiggestId();
    }

    @Override
    public int updateClubDiscussComment(int ClubDiscussId, String ClubDiscussComment) {
        return clubDiscussDao.updateClubDiscussComment(ClubDiscussId,ClubDiscussComment);
    }

    @Override
    public int updateClubDiscussClick(int ClubDiscussId, int ClubDiscussClickNumber) {
        return clubDiscussDao.updateClubDiscussClick(ClubDiscussId,ClubDiscussClickNumber);
    }
}
