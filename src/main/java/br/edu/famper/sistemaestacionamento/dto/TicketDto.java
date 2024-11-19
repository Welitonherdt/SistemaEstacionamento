package br.edu.famper.sistemaestacionamento.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDto {
    @Schema(description ="data_criacao",
            example = "2001/06/21",
            title = "data_criacao")
    private Date data_criacao;

    @Schema(description = "data_atualizacao",
            example = "2001/06/21",
            title = "data_atualizacao")
    private Date data_atualizacao;

    @Schema(description = "status",
            example = "pago",
            title = "status",
            maxLength = 50)
    private String status;

    @Schema(description = "prioridade",
            example = "preferencial",
            title = "preferencial",
            maxLength = 100)
    private String prioridade;

}
