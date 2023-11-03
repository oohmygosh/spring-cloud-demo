package com.vipicu.demo.cloud.service.resource03.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysResourceApi;

import java.util.List;

public interface ISysResourceApiService extends IService<SysResourceApi>{

    List<String> selectCodesByUserId(Long userId);

}
