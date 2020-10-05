package com.prashast.servicea.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextDataService {

    private static final Logger logger = LoggerFactory.getLogger(TextDataService.class);

    @Autowired
    private ServiceBClient serviceBClient;

    public String getTextData(){
        logger.info("returning \"text data from service A \"");
        return "text data from service A";
    }

    @HystrixCommand(commandKey = "getTextDataFromServiceB", fallbackMethod = "fallBackMethodForTextDataFromServiceB", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
    })
    public String getTextDataFromServiceB(){
        String text = serviceBClient.getTextDataFromServiceB();
        logger.info("returning {}", text);
        return text;
    }

    public String fallBackMethodForTextDataFromServiceB(){
        logger.info("inside fallback method for getting text data from service B");
        return "fallback text data from service B";
    }
}
