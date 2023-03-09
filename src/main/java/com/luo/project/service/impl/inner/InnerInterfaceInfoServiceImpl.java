package com.luo.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luo.apicommon.model.entity.InterfaceInfo;
import com.luo.apicommon.service.InnerInterfaceInfoService;
import com.luo.project.common.ErrorCode;
import com.luo.project.exception.BusinessException;
import com.luo.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author lkx
 * @version 1.0.0
 * @Description
 */
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {
    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url,method)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> interfaceInfoQueryWrapper = new QueryWrapper<>();
        interfaceInfoQueryWrapper.eq("url",url);
        interfaceInfoQueryWrapper.eq("method",method);
        return interfaceInfoMapper.selectOne(interfaceInfoQueryWrapper);
    }
}
