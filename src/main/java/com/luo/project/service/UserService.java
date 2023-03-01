package com.luo.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.luo.project.model.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lkx
 * @Description 用户服务
 */
public interface UserService extends IService<User> {

    /**
     * @Description 用户注册
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * @Description 用户登录
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request 当前登录用户请求参数
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * @Description 获取当前登录用户
     * @param request 当前登录用户请求参数
     * @return 返回当前登录用户
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * @Description 是否为管理员
     * @param request 当前登录用户请求参数
     * @return 返回是否为管理员
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * @Description 用户注销
     * @param request 当前登录用户请求参数
     * @return 返回是否注销成功
     */
    boolean userLogout(HttpServletRequest request);
}
