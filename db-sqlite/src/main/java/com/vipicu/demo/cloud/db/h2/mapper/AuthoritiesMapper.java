package com.vipicu.demo.cloud.db.h2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vipicu.demo.cloud.db.h2.entity.Authorities;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthoritiesMapper extends BaseMapper<Authorities> {
}