package com.springreactive.payment.controller;

import com.springreactive.payment.entity.Officer;
import com.springreactive.payment.repository.OfficerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/officers")
public class OfficerController {
    private final OfficerRepository repository;

    public OfficerController(OfficerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Flux<Officer> getAllOfficers(){
        return repository.findAll();
    }

    @GetMapping(value = "/{lastname}")
    public Flux<Officer> getOfficer(@PathVariable("lastname") String lastname){
        return repository.findByLastname(lastname);
    }
    
    @GetMapping("/plain_str")
    public String getPlainStr(){
        return "Hello Peggy From Service 1";
    }
}
