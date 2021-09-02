package com.felece.felece_case.Repo.Bus;

import com.felece.felece_case.Models.Bus.Bus;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BusRepo extends ReactiveMongoRepository<Bus, String> {
    @Query()
    public Flux<Bus> findByDestinationid(String destinationid);
}
