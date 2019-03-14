package com.per.sundg.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * <br>
 *
 * @ClassName: ShiroDemo
 * @Description: TODO
 * @Author sundg
 * @Date 2019/2/25 15:20
 * @VERSION 1.0
 */
public class ShiroDemo {

    private static final Logger LOGGER = Logger.getLogger(ShiroDemo.class);

    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("test","000000");
        System.out.println(subject.isAuthenticated());
        try {
            subject.login(token);
            if(subject.isAuthenticated()){
                System.out.println("登录成功");
                if (subject.hasRole("admin")){
                    System.out.println("有admin角色");
                }else {
                    System.out.println("没有admin角色");
                }
                if (subject.isPermitted("find")){
                    System.out.println("有查看权限");
                }else {
                    System.out.println("没有查看权限");
                }
                if (subject.isPermitted("add")){
                    System.out.println("有新增权限");
                }else {
                    System.out.println("没有新增权限");
                }
                if (subject.isPermitted("update")){
                    System.out.println("有修改权限");
                }else {
                    System.out.println("没有修改权限");
                }
                if (subject.isPermitted("del")){
                    System.out.println("有删除权限");
                }else {
                    System.out.println("没有删除权限");
                }
            }
        } catch (AuthenticationException e) {
           LOGGER.error("用户名或密码错误",e);
        }

    }
}
