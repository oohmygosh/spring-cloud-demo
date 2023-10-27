package com.vipicu.demo.cloud.core.config;

import com.vipicu.demo.cloud.core.annotations.ICacheable;
import jakarta.annotation.Nullable;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class SpringCacheManagerConfiguration implements ApplicationContextAware {

    private Map<String, RedisCacheConfiguration> redisCacheConfigurations;

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration defaultConfiguration = getRedisCacheConfigurationWithTtl(0);
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
                .builder(connectionFactory)
                .cacheDefaults(defaultConfiguration);
        if (!CollectionUtils.isEmpty(redisCacheConfigurations)) {
            Map<String, RedisCacheConfiguration> cacheConfigurations = new LinkedHashMap<>(redisCacheConfigurations);
            builder.withInitialCacheConfigurations(cacheConfigurations);
        }
        return builder.build();
    }

    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(long ttl) {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .disableCachingNullValues()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
                .entryTtl(Duration.ofSeconds(ttl));
    }

    @Override
    @SneakyThrows
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        assert applicationContext != null;
        ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        redisCacheConfigurations = new HashMap<>();
        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(beanName);
            Class<?> beanClass = beanDefinition.resolveBeanClass(ClassUtils.getDefaultClassLoader());
            if (beanClass != null) {
                ReflectionUtils.doWithMethods(beanClass, m -> {
                            ICacheable cacheable = AnnotatedElementUtils.findMergedAnnotation(m, ICacheable.class);
                            if (!ObjectUtils.isEmpty(cacheable))
                                Arrays.stream(cacheable.value()).forEach(item -> redisCacheConfigurations.put(item, getRedisCacheConfigurationWithTtl(cacheable.expiredTimeSecond())));
                        }
                );
            }
        }
    }
}
