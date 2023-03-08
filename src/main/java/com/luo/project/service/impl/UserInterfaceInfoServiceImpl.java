package com.luo.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luo.apicommon.model.entity.InterfaceInfo;
import com.luo.apicommon.model.entity.UserInterfaceInfo;
import com.luo.apicommon.service.InnerUserInterfaceInfoService;
import com.luo.project.common.ErrorCode;
import com.luo.project.exception.BusinessException;
import com.luo.project.mapper.UserInterfaceInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @author lkx
 * @Description  针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service实现
 * @createDate 2023-03-04 12:21:56
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements InnerUserInterfaceInfoService {

    /**
     * @param userInterfaceInfo 接口信息请求参数
     * @param add               true/false
     * @Description 请求参数校验
     */
    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }

        if (userInterfaceInfo.getLeftNum() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "当前用户调用次数已耗尽");
        }
    }

    /**
     * 调用接口统计
     *
     * @param interfaceInfoId 调用的接口id
     * @param userId          调用该接口的用户id
     * @return 返回更新后的次数
     */
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> userInterfaceInfoQueryWrapper = new UpdateWrapper<>();
        userInterfaceInfoQueryWrapper.eq("interfaceInfoId", interfaceInfoId);
        userInterfaceInfoQueryWrapper.eq("userId", userId);
        userInterfaceInfoQueryWrapper.gt("leftNum",0);
        userInterfaceInfoQueryWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(userInterfaceInfoQueryWrapper);
    }

    @Override
    public boolean getInvokeUser(String accessKey, String secretKey) {
        return false;
    }

    @Override
    public InterfaceInfo getInterfaceInfo(String path, String method) {
        return null;
    }
}




