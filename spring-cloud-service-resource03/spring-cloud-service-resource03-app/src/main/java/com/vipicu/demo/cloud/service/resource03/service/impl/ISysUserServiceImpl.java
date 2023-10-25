package com.vipicu.demo.cloud.service.resource03.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysRole;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysUser;
import com.vipicu.demo.cloud.service.resource03.api.entity.UserInfo;
import com.vipicu.demo.cloud.service.resource03.mapper.SysUserMapper;
import com.vipicu.demo.cloud.service.resource03.service.ISysResourceApiService;
import com.vipicu.demo.cloud.service.resource03.service.ISysRoleService;
import com.vipicu.demo.cloud.service.resource03.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ISysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private final ISysResourceApiService resourceApiService;
    private final ISysRoleService roleService;

    @Override
    public UserInfo fetchUserInfo(@NonNull SysUser sysUser) {
        UserInfo userInfo = new UserInfo();
        userInfo.setSysUser(sysUser);
        // 获取权限标识符
        List<String> authorities = resourceApiService.selectCodesByUserId(sysUser.getId());
        // 获取角色
        List<String> roles = roleService.getRoleByUserId(sysUser.getId()).stream().map(SysRole::getAlias).collect(Collectors.toList());
        userInfo.setAuthorities(authorities);
        userInfo.setRoles(roles);
        return userInfo;
    }
}
