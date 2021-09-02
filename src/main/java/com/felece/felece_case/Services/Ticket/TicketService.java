package com.felece.felece_case.Services.Ticket;

import com.felece.felece_case.Models.Ticket.Ticket;
import reactor.core.publisher.Flux;

public interface TicketService {
    Flux<Ticket> getAllTickets();
    Flux<Ticket> getTicketByUserId(String id);
    Flux<Ticket> buyTicket(Ticket ticket);
    Flux<Ticket> cancelTicket(String id);
    Flux<Ticket> postponeTicket(String id);
}
