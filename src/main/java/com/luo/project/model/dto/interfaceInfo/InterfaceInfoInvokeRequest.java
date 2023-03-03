package com.luo.project.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lkx
 * @version 1.0.0
 * @Description 测试调用接口请求参数
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户请求参数
     */
    private String userRequestParams;

    private static final long serialVersionUID = -4006799223105967274L;
}
