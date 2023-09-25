package com.vipicu.demo.cloud.db.h2.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Collections;

/**
 * 数据源自动配置
 *
 * @author Lee
 * @since 1.0.0
 */
@Configuration
@ComponentScans(value = {
        @ComponentScan("com.vipicu.demo.*")
})
@MapperScan("com.vipicu.demo.cloud.db.*.mapper")
@Conditional(DataSourceAutoConfiguration.DbIsMissing.class)
public class DataSourceAutoConfiguration {
    /**
     * H2数据源
     *
     * @return {@link DataSource}
     */
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:test");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

    /**
     * 数据源脚本数据库初始化器
     * 初始化数据库表 & 数据
     *
     * @param dataSource 数据源
     * @return {@link SqlDataSourceScriptDatabaseInitializer}
     */
    @Bean
    SqlDataSourceScriptDatabaseInitializer dataSourceScriptDatabaseInitializer(DataSource dataSource) {
        SqlInitializationProperties sqlInitializationProperties = new SqlInitializationProperties();
        sqlInitializationProperties.setSchemaLocations(Collections.singletonList("classpath:db/schema-h2.sql"));
        sqlInitializationProperties.setDataLocations(Collections.singletonList("classpath:db/data-h2.sql"));
        sqlInitializationProperties.setMode(DatabaseInitializationMode.ALWAYS);
        return new SqlDataSourceScriptDatabaseInitializer(
                dataSource, sqlInitializationProperties);
    }

    /**
     * 匹配条件
     * 如果没有配置数据源则使用内置H2数据源
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
            return ConditionOutcome.match(message.didNotFind("initialization H2.").atAll());
        }
    }

}
