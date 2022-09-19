package com.vlady.ticketsservice.services;

import com.vlady.ticketsservice.models.Ticket;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface TicketsService {
     List<Ticket> showTickets();

    Ticket getTicket(int id);

    Ticket updateTicket(Ticket ticket);

     Ticket setAsDeleted(int id);
}
