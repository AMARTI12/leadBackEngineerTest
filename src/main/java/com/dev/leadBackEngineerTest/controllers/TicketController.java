package com.dev.leadBackEngineerTest.controllers;

import com.dev.leadBackEngineerTest.domain.TicketStatus;
import com.dev.leadBackEngineerTest.dto.TicketDTO;
import com.dev.leadBackEngineerTest.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tickets")
@Tag(name = "Tickets", description = "Operaciones relacionadas con tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Operation(summary = "Crear un nuevo ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ticket creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public TicketDTO createTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.createTicket(ticketDTO);
    }

    @Operation(summary = "Actualizar un ticket existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Ticket no encontrado")
    })
    @PutMapping("/{id}")
    public TicketDTO updateTicket(@PathVariable UUID id, @RequestBody TicketDTO ticketDTO) {
        return ticketService.updateTicket(id, ticketDTO);
    }

    @Operation(summary = "Eliminar un ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Ticket eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Ticket no encontrado")
    })
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable UUID id) {
        ticketService.deleteTicket(id);
    }

    @Operation(summary = "Obtener un ticket por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket encontrado"),
            @ApiResponse(responseCode = "404", description = "Ticket no encontrado")
    })
    @GetMapping("/{id}")
    public TicketDTO getTicketById(@PathVariable UUID id) {
        return ticketService.getTicketById(id);
    }

    @Operation(summary = "Listar tickets con filtros opcionales")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de tickets obtenida exitosamente")
    })
    @GetMapping
    public Page<TicketDTO> getTickets(
            @Parameter(description = "Filtrar por estado") @RequestParam(required = false) TicketStatus status,
            @Parameter(description = "Filtrar por ID de usuario") @RequestParam(required = false) UUID userId,
            Pageable pageable) {
        return ticketService.filterTickets(status, userId, pageable);
    }
}
