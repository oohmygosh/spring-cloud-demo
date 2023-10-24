package com.vipicu.demo.cloud.service.resource03.app.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysRole;
import com.vipicu.demo.cloud.service.resource03.app.mapper.SysRoleMapper;
import com.vipicu.demo.cloud.service.resource03.app.service.impl.SysRoleService;
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService{

}
