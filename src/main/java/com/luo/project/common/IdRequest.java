package com.luo.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 通用请求
 * @author lkx
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}