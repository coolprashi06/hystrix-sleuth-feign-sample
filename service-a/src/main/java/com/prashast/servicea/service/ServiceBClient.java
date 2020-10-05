package com.prashast.servicea.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${serviceB.host}", name = "ServiceB")
public interface ServiceBClient {

    @RequestMapping(method = RequestMethod.GET, value = "${serviceB.textDataResourcePath}")
    String getTextDataFromServiceB();
}
