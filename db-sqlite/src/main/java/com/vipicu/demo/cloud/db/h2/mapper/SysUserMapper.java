package com.vipicu.demo.cloud.db.h2.mapper;

import com.vipicu.demo.cloud.db.h2.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author oohmygosh
 * @since 2021-11-03
 */
@Mapper
public interface SysUserMapper extends CrudMapper<SysUser> {


}
