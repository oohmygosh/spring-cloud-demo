package com.vipicu.demo.cloud.service.resource03.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysResourceApi;
import com.vipicu.demo.cloud.service.resource03.mapper.SysResourceApiMapper;
import com.vipicu.demo.cloud.service.resource03.service.ISysResourceApiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISysResourceApiServiceImpl extends ServiceImpl<SysResourceApiMapper, SysResourceApi> implements ISysResourceApiService {

    @Override
    public List<String> selectCodesByUserId(Long userId) {
        return getBaseMapper().selectCodesByUserId(userId);
    }
}
