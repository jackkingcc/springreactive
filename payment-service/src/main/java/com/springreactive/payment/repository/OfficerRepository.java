package com.springreactive.payment.repository;

import com.springreactive.payment.entity.Officer;
import com.springreactive.payment.entity.Rank;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface OfficerRepository extends ReactiveMongoRepository<Officer, String> {
    Flux<Officer> findByRank(Rank rank);
    Flux<Officer> findByLastname(String lastname);
}
