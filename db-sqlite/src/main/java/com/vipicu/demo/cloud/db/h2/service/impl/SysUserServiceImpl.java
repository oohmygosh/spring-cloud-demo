package com.vipicu.demo.cloud.db.h2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.db.h2.entity.SysUser;
import com.vipicu.demo.cloud.db.h2.mapper.SysUserMapper;
import com.vipicu.demo.cloud.db.h2.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * 系统用户 服务实现类
 *
 * @author oohmygosh
 * @since 2021-11-03
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
