package com.vipicu.demo.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.db.entity.Users;
import com.vipicu.demo.db.mapper.UsersMapper;
import com.vipicu.demo.db.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
}
