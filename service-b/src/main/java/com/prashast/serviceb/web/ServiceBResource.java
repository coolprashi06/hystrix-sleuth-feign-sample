package com.prashast.serviceb.web;

import com.prashast.serviceb.service.TextDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceB")
public class ServiceBResource {

    private static final Logger logger = LoggerFactory.getLogger(ServiceBResource.class);

    @Autowired
    private TextDataService textDataService;

    @RequestMapping(value = "/textData", method = RequestMethod.GET)
    public ResponseEntity<String> textData() throws Exception{
        logger.info("Inside textData method");
        //intentional wait
        Thread.sleep(12000);
        String text = textDataService.getTextData();
        return new ResponseEntity<>(text, HttpStatus.OK);
    }

    @RequestMapping(value = "/textDataFromServiceA", method = RequestMethod.GET)
    public ResponseEntity<String> textDataFromServiceA(){
        logger.info("Inside textDataFromServiceA method ");
        String text = textDataService.getTextDataFromServiceA();
        return new ResponseEntity<>(text, HttpStatus.OK);
    }
}
