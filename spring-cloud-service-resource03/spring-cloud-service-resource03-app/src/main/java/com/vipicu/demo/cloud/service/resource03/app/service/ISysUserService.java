package com.vipicu.demo.cloud.service.resource03.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysUser;
import com.vipicu.demo.cloud.service.resource03.api.entity.UserInfo;
import org.springframework.lang.NonNull;

public interface ISysUserService extends IService<SysUser>{

    UserInfo fetchUserInfo(@NonNull SysUser username);

}
