package com.vipicu.demo.cloud.gateway.config;

import com.vipicu.demo.cloud.gateway.filter.RequestGlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关配置
 *
 * @author Lee
 * @since 1.0.0
 */
@Configuration
public class GatewayConfiguration {

    @Bean
    public RequestGlobalFilter requestGlobalFilter(){
        return new RequestGlobalFilter();
    }

}
