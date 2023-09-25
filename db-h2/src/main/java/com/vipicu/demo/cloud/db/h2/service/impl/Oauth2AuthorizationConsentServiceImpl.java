package com.vipicu.demo.cloud.db.h2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.db.h2.entity.Oauth2AuthorizationConsent;
import com.vipicu.demo.cloud.db.h2.mapper.Oauth2AuthorizationConsentMapper;
import com.vipicu.demo.cloud.db.h2.service.Oauth2AuthorizationConsentService;
import org.springframework.stereotype.Service;
@Service
public class Oauth2AuthorizationConsentServiceImpl extends ServiceImpl<Oauth2AuthorizationConsentMapper, Oauth2AuthorizationConsent> implements Oauth2AuthorizationConsentService{

}
