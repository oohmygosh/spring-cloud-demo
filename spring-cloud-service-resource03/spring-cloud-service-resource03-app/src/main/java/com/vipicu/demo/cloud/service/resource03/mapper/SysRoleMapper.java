package com.vipicu.demo.cloud.service.resource03.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 获取用户的角色
     *
     * @param userId 用户id
     * @return {@link List}<{@link SysRole}>
     */
    @Select("SELECT * FROM sys_role WHERE id in (select role_id from sys_user_role WHERE user_id = #{userId})")
    List<SysRole> getRoleByUserId(Long userId);
}
