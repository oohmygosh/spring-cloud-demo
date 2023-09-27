package com.vipicu.demo.cloud.db.h2.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * 数据源自动配置
 *
 * @author Lee
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.vipicu.demo.*")
@MapperScan("com.vipicu.demo.cloud.db.*.mapper")
@Conditional(DefaultDataSourceAutoConfiguration.DbIsMissing.class)
public class DefaultDataSourceAutoConfiguration {

    /**
     * H2数据源
     *
     * @return {@link DataSource}
     */
    @Bean
    public DataSource dataSource() {
        String url = System.getProperty("user.dir");
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        // 暂时用这种方式获取，放在resource目录下build后不知道为什么数据没了
        dataSourceBuilder.url("jdbc:sqlite:"+ url + "/sqlite.db");
        dataSourceBuilder.username("");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

    /**
     * 匹配条件
     * 如果没有配置数据源则使用内置数据源
     *
     * @author Lee
     * @since 1.0.0
     */
    static class DbIsMissing extends SpringBootCondition {
        @Override
        public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
            ConditionMessage.Builder message = ConditionMessage.forCondition("datasource");
            Environment environment = context.getEnvironment();
            String url = environment.getProperty("spring.datasource.url");
            String username = environment.getProperty("spring.datasource.username");
            String password = environment.getProperty("spring.datasource.password");
            String driverClass = environment.getProperty("spring.datasource.driver-class-name");

            if (StringUtils.hasText(url) && StringUtils.hasText(username) && StringUtils.hasText(password) && StringUtils.hasText(driverClass)) {
                return ConditionOutcome.noMatch(message.found(url).atAll());
            }
            return ConditionOutcome.match(message.didNotFind("initialization Sqlite.").atAll());
        }
    }

}
