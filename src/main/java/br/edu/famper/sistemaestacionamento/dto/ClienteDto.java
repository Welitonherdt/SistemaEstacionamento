package br.edu.famper.sistemaestacionamento.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {
    @Schema(description = "nome ",
            example = "Joao",
            title = "nome",
            maxLength=150)
    private String nome;

    @Schema(description = "telefone",
            example ="999999999",
            title= "telefone",
            maxLength =20)
    private String telefone;

    @Schema(description = "endereco",
            example = "Ampere",
            title = "endereco",
            maxLength = 100)
    private String endereco;

    @Schema(description = "email",
            example = "juca@gmail.com",
            title = "email",
            maxLength = 100)
    private String email;

}
