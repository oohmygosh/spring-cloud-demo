package com.vipicu.demo.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vipicu.demo.db.entity.Oauth2RegisteredClient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Oauth2RegisteredClientMapper extends BaseMapper<Oauth2RegisteredClient> {
}