package com.per.sundg.mybatis.caseone;

import com.per.sundg.common.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

@Slf4j
public class UseTset {

    @Test
    public void test(){
        UserDao userDao = new UserDao();
        List<User> users = userDao.findAll();
        log.info("用户数："+ users.size());
    }

}
