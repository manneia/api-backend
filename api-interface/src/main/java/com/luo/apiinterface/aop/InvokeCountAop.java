package com.luo.apiinterface.aop;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lkx
 * @version 1.0.0
 * @Description 调用次数切面
 */
@RestControllerAdvice
public class InvokeCountAop {
    // 1. 定义切面触发的时机 (什么时候执行方法) controller 接口的方法执行成功后, 执行下述的方法
    // public void doInvokeCount (xxx) {
            // 调用方法
            // 调用成功后次数 + 1
    // }
}
