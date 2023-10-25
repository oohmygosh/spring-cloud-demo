package com.vipicu.demo.cloud.service.resource03.api.entity;

import com.vipicu.demo.cloud.core.entity.SuperEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统角色资源
 *
 * @author oohmygosh
 * @since 2021-11-07
 */
@Getter
@Setter
@Schema(name = "SysRoleResource", description = "系统角色资源")
public class SysRoleResource extends SuperEntity {

    @Schema(description = "角色ID")
    @PositiveOrZero
    private Long roleId;

    @Schema(description = "资源ID")
    @PositiveOrZero
    private Long resourceId;

}
