package com.springreactive.consumer.controller;

import com.springreactive.consumer.entity.Officer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/consumer")
@Log4j2
public class Consumer {
    WebClient webClient;
    public final static String BASE_URL = "http://PAYMENT";
    //public final static String BASE_URL = "http://localhost:8871";

    @Autowired
    private RestTemplate restTemplate;

    public Consumer(){
        this.webClient =WebClient.create(BASE_URL);
    }

    @GetMapping(value = "/officers")
    public Flux<Officer> getAllOfficers(){
        log.info("Starting run");
        return webClient.get()
                .uri("/officers").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Officer.class);
    }

    @GetMapping(value ="/officer/{lastname}")
    public Officer getOfficers(@PathVariable("lastname") String lastname){
        log.info("Starting getting officer");
        return restTemplate.getForObject(BASE_URL+"/officer/"+lastname,Officer.class);
    }

    @GetMapping
    public String getPlainStr(){
        log.info("Starting get plain str");
        return restTemplate.getForObject(BASE_URL+"/officers/plain_str",String.class);
    }
}
