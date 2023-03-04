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
     * @Description 请求参数校验
     * @param userInterfaceInfo 接口信息请求参数
     * @param add true/false
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);
}
