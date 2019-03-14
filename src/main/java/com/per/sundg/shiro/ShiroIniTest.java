package com.per.sundg.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;

/**
 * <br>
 *
 * @ClassName: ShiroIniTest
 * @Description: TODO
 * @Author sundg
 * @Date 2019/2/26 9:32
 * @VERSION 1.0
 */
public class ShiroIniTest {

    private static final Logger LOGGER = Logger.getLogger(ShiroIniTest.class);

    public static void main(String[] args) {
        //AuthenticationInfo代表了用户的角色信息集合，AuthorizationInfo代表了角色的权限信息集合
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        securityManager.setAuthenticator(authenticator);

        ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
        authorizer.setPermissionResolver(new WildcardPermissionResolver());
        securityManager.setAuthorizer(authorizer);
        securityManager.setRealm(new MyRealmOne());
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject =SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("test","123455");
        try {
            subject.login(token);
            if(subject.isAuthenticated()){
                LOGGER.info("登录成功");
            }
        } catch (AuthenticationException e) {
            LOGGER.error("用户名或密码错误",e);
        }

    }
}
