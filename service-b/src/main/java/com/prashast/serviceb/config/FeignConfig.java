package com.prashast.serviceb.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import feign.Feign;
import feign.Target;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class FeignConfig {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "feign.hystrix.enabled")
    public Feign.Builder feignHystrixBuilder() {

        SetterFactory setterFactory = new SetterFactory() {
            @Override
            public HystrixCommand.Setter create(Target<?> target, Method method) {
                String groupKey = target.name();
                String commandKey = /* Feign.configKey(target.type(), method); */target.name();
                return HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
                        .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey));
            }
        };
        return HystrixFeign.builder().setterFactory(setterFactory);
    }
}

