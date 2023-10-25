package com.vipicu.demo.cloud.service.resource03.app.service.impl;

import com.vipicu.demo.cloud.service.resource03.app.service.ISysResourceApiService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysResourceApi;
import com.vipicu.demo.cloud.service.resource03.app.mapper.SysResourceApiMapper;

import java.util.List;

@Service
public class ISysResourceApiServiceImpl extends ServiceImpl<SysResourceApiMapper, SysResourceApi> implements ISysResourceApiService {

    @Override
    public List<String> selectCodesByUserId(Long userId) {
        return getBaseMapper().selectCodesByUserId(userId);
    }
}
