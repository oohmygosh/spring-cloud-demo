package com.vipicu.demo.cloud.db.h2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.db.h2.entity.Users;
import com.vipicu.demo.cloud.db.h2.mapper.UsersMapper;
import com.vipicu.demo.cloud.db.h2.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
}
