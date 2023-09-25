package com.vipicu.demo.cloud.db.h2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.db.h2.entity.Oauth2RegisteredClient;
import com.vipicu.demo.cloud.db.h2.mapper.Oauth2RegisteredClientMapper;
import com.vipicu.demo.cloud.db.h2.service.Oauth2RegisteredClientService;
import org.springframework.stereotype.Service;
@Service
public class Oauth2RegisteredClientServiceImpl extends ServiceImpl<Oauth2RegisteredClientMapper, Oauth2RegisteredClient> implements Oauth2RegisteredClientService{

}
