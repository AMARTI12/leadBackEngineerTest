package com.dev.leadBackEngineerTest.service;


import com.dev.leadBackEngineerTest.domain.TicketStatus;
import com.dev.leadBackEngineerTest.dto.TicketDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TicketService {
    TicketDTO createTicket(TicketDTO ticketDTO);
    TicketDTO updateTicket(UUID id, TicketDTO ticketDTO);
    void deleteTicket(UUID id);
    TicketDTO getTicketById(UUID id);
    Page<TicketDTO> getTickets(Pageable pageable);
    Page<TicketDTO> filterTickets(TicketStatus status, UUID userId, Pageable pageable);
}
