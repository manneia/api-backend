package com.luo.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luo.project.common.ErrorCode;
import com.luo.project.exception.BusinessException;
import com.luo.project.mapper.InterfaceInfoMapper;
import com.luo.project.model.entity.InterfaceInfo;
import com.luo.project.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author lkx
 * @Description 针对表【interface_info(接口信息表)】的数据库操作Service实现
 * @createDate 2023-03-01 20:28:37
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {


    /**
     * @param interfaceInfo 接口信息请求参数
     * @param add           true/false
     * @Description 请求参数校验
     */
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();

        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        int nameMaxLen = 50;
        if (StringUtils.isNotBlank(name) && name.length() > nameMaxLen) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }

    }
}




