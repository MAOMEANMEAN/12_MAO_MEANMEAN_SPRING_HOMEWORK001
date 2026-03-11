package org.example.springhomework001.Controller;


import org.example.springhomework001.Enum.TicketStatus;
import org.example.springhomework001.Model.entity.Ticket;
import org.example.springhomework001.Model.request.TicketRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private final List<Ticket> TICKET_LIST = new ArrayList<>();
    private final AtomicLong ATOMIC_LONG = new AtomicLong(4L);

    public TicketController() {
        TICKET_LIST.add(new Ticket(1L, "Teb Thida", "2026-02-10", "New York", "Los Angeless", 250.0, true, TicketStatus.BOOKED, "A1"));
        TICKET_LIST.add(new Ticket(2L, "Mina Sii", "2026-08-15", "London", "The UK", 150.0, false, TicketStatus.CANCELED, "A2"));
        TICKET_LIST.add(new Ticket(3L, "Petros", "2026-10-20", "Rom", "Israel", 350.0, true, TicketStatus.COMPLETED, "A3"));
    }

    @GetMapping
    public List<Ticket> getAllTickket() {
        return TICKET_LIST;
    }

    @GetMapping("/{ticket-id}")
    public Ticket getTicketById(@PathVariable("ticket-id") Long ticketId) {
        for (Ticket ticket : TICKET_LIST) {
            if (ticket.getTicketId().equals(ticketId)) {
                return ticket;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public void updateTicketById(@PathVariable("id") Long ticketId, @RequestBody TicketRequest request) {
        for (Ticket ticket : TICKET_LIST) {
            if (ticket.getTicketId().equals(ticketId)) {
                ticket.setPassengerName(request.getPassengerName());
                ticket.setTravelDate(request.getTravelDate());
                ticket.setSourceStation(request.getSourceStation());
                ticket.setDestinationStation(request.getDestinationStation());
                ticket.setPrice(request.getPrice());
                ticket.setPaymentStatus(request.getPaymentStatus());
                ticket.setTicketStatus(request.getTicketStatus());
                ticket.setSeatNumber(request.getSeatNumber());
            }
        }
    }

    @PutMapping("/bulk")
    public void updateMultiTicket(@PathVariable("id") Long ticketId, @RequestBody TicketRequest request) {
        for (Ticket ticket : TICKET_LIST) {
            if (ticket.getTicketId().equals(ticketId)) {
                if (ticket.getPaymentStatus().equals(true));
            }
        }
    }

    @GetMapping("/search")
    public Ticket searchTicketByName(@RequestParam("search") String passengerName) {
        for (Ticket ticket : TICKET_LIST) {
            if (passengerName.equals(ticket.getPassengerName())) {
                return ticket;
            }
        }
        return null;
    }

    @GetMapping("/filter")
    public Ticket filterTicket(@RequestParam("filter") TicketStatus status, String travelDate){
        for (Ticket ticket : TICKET_LIST) {
            if (ticket.getTicketStatus().equals(status)) {
                if (ticket.getTravelDate().equals(travelDate)) {
                    return ticket;
                }
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTicketById(@PathVariable("id") Long ticketId) {
        TICKET_LIST.removeIf(ticket -> ticket.getTicketId().equals(ticketId));
    }

    @PostMapping
    public Ticket createTicket(@RequestBody TicketRequest request) {
        Ticket ticket = new Ticket(ATOMIC_LONG.getAndIncrement(), request.getPassengerName(), request.getTravelDate(), request.getSourceStation(), request.getDestinationStation(), request.getPrice(), request.getPaymentStatus(), request.getTicketStatus(), request.getSeatNumber());
        TICKET_LIST.add(ticket);
        return ticket;
    }

//    @PostMapping("/bulk")
//    public Ticket createMultiTicket(@RequestBody TicketRequest request) {
//        for (request.)
//    }
}
