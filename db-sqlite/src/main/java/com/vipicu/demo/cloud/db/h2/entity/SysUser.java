package com.vipicu.demo.cloud.db.h2.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统用户
 *
 * @author oohmygosh
 * @since 2021-11-03
 */
@Getter
@Setter
@Schema(name = "SysUser", description = "系统用户")
public class SysUser extends BaseEntity {

    @Schema(description = "账号")
    @Size(max = 20)
    private String username;

    @Schema(description = "密码")
    @Size(max = 32)
    private String password;

    @Schema(description = "随机盐")
    private String salt;

    @Schema(description = "真实名称")
    @Size(max = 100)
    private String realName;

    @Schema(description = "昵称")
    @Size(max = 20)
    private String nickName;

    @Schema(description = "头像")
    @Size(max = 200)
    private String avatar;

    @Schema(description = "性别")
    private String sex;

    @Schema(description = "手机号")
    @Size(max = 11)
    private String phone;

    @Schema(description = "手机号是否验证 0、否 1、是")
    private Integer phoneVerified;

    @Schema(description = "邮箱")
    @Size(max = 100)
    private String email;

    @Schema(description = "邮箱是否验证 0、否 1、是")
    private Integer emailVerified;

    @Schema(description = "状态 0、禁用 1、正常")
    private Integer status;

}
