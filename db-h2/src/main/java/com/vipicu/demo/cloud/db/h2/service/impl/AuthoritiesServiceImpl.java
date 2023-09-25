package com.vipicu.demo.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.db.entity.Authorities;
import com.vipicu.demo.db.mapper.AuthoritiesMapper;
import com.vipicu.demo.db.service.AuthoritiesService;
import org.springframework.stereotype.Service;
@Service
public class AuthoritiesServiceImpl extends ServiceImpl<AuthoritiesMapper, Authorities> implements AuthoritiesService{

}
