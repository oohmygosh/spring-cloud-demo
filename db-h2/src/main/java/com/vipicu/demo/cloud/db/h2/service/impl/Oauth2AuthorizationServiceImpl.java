package com.vipicu.demo.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.db.entity.Oauth2Authorization;
import com.vipicu.demo.db.mapper.Oauth2AuthorizationMapper;
import com.vipicu.demo.db.service.Oauth2AuthorizationService;
import org.springframework.stereotype.Service;
@Service
public class Oauth2AuthorizationServiceImpl extends ServiceImpl<Oauth2AuthorizationMapper, Oauth2Authorization> implements Oauth2AuthorizationService{

}
