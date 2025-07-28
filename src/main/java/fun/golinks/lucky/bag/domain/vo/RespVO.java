package fun.golinks.lucky.bag.domain.vo;

import fun.golinks.lucky.bag.domain.consts.StatusCodeEnums;

/**
 * 统一mvc返回接口
 *
 * @param <T>
 */
public class RespVO<T> {

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 数据
     */
    private final T data;

    /**
     * 消息
     */
    private final String message;

    public RespVO(T data, String message, Integer code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }


    public static <T> RespVO<T> ok(T data) {
        return new RespVO<T>(data, StatusCodeEnums.SUCCESS.getMessage(), StatusCodeEnums.SUCCESS.getCode());
    }

    public static <T> RespVO<T> failed(StatusCodeEnums statusCodeEnums) {
        return new RespVO<T>(null, statusCodeEnums.getMessage(), statusCodeEnums.getCode());
    }

    public Integer getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }
}