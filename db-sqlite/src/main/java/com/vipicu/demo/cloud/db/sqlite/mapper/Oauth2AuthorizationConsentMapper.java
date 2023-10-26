package com.vipicu.demo.cloud.db.sqlite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vipicu.demo.cloud.db.sqlite.entity.Oauth2AuthorizationConsent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Oauth2AuthorizationConsentMapper extends BaseMapper<Oauth2AuthorizationConsent> {
}