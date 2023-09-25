package com.vipicu.demo.cloud.db.h2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vipicu.demo.cloud.db.h2.entity.Users;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}
