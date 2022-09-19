package com.vlady.ticketsservice.dao;


import com.vlady.ticketsservice.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepo extends JpaRepository<Ticket, Integer> {
}
