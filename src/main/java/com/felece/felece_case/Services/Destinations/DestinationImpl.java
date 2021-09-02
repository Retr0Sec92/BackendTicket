package com.felece.felece_case.Services.Destinations;

import com.felece.felece_case.Models.Destination.Destination;
import com.felece.felece_case.Repo.Destination.DestinationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DestinationImpl implements DestinationService{
    private final DestinationRepo destinationRepo;

    @Override
    public Flux<Destination> saveDestination(Destination destination) {
        Destination newDestination = Destination.builder()
                .id(UUID.randomUUID().toString())
                .start(destination.getStart())
                .finish(destination.getFinish())
                .stations(destination.getStations())
                .build();
        destinationRepo.save(newDestination).block();
        return destinationRepo.findAll();
    }

    @Override
    public Flux<Destination> getDestinations() {
        return destinationRepo.findAll();
    }

    @Override
    public Mono<Destination> getDestinationById(String id) {
        return destinationRepo.findById(id);
    }

    @Override
    public Flux<Destination> deleteDestination(String id) {
        destinationRepo.deleteById(id).block();
        return destinationRepo.findAll();
    }

    @Override
    public Flux<Destination> updateDestination(String id, Destination destination) {
        Destination currentDestination = destinationRepo.findById(id).block();
        currentDestination.setStart(destination.getStart());
        currentDestination.setFinish(destination.getFinish());
        currentDestination.setStations(destination.getStations());
        destinationRepo.save(currentDestination).block();
        return destinationRepo.findAll();
    }
}
