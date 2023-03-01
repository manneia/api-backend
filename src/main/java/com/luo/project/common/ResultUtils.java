package com.luo.project.common;

/**
 * @Description 返回工具类
 * @author lkx
 */
public class ResultUtils {

    /**
     * @Description 成功
     * @param data 返回对象
     * @param <T> 返回对象类型
     * @return 返回的值
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * @Description 失败
     * @param errorCode 错误码
     * @return 返回值
     */
    public static BaseResponse<Object> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    /**
     * @Description 失败
     * @param code  失败码
     * @param message 信息
     * @return 返回值
     */
    public static BaseResponse error(int code, String message) {
        return new BaseResponse(code, null, message);
    }

    /**
     * @Description 失败
     * @param errorCode 错误码
     * @return 返回值
     */
    public static BaseResponse error(ErrorCode errorCode, String message) {
        return new BaseResponse(errorCode.getCode(), null, message);
    }
}
