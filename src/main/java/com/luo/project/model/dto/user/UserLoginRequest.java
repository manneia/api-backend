package com.luo.project.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 用户登录请求体
 * @author lkx
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;
}
