package com.springreactive.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("payment")
public interface ConsumerService {

    @GetMapping("/officers/plain_str")
    String getPlainStr();
}
