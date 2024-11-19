package br.edu.famper.sistemaestacionamento.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VagaDto {
    @Schema(description = "data_criacao",
            example = "21/06/2001",
            title = "data_criacao")
    private Date data_criacao;

    @Schema(description = "data_atualizacao",
            example = "21/06/2001",
            title = "data_atualizacao")
    private Date data_atualizacao;

    @Schema(description = "localizacao",
            example = "mercado",
            title = "localizacao",
            maxLength = 100)
    private String localizacao;

    @Schema(description = "tipo",
            example = "preferencial",
            title = "tipo",
            maxLength = 20)
    private String tipo;
}
