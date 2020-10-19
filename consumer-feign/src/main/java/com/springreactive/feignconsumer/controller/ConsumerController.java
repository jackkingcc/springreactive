package com.springreactive.feignconsumer.controller;

import com.springreactive.feignconsumer.service.ConsumerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consumer/plain_str")
    public String getPlainStr(){
        log.info("Starting get plain str");
        return consumerService.getPlainStr();
    }
}
