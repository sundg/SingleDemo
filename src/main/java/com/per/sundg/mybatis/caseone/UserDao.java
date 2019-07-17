package com.per.sundg.mybatis.caseone;

import com.per.sundg.common.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDao {

    public List<User> findAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<User> users = sqlSession.selectList("com.per.sundg.mybatis.caseone.UserDao.findAll");
        sqlSession.close();
        return users;
    }
}
