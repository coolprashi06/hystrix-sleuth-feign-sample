package com.prashast.serviceb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextDataService {

    private static final Logger logger = LoggerFactory.getLogger(TextDataService.class);

    @Autowired
    private ServiceAClient serviceAClient;

    public String getTextData(){
        logger.info("returning \"text data from service B \"");
        return "text data from service B";
    }

    public String getTextDataFromServiceA(){
        String text = serviceAClient.getTextDataFromServiceA();
        logger.info("returning {}", text);
        return text;
    }
}
