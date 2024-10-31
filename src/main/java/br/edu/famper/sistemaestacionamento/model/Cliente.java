package br.edu.famper.sistemaestacionamento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name= "tbl_cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cliente_id")
    private Long codigo;

    @Column(name = "nome", length = 150)
    private String nome;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "email", length = 100)
    private String email;


    @OneToMany(mappedBy = "cliente", targetEntity = Ticket.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Ticket> tickets;


    @OneToMany(mappedBy = "proprietario", targetEntity = Veiculo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Veiculo> carros;
}
