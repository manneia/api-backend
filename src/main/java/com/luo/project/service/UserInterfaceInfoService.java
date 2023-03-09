package com.luo.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luo.apicommon.model.entity.InterfaceInfo;
import com.luo.apicommon.model.entity.UserInterfaceInfo;

/**
 * @author lkx
 * @version 1.0.0
 * @Description
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 请求参数校验
     * @param userInterfaceInfo 接口信息请求参数
     * @param add true/false
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId 接口id
     * @param userId 用户id
     * @return 返回是否更新成功
     */
    boolean invokeCount(long interfaceInfoId,long userId);
}
