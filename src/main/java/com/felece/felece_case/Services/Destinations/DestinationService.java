package com.felece.felece_case.Services.Destinations;

import com.felece.felece_case.Models.Destination.Destination;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DestinationService {
    Flux<Destination> saveDestination(Destination destination);
    Flux<Destination> getDestinations();
    Flux<Destination> deleteDestination(String id);
    Flux<Destination> updateDestination(String id,Destination destination);
    Mono<Destination> getDestinationById(String id);
}
