package com.vipicu.demo.cloud.db.h2.mapper;

import com.vipicu.demo.cloud.db.h2.entity.SysResourceApi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 系统资源接口 Mapper 接口
 * </p>
 *
 * @author oohmygosh
 * @since 2022-02-26
 */
@Mapper
public interface SysResourceApiMapper extends CrudMapper<SysResourceApi> {

    /**
     * 获取用户的权限编码
     *
     * @param userId 用户id
     * @return {@link List}<{@link String}>
     */
    @Select("SELECT DISTINCT a.code FROM sys_resource_api a JOIN sys_role_resource s ON a.resource_id=s.resource_id JOIN sys_user_role r ON s.role_id=r.role_id WHERE r.user_id=#{userId}")
    List<String> selectCodesByUserId(Long userId);
}
