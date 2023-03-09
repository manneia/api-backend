package com.luo.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luo.apicommon.model.entity.User;
import com.luo.apicommon.service.InnerUserService;
import com.luo.project.common.ErrorCode;
import com.luo.project.exception.BusinessException;
import com.luo.project.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author lkx
 * @version 1.0.0
 * @Description
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey, String secretKey) {
        if (StringUtils.isAnyBlank(accessKey,secretKey)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("accessKey",accessKey);
        userQueryWrapper.eq("secretKey",secretKey);
        return userMapper.selectOne(userQueryWrapper);
    }
}
