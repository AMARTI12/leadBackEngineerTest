package com.dev.leadBackEngineerTest.service;

import com.dev.leadBackEngineerTest.domain.Ticket;
import com.dev.leadBackEngineerTest.domain.TicketStatus;
import com.dev.leadBackEngineerTest.domain.User;
import com.dev.leadBackEngineerTest.dto.TicketDTO;
import com.dev.leadBackEngineerTest.repository.TicketRepository;
import com.dev.leadBackEngineerTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        User user = userRepository.findById(ticketDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no existente con el id: " + ticketDTO.getUserId()));

        Ticket ticket = new Ticket();
        ticket.setDescription(ticketDTO.getDescription());
        ticket.setStatus(ticketDTO.getStatus());
        ticket.setUser(user);

        Ticket savedTicket = ticketRepository.save(ticket);

        return mapToDTO(savedTicket);
    }

    @Override
    public TicketDTO updateTicket(UUID id, TicketDTO ticketDTO) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        ticket.setDescription(ticketDTO.getDescription());
        ticket.setStatus(ticketDTO.getStatus());
        ticketRepository.save(ticket);
        ticketDTO.setId(ticket.getId());
        return ticketDTO;
    }

    @Override
    public void deleteTicket(UUID id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public TicketDTO getTicketById(UUID id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setDescription(ticket.getDescription());
        dto.setUserId(ticket.getUser().getId());
        dto.setStatus(ticket.getStatus());
        return dto;
    }

    @Override
    public Page<TicketDTO> getTickets(Pageable pageable) {
        return ticketRepository.findAll(pageable).map(ticket -> {
            TicketDTO dto = new TicketDTO();
            dto.setId(ticket.getId());
            dto.setDescription(ticket.getDescription());
            dto.setUserId(ticket.getUser().getId());
            dto.setStatus(ticket.getStatus());
            return dto;
        });
    }

    @Override
    public Page<TicketDTO> filterTickets(TicketStatus status, UUID userId, Pageable pageable) {
        Page<Ticket> tickets;

        if (status != null && userId != null) {
            tickets = ticketRepository.findByStatusAndUserId(status, userId, pageable);
        } else if (status != null) {
            tickets = ticketRepository.findByStatus(status, pageable);
        } else if (userId != null) {
            tickets = ticketRepository.findByUserId(userId, pageable);
        } else {
            tickets = ticketRepository.findAll(pageable);
        }

        return tickets.map(ticket -> {
            TicketDTO dto = new TicketDTO();
            dto.setId(ticket.getId());
            dto.setDescription(ticket.getDescription());
            dto.setUserId(ticket.getUser().getId());
            dto.setStatus(ticket.getStatus());
            return dto;
        });
    }

    //HELPERS

    private TicketDTO mapToDTO(Ticket ticket) {
        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setDescription(ticket.getDescription());
        dto.setUserId(ticket.getUser().getId());
        dto.setStatus(ticket.getStatus());
        return dto;
    }
}
