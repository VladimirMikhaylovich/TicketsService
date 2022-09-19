package com.vlady.ticketsservice.web;

import com.vlady.ticketsservice.models.Ticket;
import com.vlady.ticketsservice.services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TicketsController {
    @Autowired
    private TicketsService ticketsService;


    @GetMapping("/tickets")
    public List<Ticket> showAllTickets(){
        List<Ticket> tickets = ticketsService.showTickets();
        return tickets;
    }
    @GetMapping("/tickets/{id}")
    public Ticket showTheTicket(@PathVariable int id){
        return ticketsService.getTicket(id);
    }
    @PutMapping("/tickets")
    public Ticket updateTicket(@RequestBody Ticket ticket){
        return ticketsService.updateTicket(ticket);
    }
    @PutMapping("/tickets/{id}")
    public Ticket setDeleted(@PathVariable int id){
        Ticket ticket = ticketsService.getTicket(id);
        ticket.setDeleted(true);
        return ticket;
    }

}
