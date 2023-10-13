package com.vipicu.demo.cloud.db.h2.mapper;

import com.vipicu.demo.cloud.db.h2.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 系统角色 Mapper 接口
 * </p>
 *
 * @author oohmygosh
 * @since 2021-11-03
 */
@Mapper
public interface SysRoleMapper extends CrudMapper<SysRole> {

    /**
     * 获取用户的角色
     *
     * @param userId 用户id
     * @return {@link List}<{@link SysRole}>
     */
    @Select("SELECT * FROM sys_role WHERE id in (select role_id from sys_user_role WHERE user_id = #{userId})")
    List<SysRole> getRoleByUserId(Long userId);

}
