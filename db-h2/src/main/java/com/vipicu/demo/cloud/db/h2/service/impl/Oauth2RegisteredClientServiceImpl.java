package com.vipicu.demo.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.db.entity.Oauth2RegisteredClient;
import com.vipicu.demo.db.mapper.Oauth2RegisteredClientMapper;
import com.vipicu.demo.db.service.Oauth2RegisteredClientService;
import org.springframework.stereotype.Service;
@Service
public class Oauth2RegisteredClientServiceImpl extends ServiceImpl<Oauth2RegisteredClientMapper, Oauth2RegisteredClient> implements Oauth2RegisteredClientService{

}
