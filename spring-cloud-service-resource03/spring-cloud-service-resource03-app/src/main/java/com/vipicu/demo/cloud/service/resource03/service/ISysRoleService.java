package com.vipicu.demo.cloud.service.resource03.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysRole;

import java.util.List;

public interface ISysRoleService extends IService<SysRole>{
    /**
     * 获取用户的角色
     *
     * @param userId 用户id
     * @return {@link List}<{@link SysRole}>
     */
    List<SysRole> getRoleByUserId(Long userId);

}
