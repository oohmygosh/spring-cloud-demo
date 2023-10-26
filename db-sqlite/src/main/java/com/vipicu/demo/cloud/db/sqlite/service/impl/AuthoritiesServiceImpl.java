package com.vipicu.demo.cloud.db.sqlite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.db.sqlite.entity.Authorities;
import com.vipicu.demo.cloud.db.sqlite.mapper.AuthoritiesMapper;
import com.vipicu.demo.cloud.db.sqlite.service.AuthoritiesService;
import org.springframework.stereotype.Service;
@Service
public class AuthoritiesServiceImpl extends ServiceImpl<AuthoritiesMapper, Authorities> implements AuthoritiesService{

}
