package br.edu.famper.sistemaestacionamento.controller;


import br.edu.famper.sistemaestacionamento.dto.TicketDto;
import br.edu.famper.sistemaestacionamento.exception.ResourceNotFoundException;
import br.edu.famper.sistemaestacionamento.model.Ticket;
import br.edu.famper.sistemaestacionamento.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Ticket",
        description = "Operation for ticket")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all ticket from DB",
            description = "Fetches all ticket from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<TicketDto> getAllTickets() {
        log.info("Buscando tods os tickets");
        return ticketService.getAllTickets();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one ticket from DB",
            description = "Fetches one ticket from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<TicketDto> getTicketById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando ticket por id: {}", id);
        return ResponseEntity.ok().body(ticketService.getTicketById(id));
    }

    @PostMapping
    @Operation(summary = "Save ticket",
            description = "Save a ticket in database"
    )
    public Ticket createTicket(@RequestBody Ticket ticketDto) throws ResourceNotFoundException {
        log.info("Cadastro ticket: {}", ticketDto);
        return ticketService.saveTicket(ticketDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update ticket",
            description = "Update a ticket in database"
    )
    public ResponseEntity<TicketDto> updateTicket(@PathVariable(name = "id") Long id, @RequestBody TicketDto ticketDto) throws ResourceNotFoundException {
        log.info("Atualizando ticket: {}", ticketDto);
        return ResponseEntity.ok(ticketService.editTicket(id, ticketDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove ticket",
            description = "Remove a ticket in database"
    )
    public Map<String, Boolean> deleteTicket(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando ticket: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", ticketService.deleteTicket(id));
        return response;
    }


}
