package com.vipicu.demo.cloud.db.h2.entity;

import com.baomidou.mybatisplus.annotation.OrderBy;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统角色
 *
 * @author oohmygosh
 * @since 2021-11-03
 */
@Getter
@Setter
@Schema(name = "SysRole", description = "系统角色")
public class SysRole extends BaseEntity {

    @Schema(description = "名称")
    @Size(max = 30)
    private String name;

    @Schema(description = "别名")
    @Size(max = 30)
    private String alias;

    @Schema(description = "备注")
    @Size(max = 255)
    private String remark;

    @Schema(description = "状态 0、禁用 1、正常")
    private Integer status;

    @OrderBy
    @Schema(description = "排序")
    @PositiveOrZero
    private Integer sort;

}
