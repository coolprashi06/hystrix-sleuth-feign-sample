package com.prashast.servicea.web;

import com.prashast.servicea.service.TextDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceA")
public class ServiceAResource {

    private static final Logger logger = LoggerFactory.getLogger(ServiceAResource.class);

    @Autowired
    private TextDataService textDataService;

    @RequestMapping(value = "/textData", method = RequestMethod.GET)
    public ResponseEntity<String> textData() throws Exception{
        logger.info("Inside textData method ");
        //intentional wait
        Thread.sleep(10000);
        String text = textDataService.getTextData();
        return new ResponseEntity<>(text, HttpStatus.OK);
    }

    @RequestMapping(value = "/textDataFromServiceB", method = RequestMethod.GET)
    public ResponseEntity<String> textDataFromServiceB(){
        logger.info("Inside textDataFromServiceB method ");
        String text = textDataService.getTextDataFromServiceB();
        return new ResponseEntity<>(text, HttpStatus.OK);
    }
}
