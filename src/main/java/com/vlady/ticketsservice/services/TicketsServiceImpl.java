package com.vlady.ticketsservice.services;


import com.vlady.ticketsservice.dao.TicketsRepo;
import com.vlady.ticketsservice.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketsServiceImpl implements TicketsService {

    @Autowired
    private TicketsRepo ticketsRepo;

    @Override
    public List<Ticket> showTickets() {
        return ticketsRepo.findAll();
    }

    @Override
    public Ticket getTicket(int id) {
        Ticket ticket =null;
        Optional<Ticket> optionalTicket = ticketsRepo.findById(id);
        if(optionalTicket.isPresent())
            ticket = optionalTicket.get();
        return ticket;
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketsRepo.save(ticket);
    }

    @Override
    public Ticket setAsDeleted(int id) {
        Ticket ticket = null;
        Optional<Ticket> ticketOption = ticketsRepo.findById(id);
        if(ticketOption.isPresent())
            ticket = ticketOption.get();
        return ticket;
    }
}
