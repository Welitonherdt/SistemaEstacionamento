package br.edu.famper.sistemaestacionamento.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagamentoDto {
    @Schema(description = "valor",
            example = "2,50",
            title = "valor")
    private double valor;

    @Schema(description = "data_pagamento",
            example = "2001-12-06",
            title = "data_pagamento")
    private Date data_pagamento;

    @Schema(description = "status",
            example = "ativo",
            title = "status",
            maxLength = 50)
    private String  status;

    @Schema(description ="forma_pagamento",
            example = "cartao",
            title = "forma_pagamento",
            maxLength = 50)
    private String  forma_pagamento;

    @Schema(description ="email",
            example = "joao@gmail.com",
            title = "email",
            maxLength = 100)
    private String  email;


}
