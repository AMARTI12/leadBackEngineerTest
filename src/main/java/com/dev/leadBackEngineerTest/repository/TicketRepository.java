package com.dev.leadBackEngineerTest.repository;

import com.dev.leadBackEngineerTest.domain.Ticket;
import com.dev.leadBackEngineerTest.domain.TicketStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    Page<Ticket> findByStatus(TicketStatus status, Pageable pageable);
    Page<Ticket> findByUserId(UUID userId, Pageable pageable);
    Page<Ticket> findByStatusAndUserId(TicketStatus status, UUID userId, Pageable pageable);
}
