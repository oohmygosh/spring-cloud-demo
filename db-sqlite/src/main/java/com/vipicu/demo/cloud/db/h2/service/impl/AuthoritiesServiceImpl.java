package com.vipicu.demo.cloud.db.h2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.db.h2.entity.Authorities;
import com.vipicu.demo.cloud.db.h2.mapper.AuthoritiesMapper;
import com.vipicu.demo.cloud.db.h2.service.AuthoritiesService;
import org.springframework.stereotype.Service;
@Service
public class AuthoritiesServiceImpl extends ServiceImpl<AuthoritiesMapper, Authorities> implements AuthoritiesService{

}
