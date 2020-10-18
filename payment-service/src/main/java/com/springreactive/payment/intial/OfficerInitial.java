package com.springreactive.payment.intial;

import com.springreactive.payment.entity.Officer;
import com.springreactive.payment.entity.Rank;
import com.springreactive.payment.repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class OfficerInitial implements ApplicationRunner {
    private OfficerRepository repository;
    @Autowired
    public OfficerInitial(OfficerRepository repository){
        this.repository = repository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.deleteAll()
                .thenMany(Flux.just( new Officer(Rank.China, "John", "King"),
                        new Officer(Rank.China, "Smart", "King"),
                        new Officer(Rank.English, "Bruce", "Green"),
                        new Officer(Rank.Japan, "Kaka", "Joe"),
                        new Officer(Rank.USA, "Low", "Trump")))
                .flatMap(repository::save)
                .then()
                .doOnEach(System.out::println)
                .block();
    }
}
