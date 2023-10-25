package com.vipicu.demo.cloud.service.resource03.api.entity;

import com.vipicu.demo.cloud.core.entity.SuperEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统用户角色
 *
 * @author oohmygosh
 * @since 2021-11-03
 */
@Getter
@Setter
@Schema(name = "SysUserRole", description = "系统用户角色")
public class SysUserRole extends SuperEntity {

    @Schema(description = "用户ID")
    @PositiveOrZero
    private Long userId;

    @Schema(description = "角色ID")
    @PositiveOrZero
    private Long roleId;

}
