package com.vipicu.demo.cloud.service.resource03.app.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.service.resource03.app.mapper.SysRoleResourceMapper;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysRoleResource;
import com.vipicu.demo.cloud.service.resource03.app.service.impl.SysRoleResourceService;
@Service
public class SysRoleResourceServiceImpl extends ServiceImpl<SysRoleResourceMapper, SysRoleResource> implements SysRoleResourceService{

}
