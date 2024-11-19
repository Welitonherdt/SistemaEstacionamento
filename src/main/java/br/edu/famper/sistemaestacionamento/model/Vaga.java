package br.edu.famper.sistemaestacionamento.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name= "tbl_vaga")
@Data
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "vaga_id")
    private Long codigo;

    @Column(name = "data_criacao")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;

    @Column(name = "localizacao", length = 100)
    private String localizacao;

    @Column(name = "tipo", length = 20)
    private String tipo;



}
