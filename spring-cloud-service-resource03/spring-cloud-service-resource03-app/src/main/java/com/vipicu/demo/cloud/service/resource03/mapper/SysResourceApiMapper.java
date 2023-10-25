package com.vipicu.demo.cloud.service.resource03.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysResourceApi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysResourceApiMapper extends BaseMapper<SysResourceApi> {
    /**
     * 获取用户的权限编码
     *
     * @param userId 用户id
     * @return {@link List}<{@link String}>
     */
    @Select("SELECT DISTINCT a.code FROM sys_resource_api a JOIN sys_role_resource s ON a.resource_id=s.resource_id JOIN sys_user_role r ON s.role_id=r.role_id WHERE r.user_id=#{userId}")
    List<String> selectCodesByUserId(Long userId);
}
