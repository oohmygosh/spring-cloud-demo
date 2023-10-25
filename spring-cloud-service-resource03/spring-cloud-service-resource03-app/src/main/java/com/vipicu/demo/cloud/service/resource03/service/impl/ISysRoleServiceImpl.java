package com.vipicu.demo.cloud.service.resource03.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysRole;
import com.vipicu.demo.cloud.service.resource03.mapper.SysRoleMapper;
import com.vipicu.demo.cloud.service.resource03.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public List<SysRole> getRoleByUserId(Long userId) {
        return getBaseMapper().getRoleByUserId(userId);
    }
}
