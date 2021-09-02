package com.felece.felece_case.Api.Destination;

import com.felece.felece_case.Models.Destination.Destination;
import com.felece.felece_case.Services.Destinations.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/destination")
@RequiredArgsConstructor
public class DestinationApi {
    private final DestinationService destinationService;

    @GetMapping
    public ResponseEntity<Flux<Destination>> getDestinations() {
        return ResponseEntity.ok().body(destinationService.getDestinations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Destination>> getDestinationById(@PathVariable String id) {
        return ResponseEntity.ok().body(destinationService.getDestinationById(id));
    }

    @PostMapping
    public ResponseEntity<Flux<Destination>> saveDestination(@RequestBody Destination destination) {
        return ResponseEntity.ok().body(destinationService.saveDestination(destination));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Flux<Destination>> deleteDestination(@PathVariable String id) {
        return ResponseEntity.ok().body(destinationService.deleteDestination(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flux<Destination>> updateDestination(@PathVariable String id ,@RequestBody Destination destination) {
        return ResponseEntity.ok().body(destinationService.updateDestination(id,destination));
    }
}
