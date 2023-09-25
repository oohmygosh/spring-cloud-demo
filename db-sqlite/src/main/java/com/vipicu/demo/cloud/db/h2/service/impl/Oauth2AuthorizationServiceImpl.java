package com.vipicu.demo.cloud.db.h2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.db.h2.entity.Oauth2Authorization;
import com.vipicu.demo.cloud.db.h2.mapper.Oauth2AuthorizationMapper;
import com.vipicu.demo.cloud.db.h2.service.Oauth2AuthorizationService;
import org.springframework.stereotype.Service;
@Service
public class Oauth2AuthorizationServiceImpl extends ServiceImpl<Oauth2AuthorizationMapper, Oauth2Authorization> implements Oauth2AuthorizationService{

}
