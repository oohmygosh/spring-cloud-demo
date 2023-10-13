package com.vipicu.demo.cloud.db.h2.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**

 * ----------------------------------------
 * 基础类
 *
 * @author oohmygosh
 * @since 2021-10-28
 */
@Setter
@Getter
public class SuperEntity implements BeanConvert {

    /**
     * 主键
     */
    @Schema(description = "主键")
    private Long id;

}
