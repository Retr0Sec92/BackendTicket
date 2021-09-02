package com.felece.felece_case.Repo.Ticket;

import com.felece.felece_case.Models.Ticket.Ticket;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TicketRepo extends ReactiveMongoRepository<Ticket, String> {
    @Query
    public Flux<Ticket> findByUserid(String id);
}
