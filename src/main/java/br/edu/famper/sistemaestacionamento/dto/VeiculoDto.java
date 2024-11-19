package br.edu.famper.sistemaestacionamento.dto;


import br.edu.famper.sistemaestacionamento.model.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VeiculoDto {
    @Schema(description = "marca",
            example = "volkswagen",
            title = "marca",
            maxLength = 100)
    private String marca;

    @Schema(description = "modelo",
            example = "gol",
            title = "modelo",
            maxLength = 100)
    private String modelo;

    @Schema(description = "ano_fabricacao",
            example = "21/06/2001",
            title = "ano_fabricacao")
    private Date ano_fabricacao;

    @Schema(description = "cor",
            example = "azul",
            title = "cor",
            maxLength = 20)
    private String cor;

    @Schema(description = "placa",
            example = "abz-2j84",
            title = "placa",
            maxLength = 20)
    private String placa;

    @Schema(description = "proprietario",
            example = "juca",
            title = "propreietario",
            maxLength = 100)
    private Cliente proprietario;
}
