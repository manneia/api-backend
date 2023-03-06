package com.luo.project.service;

import com.luo.project.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lkx
* @Description  针对表【interface_info(接口信息表)】的数据库操作Service
* @createDate 2023-03-01 20:28:37
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 请求参数校验
     * @param interfaceInfo 接口信息请求参数
     * @param add true/false
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
