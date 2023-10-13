package com.vipicu.demo.cloud.db.h2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.db.h2.entity.SysRole;
import com.vipicu.demo.cloud.db.h2.mapper.SysRoleMapper;
import com.vipicu.demo.cloud.db.h2.service.ISysRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 系统角色 服务实现类
 *
 * @author oohmygosh
 * @since 2021-11-03
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

}
