package com.prashast.serviceb.service;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceAClientFallbackFactory implements FallbackFactory<ServiceAClient> {

    private static final Logger logger = LoggerFactory.getLogger(ServiceAClientFallbackFactory.class);

    @Override
    public ServiceAClient create(Throwable throwable) {
        return new ServiceAClientFallback(throwable);
    }

}

class ServiceAClientFallback implements ServiceAClient{

    private final Throwable cause;

    public ServiceAClientFallback(Throwable cause) {
        this.cause = cause;
    }

    private static final Logger logger = LoggerFactory.getLogger(ServiceAClientFallback.class);

    public String getTextDataFromServiceA(){
        logger.error("inside fallback method for getting text data from service A, Error", cause);
        return "fallback text data from service A";
    }
}
