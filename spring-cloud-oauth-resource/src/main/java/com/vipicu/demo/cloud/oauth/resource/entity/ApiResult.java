package com.vipicu.demo.cloud.oauth.resource.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**

 * ----------------------------------------
 * API 返回结果
 *
 * @author oohmygosh
 * @since 2021-10-28
 */
@Getter
@Setter
@Accessors(chain = true)
public class ApiResult<T> implements Serializable {
    /**
     * serialVersionUID
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 业务错误码
     */
    @Schema(description = "响应码")
    private long code;
    /**
     * 结果集
     */
    @Schema(description = "结果集")
    private T data;
    /**
     * 描述
     */
    @Schema(description = "描述")
    private String message;

    public ApiResult() {
        // to do nothing
    }


    public static <T> ApiResult<T> result(T data, long code, String message) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMessage(message);
        return apiResult;
    }
}
