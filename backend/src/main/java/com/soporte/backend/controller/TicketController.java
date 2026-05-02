package com.soporte.backend.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soporte.backend.model.Ticket;
import com.soporte.backend.repository.TicketRepository;

@RestController
@RequestMapping("/tickets")
@CrossOrigin
public class TicketController {
    
    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping
    public List<Ticket> listar() {
        return ticketRepository.findAll();
    }

    @PostMapping
    public Ticket crear(@RequestBody Ticket ticket) {
        ticket.setFecha_creacion(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }
}
