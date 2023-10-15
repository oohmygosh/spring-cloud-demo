package com.vipicu.demo.cloud.db.h2.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统资源接口
 *
 * @author oohmygosh
 * @since 2022-02-26
 */
@Getter
@Setter
@Schema(name = "SysResourceApi", description = "系统资源")
public class SysResourceApi extends SuperEntity {

    @Schema(description = "资源ID")
    @PositiveOrZero
    private Long resourceId;

    @Schema(description = "接口地址")
    @Size(max = 255)
    private String url;

    @Schema(description = "编码")
    @Size(max = 100)
    private String code;

}
