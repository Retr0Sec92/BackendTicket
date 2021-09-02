package com.felece.felece_case.Repo.Destination;

import com.felece.felece_case.Models.Destination.Destination;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface DestinationRepo extends ReactiveMongoRepository<Destination, String> {
    @Query(value = "{ stations: { $all: [?0, ?1] } }")
    public Flux<Destination> findInStations(String departure, String arrival);
}
