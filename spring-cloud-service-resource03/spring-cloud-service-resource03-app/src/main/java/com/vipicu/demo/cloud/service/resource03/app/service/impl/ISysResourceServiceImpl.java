package com.vipicu.demo.cloud.service.resource03.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysResource;
import com.vipicu.demo.cloud.service.resource03.app.mapper.SysResourceMapper;
import com.vipicu.demo.cloud.service.resource03.app.service.ISysResourceService;
import org.springframework.stereotype.Service;

@Service
public class ISysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements ISysResourceService {

}
