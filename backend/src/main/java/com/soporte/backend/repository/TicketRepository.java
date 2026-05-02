package com.soporte.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporte.backend.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}
