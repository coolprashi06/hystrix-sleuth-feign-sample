package com.prashast.serviceb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${serviceA.host}",
        name = "ServiceA",
        fallbackFactory = ServiceAClientFallbackFactory.class)
public interface ServiceAClient {

    @RequestMapping(method = RequestMethod.GET, value = "${serviceA.textDataResourcePath}")
    String getTextDataFromServiceA();
}
