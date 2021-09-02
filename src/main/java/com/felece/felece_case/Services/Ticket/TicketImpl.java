package com.felece.felece_case.Services.Ticket;

import com.felece.felece_case.Models.Bus.Bus;
import com.felece.felece_case.Models.Side.TicketStatus;
import com.felece.felece_case.Models.Ticket.Ticket;
import com.felece.felece_case.Repo.Bus.BusRepo;
import com.felece.felece_case.Repo.Ticket.TicketRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketImpl implements TicketService{
    private final TicketRepo ticketRepo;
    private final BusRepo busRepo;

    @Override
    public Flux<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    @Override
    public Flux<Ticket> getTicketByUserId(String id) {
        return ticketRepo.findByUserid(id);
    }

    @Override
    public Flux<Ticket> buyTicket(Ticket ticket) {
        Ticket newTicket = Ticket.builder()
                .busid(ticket.getBusid())
                .name(ticket.getName())
                .id(UUID.randomUUID().toString())
                .ticketStatus(TicketStatus.SOLD)
                .count(ticket.getCount())
                .userid(ticket.getUserid()).build();
        Bus bus = busRepo.findById(newTicket.getBusid()).block();
        bus.setUsedSpace(bus.getUsedSpace() + newTicket.getCount());
        busRepo.save(bus).block();
        ticketRepo.save(newTicket).block();
        return ticketRepo.findByUserid(ticket.getUserid());
    }

    @Override
    public Flux<Ticket> cancelTicket(String id) {
        Ticket ticket = ticketRepo.findById(id).block();
        if(ticket.getTicketStatus() == TicketStatus.CANCELED) {
            return ticketRepo.findByUserid(ticket.getUserid());
        }
        else if(ticket.getTicketStatus() == TicketStatus.POSTPONED) {
            ticket.setTicketStatus(TicketStatus.CANCELED);
            ticketRepo.save(ticket).block();
            return ticketRepo.findByUserid(ticket.getUserid());
        }
        else if(ticket.getTicketStatus() == TicketStatus.SOLD) {
            ticket.setTicketStatus(TicketStatus.CANCELED);
            ticketRepo.save(ticket).block();

            Bus bus = busRepo.findById(ticket.getBusid()).block();
            bus.setUsedSpace(bus.getUsedSpace() - ticket.getCount());
            busRepo.save(bus).block();
            return ticketRepo.findByUserid(ticket.getUserid());
        }
        else {
            return ticketRepo.findByUserid(ticket.getUserid());
        }
    }

    @Override
    public Flux<Ticket> postponeTicket(String id) {
        Ticket ticket = ticketRepo.findById(id).block();
        if(ticket.getTicketStatus() == TicketStatus.POSTPONED) {
            return ticketRepo.findByUserid(ticket.getUserid());
        }
        else if(ticket.getTicketStatus() == TicketStatus.CANCELED) {
            ticket.setTicketStatus(TicketStatus.POSTPONED);
            ticketRepo.save(ticket).block();
            return ticketRepo.findByUserid(ticket.getUserid());
        }
        else if(ticket.getTicketStatus() == TicketStatus.SOLD) {
            ticket.setTicketStatus(TicketStatus.POSTPONED);
            ticketRepo.save(ticket).block();

            Bus bus = busRepo.findById(ticket.getBusid()).block();
            bus.setUsedSpace(bus.getUsedSpace() - ticket.getCount());
            busRepo.save(bus).block();
            return ticketRepo.findByUserid(ticket.getUserid());
        }
        else {
            return ticketRepo.findByUserid(ticket.getUserid());
        }
    }
}
