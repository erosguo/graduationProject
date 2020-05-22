package cn.system.test;


import cn.system.dao.UserDao;
import cn.system.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestUser{
    private InputStream inputStream;
    private SqlSession session;
    private UserDao userDao;
    @Before
    public void init() throws Exception {
        // 加载配置文件
        inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession对象
        session = factory.openSession();
        // 获取代理对象
        userDao = session.getMapper(UserDao.class);


    }
    @Test
    public void testUserFindAll(){
        // 调用查询的方法
        List<User> list = userDao.findUserAll();
        for (User account : list) {
            System.out.println(account);
        }
    }

    @After
    public void destroy() throws Exception{
        // 释放资源
        session.close();
        inputStream.close();
    }

}
