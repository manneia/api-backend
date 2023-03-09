package com.luo.project.service.impl.inner;

import com.luo.apicommon.model.entity.UserInterfaceInfo;
import com.luo.apicommon.service.InnerUserInterfaceInfoService;
import com.luo.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author lkx
 * @version 1.0.0
 * @Description
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId,userId);
    }
}
