package com.vipicu.demo.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vipicu.demo.db.entity.Oauth2Authorization;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Oauth2AuthorizationMapper extends BaseMapper<Oauth2Authorization> {
}