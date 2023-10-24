package com.vipicu.demo.cloud.service.resource03.app.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysResourceApi;
import com.vipicu.demo.cloud.service.resource03.app.mapper.SysResourceApiMapper;
import com.vipicu.demo.cloud.service.resource03.app.service.impl.SysResourceApiService;
@Service
public class SysResourceApiServiceImpl extends ServiceImpl<SysResourceApiMapper, SysResourceApi> implements SysResourceApiService{

}
