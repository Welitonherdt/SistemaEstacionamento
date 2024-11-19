package br.edu.famper.sistemaestacionamento.controller;


import br.edu.famper.sistemaestacionamento.dto.VeiculoDto;
import br.edu.famper.sistemaestacionamento.exception.ResourceNotFoundException;
import br.edu.famper.sistemaestacionamento.model.Veiculo;
import br.edu.famper.sistemaestacionamento.service.VeiculoService;
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
@RequestMapping("/api/veiculo")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Veiculo",
        description = "Operation for vehicles")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all vehicles from DB",
            description = "Fetches all vehicles from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<VeiculoDto> getAllVeiculos() {
        log.info("Buscando todos os veiculos");
        return veiculoService.getAllVeiculos();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one vehicle from DB",
            description = "Fetches one vehicle from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<VeiculoDto> getVeiculoById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando veiculo por id: {}", id);
        return ResponseEntity.ok().body(veiculoService.getVeiculoById(id));
    }

    @PostMapping
    @Operation(summary = "Save vehicle",
            description = "Save a vehicle in database"
    )
    public Veiculo createVeiculo(@RequestBody Veiculo veiculoDto) throws ResourceNotFoundException {
        log.info("Cadastro veiculo: {}", veiculoDto);
        return veiculoService.saveVeiculo(veiculoDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update vehicle",
            description = "Update a vehicles in database"
    )
    public ResponseEntity<VeiculoDto> updateVeiculo(@PathVariable(name = "id") Long id, @RequestBody VeiculoDto veiculoDto) throws ResourceNotFoundException {
        log.info("Atualizando veiculo: {}", veiculoDto);
        return ResponseEntity.ok(veiculoService.editVeiculo(id, veiculoDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove vehicle",
            description = "Remove a vehicle in database"
    )
    public Map<String, Boolean> deleteVeiculo(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando veiculo: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", veiculoService.deleteVeiculo(id));
        return response;
    }


}