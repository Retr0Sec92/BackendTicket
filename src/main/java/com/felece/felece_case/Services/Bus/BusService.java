package com.felece.felece_case.Services.Bus;

import com.felece.felece_case.Models.Bus.Bus;
import com.felece.felece_case.Models.Search.BusSearch;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BusService {
    Flux<Bus> saveBus(Bus bus);
    Flux<Bus> getAllBuses();
    Flux<Bus> deleteBus(String id);
    Flux<Bus> updateBus(String id, Bus bus);
    Flux<Bus> getBusSearch(BusSearch busSearch);
    Mono<Bus> getBusById(String id);
}
