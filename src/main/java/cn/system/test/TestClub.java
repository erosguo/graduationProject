package cn.system.test;

import cn.system.dao.ClubDao;
import cn.system.domain.Club;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestClub {
    private InputStream inputStream;
    private SqlSession session;
    private ClubDao clubDao;
    @Before
    public void init() throws Exception {
        // 加载配置文件
        inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession对象
        session = factory.openSession();
        // 获取代理对象
        clubDao = session.getMapper(ClubDao.class);


    }
    @Test
    public void testClubFindByName(){
        // 调用查询的方法
        List<Club> list = clubDao.findClubByName("默认");
        for (Club club : list) {
            System.out.println(club);
        }
    }

    @After
    public void destroy() throws Exception{
        // 释放资源
        session.close();
        inputStream.close();
    }
}
