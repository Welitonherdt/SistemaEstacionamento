package br.edu.famper.sistemaestacionamento.controller;


import br.edu.famper.sistemaestacionamento.dto.VagaDto;
import br.edu.famper.sistemaestacionamento.exception.ResourceNotFoundException;
import br.edu.famper.sistemaestacionamento.model.Vaga;
import br.edu.famper.sistemaestacionamento.service.VagaService;
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
@RequestMapping("/api/vaga")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Vaga",
        description = "Operation for vaga")
public class VagaController {

    private final VagaService vagaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all vaga from DB",
            description = "Fetches all vaga from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<VagaDto> getAllVagas() {
        log.info("Buscando todas as vagas");
        return vagaService.getAllVagas();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one vaga from DB",
            description = "Fetches one vaga from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<VagaDto> getVagaById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando vaga por id: {}", id);
        return ResponseEntity.ok().body(vagaService.getVagaById(id));
    }

    @PostMapping
    @Operation(summary = "Save vaga",
            description = "Save a vaga in database"
    )
    public Vaga createVaga(@RequestBody Vaga vaga) throws ResourceNotFoundException {
        log.info("Cadastro vaga: {}", vaga);
        return vagaService.saveVaga(vaga);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update vaga",
            description = "Update a vaga in database"
    )
    public ResponseEntity<VagaDto> updateVaga(@PathVariable(name = "id") Long id, @RequestBody VagaDto vagaDto) throws ResourceNotFoundException {
        log.info("Atualizando vaga: {}", vagaDto);
        return ResponseEntity.ok(vagaService.editVaga(id, vagaDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove vaga",
            description = "Remove a vaga in database"
    )
    public Map<String, Boolean> deleteVaga(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando vaga: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", vagaService.deleteVaga(id));
        return response;
    }


}
