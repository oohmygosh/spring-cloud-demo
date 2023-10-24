package com.vipicu.demo.cloud.service.resource03.app.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.service.resource03.app.mapper.SysUserRoleMapper;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysUserRole;
import com.vipicu.demo.cloud.service.resource03.app.service.impl.SysUserRoleService;
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService{

}
