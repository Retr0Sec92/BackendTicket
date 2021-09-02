package com.felece.felece_case.Services.Bus;

import com.felece.felece_case.Models.Bus.Bus;
import com.felece.felece_case.Models.Search.BusSearch;
import com.felece.felece_case.Repo.Bus.BusRepo;
import com.felece.felece_case.Repo.Destination.DestinationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BusImpl implements BusService{
    private final BusRepo busRepo;
    private final DestinationRepo destinationRepo;

    @Override
    public Flux<Bus> saveBus(Bus bus) {
        Bus newBus = Bus.builder()
                .id(UUID.randomUUID().toString())
                .arrival(bus.getArrival())
                .departure(bus.getDeparture())
                .usedSpace(0)
                .totalSpace(bus.getTotalSpace())
                .destinationid(bus.getDestinationid()).build();
        busRepo.save(newBus).block();
        return busRepo.findAll();
    }

    @Override
    public Mono<Bus> getBusById(String id) {
        return busRepo.findById(id);
    }

    @Override
    public Flux<Bus> getBusSearch(BusSearch busSearch) {
        return destinationRepo.findInStations(busSearch.getDeparture(), busSearch.getArrival()).flatMap(destination ->
            busRepo.findByDestinationid(destination.getId())
        );
    }

    @Override
    public Flux<Bus> getAllBuses() {
        return busRepo.findAll();
    }

    @Override
    public Flux<Bus> deleteBus(String id) {
        busRepo.deleteById(id).block();
        return busRepo.findAll();
    }

    @Override
    public Flux<Bus> updateBus(String id, Bus bus) {
        Bus currentBus = busRepo.findById(id).block();
        currentBus.setArrival(bus.getArrival());
        currentBus.setDeparture(bus.getDeparture());
        currentBus.setDestinationid(bus.getDestinationid());
        currentBus.setTotalSpace(bus.getTotalSpace());
        busRepo.save(currentBus).block();
        return busRepo.findAll();
    }
}
