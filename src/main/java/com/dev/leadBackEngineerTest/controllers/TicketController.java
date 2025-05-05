package com.dev.leadBackEngineerTest.controllers;

import com.dev.leadBackEngineerTest.domain.TicketStatus;
import com.dev.leadBackEngineerTest.dto.TicketDTO;
import com.dev.leadBackEngineerTest.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public TicketDTO createTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.createTicket(ticketDTO);
    }

    @PutMapping("/{id}")
    public TicketDTO updateTicket(@PathVariable UUID id, @RequestBody TicketDTO ticketDTO) {
        return ticketService.updateTicket(id, ticketDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable UUID id) {
        ticketService.deleteTicket(id);
    }

    @GetMapping("/{id}")
    public TicketDTO getTicketById(@PathVariable UUID id) {
        return ticketService.getTicketById(id);
    }

    @GetMapping
    public Page<TicketDTO> getTickets(
            @RequestParam(required = false) TicketStatus status,
            @RequestParam(required = false) UUID userId,
            Pageable pageable) {
        return ticketService.filterTickets(status, userId, pageable);
    }
}
