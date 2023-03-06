package com.luo.project.service;

import com.luo.project.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lkx
* @Description  针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service
* @createDate 2023-03-04 12:21:56
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
     * @param interfaceInfoId 调用的接口id
     * @param userId 调用该接口的用户id
     * @return 返回是否更新成功
     */
    boolean invokeCount(long interfaceInfoId,long userId);
}
