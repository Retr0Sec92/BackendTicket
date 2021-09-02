package com.felece.felece_case.Api.Ticket;

import com.felece.felece_case.Models.Role.Role;
import com.felece.felece_case.Models.Role.RoleResponse;
import com.felece.felece_case.Models.Side.UserRoleRequest;
import com.felece.felece_case.Models.Ticket.Ticket;
import com.felece.felece_case.Models.User.UserResponse;
import com.felece.felece_case.Services.Ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/ticket")
@RequiredArgsConstructor
public class TicketApi {
    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<Flux<Ticket>> getAllTickets() {
        return ResponseEntity.ok().body(ticketService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flux<Ticket>> getTicketByUserId(@PathVariable String id) {
        return ResponseEntity.ok().body(ticketService.getTicketByUserId(id));
    }

    @PostMapping
    public ResponseEntity<Flux<Ticket>> buyTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok().body(ticketService.buyTicket(ticket));
    }

    @GetMapping("/cancel/{id}")
    public ResponseEntity<Flux<Ticket>> cancelTicket(@PathVariable String id) {
        return ResponseEntity.ok().body(ticketService.cancelTicket(id));
    }

    @GetMapping("/postpone/{id}")
    public ResponseEntity<Flux<Ticket>> postponeTicket(@PathVariable String id) {
        return ResponseEntity.ok().body(ticketService.postponeTicket(id));
    }
}
