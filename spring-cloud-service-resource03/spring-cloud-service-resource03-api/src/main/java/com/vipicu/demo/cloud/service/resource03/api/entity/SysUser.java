package com.vipicu.demo.cloud.service.resource03.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Schema
@Data
@TableName(value = "main.sys_user")
public class SysUser implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @Schema(description="")
    private Integer id;

    @TableField(value = "create_id")
    @Schema(description="")
    private Integer createId;

    @TableField(value = "create_by")
    @Schema(description="")
    private String createBy;

    @TableField(value = "create_time")
    @Schema(description="")
    private Date createTime;

    @TableField(value = "update_by")
    @Schema(description="")
    private String updateBy;

    @TableField(value = "update_time")
    @Schema(description="")
    private Date updateTime;

    @TableField(value = "deleted")
    @Schema(description="")
    private Integer deleted;

    @TableField(value = "username")
    @Schema(description="")
    private String username;

    @TableField(value = "\"password\"")
    @Schema(description="")
    private String password;

    @TableField(value = "salt")
    @Schema(description="")
    private String salt;

    @TableField(value = "real_name")
    @Schema(description="")
    private String realName;

    @TableField(value = "nick_name")
    @Schema(description="")
    private String nickName;

    @TableField(value = "avatar")
    @Schema(description="")
    private String avatar;

    @TableField(value = "sex")
    @Schema(description="")
    private String sex;

    @TableField(value = "phone")
    @Schema(description="")
    private String phone;

    @TableField(value = "phone_verified")
    @Schema(description="")
    private Integer phoneVerified;

    @TableField(value = "email")
    @Schema(description="")
    private String email;

    @TableField(value = "email_verified")
    @Schema(description="")
    private Integer emailVerified;

    @TableField(value = "\"status\"")
    @Schema(description="")
    private Integer status;

    private static final long serialVersionUID = 1L;
}