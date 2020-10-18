package com.springreactive.consumer.initial;

import com.springreactive.consumer.entity.Officer;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@Log4j2
public class ConsumerInitial implements ApplicationRunner {
    WebClient webClient;
    public final static String BASE_URL = "http://localhost:8871";

    public ConsumerInitial(){
        this.webClient = WebClient.create(BASE_URL);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Starting run");
        webClient.get()
                .uri("/officers").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Officer.class)
                .doOnEach(log::info)
                .subscribe();
    }
}
