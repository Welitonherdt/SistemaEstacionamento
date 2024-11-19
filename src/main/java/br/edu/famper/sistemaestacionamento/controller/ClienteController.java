package br.edu.famper.sistemaestacionamento.controller;

import br.edu.famper.sistemaestacionamento.dto.ClienteDto;
import br.edu.famper.sistemaestacionamento.exception.ResourceNotFoundException;
import br.edu.famper.sistemaestacionamento.model.Cliente;
import br.edu.famper.sistemaestacionamento.service.ClienteService;
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
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Cliente",
        description = "Operation for cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all cliente from DB",
            description = "Fetches all cliente from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<ClienteDto> getAllClientes() {
        log.info("Buscando todos os clientes");
        return clienteService.getAllClientes();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one customer from DB",
            description = "Fetches one customer from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando cliente por id: {}", id);
        return ResponseEntity.ok().body(clienteService.getClienteById(id));
    }

    @PostMapping
    @Operation(summary = "Save customer",
            description = "Save a customer in database"
    )
    public Cliente createCliente(@RequestBody Cliente clienteDto) throws ResourceNotFoundException {
        log.info("Cadastro cliente: {}", clienteDto);
        return clienteService.saveCliente(clienteDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update customer",
            description = "Update a customer in database"
    )
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable(name = "id") Long id, @RequestBody ClienteDto clienteDto) throws ResourceNotFoundException {
        log.info("Atualizando cliente: {}", clienteDto);
        return ResponseEntity.ok(clienteService.editCliente(id, clienteDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove customer",
            description = "Remove a customer in database"
    )
    public Map<String, Boolean> deleteCliente(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando cliente: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", clienteService.deleteCliente(id));
        return response;
    }


}

