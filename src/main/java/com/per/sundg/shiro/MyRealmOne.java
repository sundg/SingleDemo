package com.per.sundg.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * <br>
 *
 * @ClassName: MyRealmOne
 * @Description: TODO
 * @Author sundg
 * @Date 2019/2/26 10:15
 * @VERSION 1.0
 */
public class MyRealmOne implements Realm {
    private static final Logger LOGGER = Logger.getLogger(MyRealmOne.class);
    @Override
    public String getName() {
        LOGGER.info("MyRealmOne->getName()");
        return "myRealmOne";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        LOGGER.info("MyRealmOne->supports()");
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOGGER.info("MyRealmOne->getAuthenticationInfo()");

        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        if(!"test".equals(userName)){
            throw new UnknownAccountException();
        }
        if (!"123456".equals(password)) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(userName,password,getName());
    }
}
