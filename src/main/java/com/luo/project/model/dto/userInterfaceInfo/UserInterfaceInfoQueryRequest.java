package com.luo.project.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lkx
 * @version 1.0.0
 * @Description 查询请求
 */
@Data
public class UserInterfaceInfoQueryRequest implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 调用用户 Id
     */
    private Long userId;

    /**
     * 接口 Id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 0 - 正常, 1 - 禁用
     */
    private Integer status;


    private long current;

    private String sortField;

    private long pageSize;

    private String sortOrder;

    private String content;

    private static final long serialVersionUID = 6565105959054363984L;

}
