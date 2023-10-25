package com.vipicu.demo.cloud.core.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**

 * ----------------------------------------
 * 业务框架基础实体
 *
 * @author oohmygosh
 * @since 2021-10-28
 */
@Setter
@Getter
public class BaseEntity extends SuperEntity {

    /**
     * 创建人ID
     */
    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "创建人ID")
    protected Long createId;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "创建人")
    protected String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "创建时间")
    protected Date createTime;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.UPDATE)
    @Schema(description = "修改人")
    protected String updateBy;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    @Schema(description = "修改时间")
    protected Date updateTime;

    /**
     * 删除 0、否 1、是
     */
    @TableLogic(value = "0", delval = "1")
    @Schema(description = "删除 0:否 1:是")
    private Integer deleted;

}
