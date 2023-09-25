package com.vipicu.demo.cloud.db.h2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vipicu.demo.cloud.db.h2.entity.Oauth2AuthorizationConsent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Oauth2AuthorizationConsentMapper extends BaseMapper<Oauth2AuthorizationConsent> {
}